package todotests;

import common.pageobject.steps.StepsLibrary;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@RunWith(SerenityRunner.class)


@WithTags({
        @WithTag("UI")
})
public class UITests {

    @Managed
    WebDriver driver;

    @Steps
    StepsLibrary user;


    @Test

    public void userCanAddItemToList(){
        String firstItem = "Purchase Shampoo";
        List<String> items = new ArrayList<>();
        items.add(firstItem);

        user.openToDo();
        user.addItem(firstItem);
        user.verifyItems(items);
    }

    @Test

    public void addTwoMoreItems(){
        String firstItem = "Purchase Shampoo";
        String secondItem = "Wash Cat";
        String thirdItem ="Purchase band-aid";


        List<String> items = new ArrayList<>();
        //add first item to data list
        items.add(firstItem);

        //fulfill r1-r2
        user.openToDo();
        user.addItem(firstItem);
        user.verifyItems(items);


        //add next two items to data list
        items.add(secondItem);
        items.add(thirdItem);

        // fulfill r3-r4
        user.addItem(secondItem);
        user.addItem(thirdItem);
        user.verifyItems(items);

        //fulfill r5
        user.verifysFooterNumber(3);


    }


    @Test

    public void userChecksOffItem(){

        // Set name of items
        String firstItem = "Purchase Shampoo";
        String secondItem = "Wash Cat";
        String thirdItem ="Purchase band-aid";

        //create list of items to add and compare to
        List<String> items = new ArrayList<>();
        items.add(firstItem);
        items.add(secondItem);
        items.add(thirdItem);


        // open application and add all items
        user.openToDo();
        user.addItem(firstItem);
        user.addItem(secondItem);
        user.addItem(thirdItem);

        // verify items exist in to do list
        user.verifyItems(items);

        // checks off "Wash Cat"
        user.checksOff("Wash Cat");

        // Verifies that to do list count is now 2
        user.verifysFooterNumber(2);
    }


    @Test

    public void userCanClearCompletedItems(){
        String firstItem = "Purchase Shampoo";
        String secondItem = "Wash Cat";
        String thirdItem ="Purchase band-aid";

        List<String> items = new ArrayList<>();
        items.add(firstItem);
        items.add(secondItem);
        items.add(thirdItem);

        // open application and add all items
        user.openToDo();
        user.addItem(firstItem);
        user.addItem(secondItem);
        user.addItem(thirdItem);

        // checks off wash cat
        user.checksOff(secondItem);
        items.remove(secondItem);

        //clears completed and verifies how many items left on list
        user.clearsCompletedAndVerifyItems(items);
        user.verifysFooterNumber(2);

    }



}

