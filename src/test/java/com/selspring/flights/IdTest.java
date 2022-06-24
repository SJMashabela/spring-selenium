package com.selspring.flights;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"app.locale=id", "browser=firefox"})
public class IdTest extends FlightTest{
}
