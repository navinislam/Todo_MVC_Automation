package common.pageobject.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TodoReact extends PageObject {

    /*
           SELECTORS
        */
    private static final String TODO_INPUT = "className:new-todo";
    private static final String LIST_ITEM = "div > section > ul > li";

    private static final String ITEM_COUNT = "css: div > footer > span > strong";

    private static final String CLEAR_COMPLETED = "className: clear-completed";

    /*
        ACTIONS
     */

    public void enterNewTodo(String todo){
        $(TODO_INPUT).sendKeys(todo);
        $(TODO_INPUT).sendKeys(Keys.RETURN);

    }

    public List<String> getListText (){
        List <WebElement> listItems = getDriver().findElements(By.cssSelector(LIST_ITEM));
        List<String> fieldValues = new ArrayList<>();
        for( WebElement e : listItems){
            fieldValues.add(e.getText());
        }
        return fieldValues;
    }


    public int getNumberOfItems (){
        List <WebElement> listItems = getDriver().findElements(By.cssSelector(LIST_ITEM));

        return listItems.size();
    }


    public int getFooterItemCount(){

      return Integer.parseInt($(ITEM_COUNT).getText());
    }


    public void clickCheckBox (String selection){
        List <WebElement> listItems = getDriver().findElements(By.cssSelector(LIST_ITEM));
        for( WebElement e : listItems){
            if (e.getText().equalsIgnoreCase(selection)){
                e.findElement(By.cssSelector("input.toggle")).click();
            }
        }
    }

    public void clickClearCompleted(){
        $(CLEAR_COMPLETED).click();
    }

}
