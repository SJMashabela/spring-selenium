package com.selspring.window;

import com.selspring.SpringBaseTestNGTest;
import com.selspring.kelvin.service.WindowSwitchService;
import com.selspring.page.window.MainPage;
import com.selspring.page.window.PageA;
import com.selspring.page.window.PageB;
import com.selspring.page.window.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=firefox")
public class WindowSwitchTest extends SpringBaseTestNGTest {
    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private PageC pageC;

    @BeforeClass
    public void setup(){
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }
    @Test(dataProvider = "getData")
    public void switchTest(int index) throws InterruptedException {
        Thread.sleep(3000);
        this.pageA.addToArea(index +"\n");
        this.pageB.addToArea((index * 2) +"\n");
        this.pageC.addToArea((index * 3)+"\n");

    }
    @DataProvider
    public Object[] getData(){
        return new Object[]{
                3,
                4,
                1,
                5,
                6,
                2
        };
    }
}
