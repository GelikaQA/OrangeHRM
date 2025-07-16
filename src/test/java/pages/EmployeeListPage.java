package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static tools.CommonTools.getByObject;
import static tools.CommonTools.sleep;

public class EmployeeListPage extends BasePage {

    private static final String JOB_TITLE_DROPDOWN = "id=empsearch_job_title";
    private static final String SEARCH_EMPLOYEE_BUTTON = "id=searchBtn";
    private static final String JOB_TITLE_CELLS = "xpath=//table[@id='resultTable']//tbody//tr/td[5]";

    public static String getJobTitleDropdown() {
        return JOB_TITLE_DROPDOWN;
    }

    public static String getSearchEmployeeButton() {
        return SEARCH_EMPLOYEE_BUTTON;
    }

    public static String getJobTitleCells() {
        return JOB_TITLE_CELLS;
    }

    public static String getEmployeeIdCheckbox(String employeeId) {
        return "xpath=//table[@id='resultTable']//tr[contains(., '" + employeeId + "')]//input[@type='checkbox']";
    }

    public void selectJobTitle(String jobTitle) {
        wait.forElementToBeDisplayed(10, getByObject(getJobTitleDropdown()), "Job Title dropdown");
        WebElement dropdownElement = driver.findElement(getByObject(getJobTitleDropdown()));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(jobTitle);
    }

    public void clickSearchEmployee() {
        driver.findElement(getByObject(getSearchEmployeeButton())).click();
    }

    public void assertOnlySpecificJobTitlesAreDisplayed(String expectedJobTitle) {
        List<WebElement> jobTitleCells = driver.findElements(getByObject(getJobTitleCells()));

        for (WebElement cell : jobTitleCells) {
            String actualJobTitle = cell.getText().trim();
            Assert.assertEquals("Job title mismatch", expectedJobTitle, actualJobTitle);
            System.out.println("Job title: " + actualJobTitle); //leaving this here, so you can troubleshoot if it selected correctly
        }
    }

    public void clickCheckboxNextToEmployeeID(String employeeId) {
        WebElement checkbox = driver.findElement(getByObject(getEmployeeIdCheckbox(employeeId)));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void assertCheckboxIsCheckedForEmployeeID(String employeeId) {
        WebElement checkbox = driver.findElement(getByObject(getEmployeeIdCheckbox(employeeId)));
        Assert.assertTrue("Checkbox should be selected", checkbox.isSelected());
    }
}
