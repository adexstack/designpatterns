package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;
import org.rahulshettyacademy.AbstractComponents.StrategyFactor;
import org.rahulshettyacademy.PageComponents.FooterNav;
import org.rahulshettyacademy.PageComponents.NavigationBar;

import java.util.HashMap;

//SRP -> TravelHomePage is responsible only for navigating to respective page component
public class TravelHomePage {

    WebDriver driver;
    By footerNavSectionElement =  By.id("traveller-home");
    By navBarSectionElement = By.id("buttons");
    SearchFlightAvail searchFlightAvail;


    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //driver.manage().window().maximize();
    }

    public NavigationBar getNavigationBar()
    {
        return new NavigationBar(driver,navBarSectionElement);
    }

    public FooterNav getFooterNav()
    {
        return new FooterNav(driver,footerNavSectionElement);
    }


    // Using SearchFlightAvail interface as the return type to achieve Strategy Design Pattern
    public void setBookingStrategy(String strategyType){
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail = strategyFactor.createStrategy(strategyType);
        this.searchFlightAvail = searchFlightAvail;
    }

    public void checkAvail(HashMap<String,String> reservationDetails)
    {
        searchFlightAvail.checkAvail(reservationDetails);
    }

    public String getTitle()
    {
        System.out.println("Hello");
        return driver.getTitle();
    }
}
