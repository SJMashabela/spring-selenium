package com.selspring.kelvin.config;

import com.selspring.kelvin.annotation.LazyConfiguration;
import com.selspring.kelvin.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;


@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

    @ThreadScopeBean
    @ConditionalOnProperty(name="browser", havingValue = "firefox")    //   <- @ConditionalOnProperty is better than -> @Primary used to identify the driver to be used.
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver() .setup();
        return new FirefoxDriver();
    }
    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver() .setup();
       return new ChromeDriver();
    }


}
