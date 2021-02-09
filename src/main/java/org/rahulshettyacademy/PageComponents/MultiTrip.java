package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {
    //*[@id="ctl00_mainContent_rbtnl_Trip_2"]

    //*[@id="ctl00_mainContent_ddl_originStation2_CTXT"]
    // //*[@id="dropdownGroup1"]/div/ul[2]/li[1]/a

    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By multiCity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By destination_2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By modalPopUp = By.id("MultiCityModelAlert");


    private By cb = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {

        makeStateReady(s->selectOriginCity(reservationDetails.get("origin"))); // Execute around design pattern
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));
        //findElement(cb).click();
        //findElement(search).click();

    }

    public void selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestinationCity2(String destination2)
    {
        findElement(destination_2).click();
        findElement(By.xpath("//a[@value='"+destination2+"'])[3]")).click();
    }

    //Execute around design pattern : Write all common prerequisite codes/teardown. Handles boilerplate(common) code before and after business methods.
    public void makeStateReady(Consumer<MultiTrip> consumer){
        System.out.println("I am inside Multi trip");
        findElement(multiCity_rdo).click();
        findElement(modalPopUp).click();
        waitForElementToDisappear(modalPopUp);
        consumer.accept(this);
        System.out.println("I am done");
    }

}
