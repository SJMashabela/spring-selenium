package com.selspring.googletest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.selspring.bdd",
        tags = "@visa",
        plugin = {
                "pretty",
                "html:com/selspring/googletest/images/"
        }
)
public class GoogleRunner  extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
