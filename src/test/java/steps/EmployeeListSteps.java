package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EmployeeListPage;

public class EmployeeListSteps {

    EmployeeListPage employeeListPage = new EmployeeListPage();

    @When("they select Job Title {string}")
    public void theySelectJobTitle(String jobTitle) {
        employeeListPage.selectJobTitle(jobTitle);
    }

    @And("they click Search Employee")
    public void theyClickSearchEmployee() {
        employeeListPage.clickSearchEmployee();
    }

    @Then("they see employees with job title {string}")
    public void theySeeEmployeesWithJobTitle(String jobTitle) {
        employeeListPage.assertOnlySpecificJobTitlesAreDisplayed(jobTitle);
    }

    @When("they click checkbox next to employee ID {string}")
    public void theyClickCheckboxNextToEmployeeID(String employeeId) {
        employeeListPage.clickCheckboxNextToEmployeeID(employeeId);
    }

    @Then("checkbox is checked for employee {string}")
    public void checkboxIsChecked(String employeeId) {
        employeeListPage.assertCheckboxIsCheckedForEmployeeID(employeeId);
    }
}
