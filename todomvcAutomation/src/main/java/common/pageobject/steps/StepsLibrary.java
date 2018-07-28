package common.pageobject.steps;
import common.pageobject.pages.TodoReact;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

import java.util.List;


public class StepsLibrary {

    public TodoReact todoReact;

//    ToDoData toDoData = new ToDoData();


    SoftAssertions softly = new SoftAssertions();

    @Step("Opens Todo MVC")

    public void openToDo() {
        todoReact.open();

    }

    @Step("Add an item")

    public void addItem(String item){
        todoReact.enterNewTodo(item);

    }

    @Step("Check list for items")

    public void verifyItems(List<String> items){

        softly.assertThat(todoReact.getListText()).isEqualTo(items);
        softly.assertAll();

    }

    @Step("Verify footer number is equal to number of items")

    public void verifysFooterNumber(int itemCount){
        softly.assertThat(todoReact.getFooterItemCount())
                                    .isEqualTo(itemCount);
        softly.assertAll();

    }

    @Step("Click on checkbox for given item")

    public void checksOff(String item){
        todoReact.clickCheckBox(item);
    }

    @Step("Clear Completed")

    public void clearsCompletedAndVerifyItems(List<String> items){
        todoReact.clickClearCompleted();
        verifyItems(items);
    }

    @Step("Check to see items do not exist")

    public void verifyItemsDoNotExist(List<String> items){

        softly.assertThat(todoReact.getListText()).isNotEqualTo(items);
        softly.assertAll();

    }

}
