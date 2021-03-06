package com.selspring.kelvin.service;

import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
@Lazy
@Service
public class ScreenshotService {
    @Autowired
    private ApplicationContext ctx; // use to create an instance of the TakeScreenShot class at run time
    @Value("${screenshot.path}")
    private Path path;
    @Autowired
    private Faker faker;

    public void takeScreenShot() throws IOException {
       File srcFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE); // use the instance of the TakeScreenShot class at run time
       FileCopyUtils.copy(srcFile, this.path.resolve(faker.name().firstName() + ".png").toFile());
    }
    public byte[] getScreenshot(){
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}
