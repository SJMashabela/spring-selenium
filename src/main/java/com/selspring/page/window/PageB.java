package com.selspring.page.window;

import com.selspring.kelvin.annotation.Page;
import com.selspring.kelvin.annotation.Window;
import com.selspring.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page B")
public class PageB extends Base {
    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg){
        this.textArea.sendKeys(msg);
    }
    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.textArea.isDisplayed());
    }
}