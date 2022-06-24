package com.selspring.googletest;

import com.selspring.SpringBaseTestNGTest;
import com.selspring.kelvin.annotation.LazyAutowired;
import com.selspring.page.google.GooglePage;
import com.selspring.kelvin.service.ScreenshotService;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google1Test extends SpringBaseTestNGTest {
    @LazyAutowired
    private GooglePage googlePage;
    @LazyAutowired
    private ScreenshotService screenshotService;
    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchComponent().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        System.out.println(this.googlePage.getSearchResult().getCount());
        this.screenshotService.takeScreenShot();
        this.googlePage.close();
    }
}

