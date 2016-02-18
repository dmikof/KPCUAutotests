package com.agilefusion.selenium.config;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.*;

import static org.openqa.selenium.remote.CapabilityType.PROXY;

public enum DriverType implements DriverSetup {

    FIREFOX {
        public DesiredCapabilities getDesiredCapabilities(Proxy proxySettings) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            return addProxySettings(capabilities, proxySettings);
        }

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            String xvfbPropsFile = System.getProperty("xvfb.display");
            System.out.println("xvfbPropsFile = " + xvfbPropsFile);
            FirefoxBinary ffox = new FirefoxBinary();
            ffox.setEnvironmentProperty("DISPLAY", xvfbPropsFile);
            return new FirefoxDriver(ffox, new FirefoxProfile(), capabilities );
        }
    },
    CHROME {
        public DesiredCapabilities getDesiredCapabilities(Proxy proxySettings) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
            HashMap<String, String> chromePreferences = new HashMap<String, String>();
            chromePreferences.put("profile.password_manager_enabled", "false");
            chromePreferences.put("start-maximized", "true");
            capabilities.setCapability("chrome.prefs", chromePreferences);
            return addProxySettings(capabilities, proxySettings);
        }

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            String xvfbPropsFile = System.getProperty("xvfb.display");
            Map<String, String> env = new HashMap<>();
            env.put("DISPLAY", xvfbPropsFile);
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .withEnvironment(env)
                    .build();
            return new ChromeDriver(service, capabilities);
        }
    },
    IE {
        public DesiredCapabilities getDesiredCapabilities(Proxy proxySettings) {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
            capabilities.setCapability("requireWindowFocus", true);
            return addProxySettings(capabilities, proxySettings);
        }

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            return new InternetExplorerDriver(capabilities);
        }
    },
    SAFARI {
        public DesiredCapabilities getDesiredCapabilities(Proxy proxySettings) {
            DesiredCapabilities capabilities = DesiredCapabilities.safari();
            capabilities.setCapability("safari.cleanSession", true);
            return addProxySettings(capabilities, proxySettings);
        }

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            return new SafariDriver(capabilities);
        }
    },
    OPERA {
        public DesiredCapabilities getDesiredCapabilities(Proxy proxySettings) {
            DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
            return addProxySettings(capabilities, proxySettings);
        }

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            return new OperaDriver(capabilities);
        }
    },
    PHANTOMJS {
        public DesiredCapabilities getDesiredCapabilities(Proxy proxySettings) {
            DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
            final List<String> cliArguments = new ArrayList<String>();
            cliArguments.add("--web-security=false");
            cliArguments.add("--ssl-protocol=any");
            cliArguments.add("--ignore-ssl-errors=true");
            capabilities.setCapability("phantomjs.cli.args", applyPhantomJSProxySettings(cliArguments, proxySettings));
            capabilities.setCapability("takesScreenshot", true);

            return capabilities;
        }

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            return new PhantomJSDriver(capabilities);
        }
    };

    protected DesiredCapabilities addProxySettings(DesiredCapabilities capabilities, Proxy proxySettings) {
        if (null != proxySettings) {
            capabilities.setCapability(PROXY, proxySettings);
        }

        return capabilities;
    }

    protected List<String> applyPhantomJSProxySettings(List<String> cliArguments, Proxy proxySettings) {
        if (null == proxySettings) {
            cliArguments.add("--proxy-type=none");
        } else {
            cliArguments.add("--proxy-type=http");
            cliArguments.add("--proxy=" + proxySettings.getHttpProxy());
        }
        return cliArguments;
    }
}