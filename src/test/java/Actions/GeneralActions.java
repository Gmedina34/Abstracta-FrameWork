package Actions;



import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Driver;

public class GeneralActions {

	
	@FindBy(xpath = "//*[@id=\"UY\"]")
	WebElement country;

	@FindBy(xpath = "//h2[@class='ui-search-item__title shops__item-title']")

	List<WebElement> Names;

	@FindBy(css = "html > body > main > div > div:nth-child(3)>section>ol>li>div:nth-child(1)>div>div>div>div>div>div>div>div>span:nth-child(1)>span:nth-child(3)")

	List<WebElement> Price;

	@FindBy(xpath = "//a[@class='ui-search-item__group__element shops__items-group-details ui-search-link']")

	List<WebElement> links;

	@FindBy(name = "as_word")

	WebElement SearchField;

	@FindBy(xpath = "//button[@class='cookie-consent-banner-opt-out__action cookie-consent-banner-opt-out__action--primary cookie-consent-banner-opt-out__action--key-accept']")

	WebElement consentBanner;

	@FindBy(xpath = "//a[@title='Siguiente']")
	WebElement next;

	public GeneralActions() {
		PageFactory.initElements(Driver.driver, this);
	}

	public void SelectCountry() {

		country.click();
	}

	public void Search(String String) {

		SearchField.sendKeys(String);
		SearchField.submit();

	}

	public void cookiesBanner() {

		WebDriverWait wait = new WebDriverWait(Driver.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(consentBanner));

		consentBanner.click();

	}

	public void Next() {

		WebDriverWait wait = new WebDriverWait(Driver.driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(next));

		next.click();
	}

	public List<String> getItemNames() {

		return Names.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<String> getItemPrices() {

		return Price.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<String> getItemLinks() {

		return links.stream().map(element -> element.getAttribute("href")).collect(Collectors.toList());
	}

}
