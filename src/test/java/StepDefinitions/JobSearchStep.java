package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.JobSearchPage;
import resources.BaseClass;

public class JobSearchStep extends BaseClass {

	WebDriver driver = null;
	JobSearchPage jsp;

	public JobSearchStep() throws IOException, InterruptedException {
		driver = super.initializeDriver();
		jsp = new JobSearchPage(driver);
	}

	@Given("The user is on Job Search Page")
	public void the_user_is_on_Job_Search_Page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		jsp.clickMoreSearchOptions();
		 Thread.sleep(2000);

	}

	@When("Click on More Search Options")
	public void click_on_More_Search_Options() throws InterruptedException {
	}

	@When("User Enters {string} , {string} and selects {string}")
	public void user_Enters_and_selects(String keywords, String location, String distance) throws InterruptedException {

		jsp.enterKeywords(keywords);
		jsp.enterLocation(location);
		jsp.selectDistance(distance);
	

	}
	
	@When("User Enters {string}, {string} ,")
	public void user_Enters(String salaryMin, String salaryMax) {
	    // Write code here that turns the phrase above into concrete actions
	 jsp.enterSalaryMin(salaryMin);
	 jsp.enterSalaryMax(salaryMax);
	   
	}

	@When("USer Selects {string} and {string}")
	public void user_Selects_and(String salaryType, String jobType) {
	    jsp.selectSalaryType(salaryType);
	    jsp.selectJobType(jobType);
	}
	
	

	@When("Click on FIND JOBS")
	public void click_on_FIND_JOBS() {
		jsp.clickfindJOBS();
	}

	@Then("User is navigated to search results page")
	public void user_is_navigated_to_search_results_page() throws IOException, InterruptedException{
		// Write code here that turns the phrase above into concrete actions
		System.out.println("In Step user_is_navigated_to_search_results_page");

		Thread.sleep(5000);
		//driver.close();
		//driver.quit();

	}



}
