package com.selspring.visa;

import com.selspring.SpringBaseTestNGTest;
import com.selspring.entity.User;
import com.selspring.page.visa.VisaRegistrationPage;
import com.selspring.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;

public class UserVisaTest extends SpringBaseTestNGTest {
    private static final Logger logger = LoggerFactory.getLogger(VisaRegistrationPage.class);
    @Autowired
    private UserRepository repository;

    @Autowired
    private VisaRegistrationPage registrationPage;

    @Test(dataProvider = "getData")
    public void visaTest(User u) {

            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();
            logger.warn("Found name");
            System.out.println(
                    u.getFirstName() + " " + u.getLastName()

            );

    }
    @DataProvider
    public Object[] getData(ITestContext context){
        return this.repository.findAll()
                .stream()
                .limit(7)
                .toArray();
    }

}
