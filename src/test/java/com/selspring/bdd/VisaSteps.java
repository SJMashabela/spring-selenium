package com.selspring.bdd;

import com.selspring.kelvin.annotation.LazyAutowired;
import com.selspring.page.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;
import org.testng.Assert;

import java.time.LocalDate;
//@SpringBootTest
public class VisaSteps {
    @LazyAutowired
    private VisaRegistrationPage registrationPage;
    @Given("I am on VISA registration form")
    public void launchSite(){
        this.registrationPage.goTo();
        Assert.assertTrue(this.registrationPage.isAt());
    }
    @When("I select my from country {string} and to country {string}")
    public void selectCountry(String from, String to){
        this.registrationPage.setCountryFromAndTo(from,to);
    }
    @When("I enter my dob as {string}")
    public void enterDob(String dob){
        this.registrationPage.setBirthDate(LocalDate.parse(dob));
    }
    @When("I enter my name as {string} and {string}")
    public void enterNames(String fn, String ln){
        this.registrationPage.setNames(fn,ln);
    }
    @When("I enter my contact details as {string} and {string}")
    public void enterContactDetails(String email, String phone){
        this.registrationPage.setContactDetails(email, phone);
    }
    @When("I enter the comment {string}")
    public void enterComment(String comment){
        this.registrationPage.setComments(comment);
    }
    @When("I submit the form")
    public void submit(){
        this.registrationPage.submit();
    }
    @Then("I should get the confirmation number")
    public void verifyConfirmation(){
        boolean isEmpty = this.registrationPage.getConfirmationNumber().isEmpty();
        Assert.assertFalse(isEmpty);
    }
}
