package com.selspring.page.flights;

import com.selspring.kelvin.annotation.Page;
import com.selspring.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends Base {
    @FindBy(css = "a.P4z3kc.KgqTrc")
    private List<WebElement> elements;
    public void goTo(final String url){
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }
//    @TakeScreenshot
    public List<String> getLabels(){
      return   this.elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }
    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.elements.isEmpty());
    }
}
