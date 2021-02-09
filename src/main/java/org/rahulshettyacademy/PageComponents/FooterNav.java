package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;
//SRP ->  responsible only for Footer page component
public class FooterNav extends AbstractComponent {

    By flights = By.cssSelector("[title='Flights");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver,sectionElement); // When you inherit parent class- Parent class constructor is first invoked
    }

    // method to handle flights
    // Scope of selenium execution would be in the footer section only

    public String getFlightAttribute()
    {
       return findElement(flights).getAttribute("class");
    }

    public int getLinkCount()
    {
        return findElements(links).size();
    }
}
