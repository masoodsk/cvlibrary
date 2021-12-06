package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class JobSearchPage {

	public JobSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	@FindBy(id = "keywords")
	WebElement txt_keywords;

	@FindBy(id = "location")
	WebElement txt_location;

	@FindBy(id = "toggle-hp-search")
	WebElement btn_moreSearchOptions;

	@FindBy(id = "distance")
	WebElement select_distance;

	@FindBy(id = "salarymin")
	WebElement txt_salarymin;

	@FindBy(id = "salarymax")
	WebElement txt_salarymax;

	@FindBy(id = "salarytype")
	WebElement select_salarytype;

	@FindBy(id = "tempperm")
	WebElement select_jobtype;

	@FindBy(id = "hp-search-btn")
	WebElement btn_findJobs;

	@FindBy(xpath = "//body/div[4]/div")
	List<WebElement> keyword_autosuggest;

	@FindBy(xpath = "//body/div[3]/div")
	List<WebElement> locaion_autosuggest;

	public void enterKeywords(String keywords) throws InterruptedException {
		txt_keywords.sendKeys(keywords);
		// Thread.sleep(2000);

		for (WebElement option : keyword_autosuggest) {

			if (option.getText().equalsIgnoreCase("Javascript Developer")) {

				option.click();
				break;
			}

			if (option.getText().equalsIgnoreCase("Java Developer")) {

				option.click();
				break;
			}

		}
	}

	public void enterLocation(String location) throws InterruptedException {

		for (int i = 0; i < location.length(); i++) {
			txt_location.clear();

			txt_location.sendKeys(location.substring(0, i + 1));
			txt_location.sendKeys(Keys.ARROW_UP);

			Thread.sleep(500);

			try {

				if (driver.findElement(By.xpath("//*[contains(text() , '" + location + "')]")).isDisplayed()) {

					driver.findElement(By.xpath("//*[contains(text() , '" + location + "')]")).click();
					break;
				}
			} catch (Exception e) {

			}

		}

	}

	public void selectDistance(String distance) {

		Select miles = new Select(select_distance);
		miles.selectByValue(distance);


	}

	public void clickMoreSearchOptions() {
		btn_moreSearchOptions.click();
	}

	public void enterSalaryMin(String salaryMin) {

		txt_salarymin.sendKeys(salaryMin);
	}

	public void enterSalaryMax(String salaryMax) {

		txt_salarymax.sendKeys(salaryMax);
	}

	public void selectSalaryType(String salaryType) {

		Select selectSalaryType = new Select(select_salarytype);
		selectSalaryType.selectByValue(salaryType);

	}

	public void selectJobType(String jobType) {

		Select selectJobType = new Select(select_jobtype);
		selectJobType.selectByValue(jobType);

	}

	public void clickfindJOBS() {

		btn_findJobs.click();
	}

}
