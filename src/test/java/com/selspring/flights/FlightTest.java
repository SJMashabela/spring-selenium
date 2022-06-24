package com.selspring.flights;

import com.selspring.SpringBaseTestNGTest;
import com.selspring.page.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTest extends SpringBaseTestNGTest {
    @Autowired
    private FlightPage flightPage;
    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest(){
        this.flightPage.goTo(appDetails.getUrl());

        Assert.assertTrue(this.flightPage.isAt());
        Assert.assertEquals(this.flightPage.getLabels(), this.appDetails.getLabels());
        System.out.println(this.flightPage.getLabels()+ " ==  " + this.appDetails.getLabels() );
    }
}
