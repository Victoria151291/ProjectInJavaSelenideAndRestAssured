package UI.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.assertEquals;

public class Page {

    /**
     * clicks on the web element by left mouse's button
     *
     * @param elementXpath - xpath of the web element to click
     */
    public Page clickOnElementByLMB(String elementXpath) {
        $x(elementXpath).click();
        return this;
    }

    /**
     * sets value into the field
     *
     * @param fieldXpath - xpath of the field
     * @param value      - value of the field
     */
    public Page clearAndSetValueIntoField(String fieldXpath, String value) {
        $x(fieldXpath).clear();
        $x(fieldXpath).setValue(value);
        return this;
    }

    public Page selectDropDownItem(String dropDownXpath, String itemXpath) {
        $x(dropDownXpath).click();
        $x(itemXpath).click();
        return this;
    }

    /**
     * checks if the element exists on the page
     *
     * @param elementXpath - xpath of the web element
     */
    public void checkThatElementExists(String elementXpath) {
        $x(elementXpath).should(Condition.exist);
    }

    /**
     * gets the text of an element and compares it with the value to match
     *
     * @param elementXpath - xpath of the web element
     * @param matchText    - the text to match
     */
    public Page getVisibleTextAndAssertIt(String elementXpath, String matchText) {
        String elementText = $x(elementXpath).getText();
        assertEquals(elementText, matchText);
        return this;
    }

    /**
     * takes an element and moves it according to the new coordinates
     *
     * @param elementXpath - xpath of the web element
     * @param xOffset      - X coordinate
     * @param yOffset      - Y coordinate
     */
    public Page dragAndDrop(String elementXpath, int xOffset, int yOffset) {
        actions()
                .clickAndHold($x(elementXpath))
                .moveByOffset(xOffset, yOffset)
                .release()
                .build()
                .perform();
        return this;
    }
}