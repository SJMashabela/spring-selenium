package com.selspring.kelvin.aop;

import com.selspring.kelvin.service.ScreenshotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {
    @Autowired
    private ScreenshotService screenshotService;

//    @After("@annotation(takeScreenshot)")
//    public void after(TakesScreenshot takesScreenshot) throws IOException {
//        this.screenshotService.takeScreenShot();
//    }
}
