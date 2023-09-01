package Steps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Actions.GeneralActions;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MercadoLibreSteps {

	GeneralActions general;

	@Given("that I am on the MercadoLibre homepage {string}")
	public void that_i_am_on_the_mercado_libre_homepage(String url) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		Driver.driver = new ChromeDriver();

		Driver.driver.manage().window().maximize();

		Driver.driver.get(url);

		WebDriverWait wait = new WebDriverWait(Driver.driver, 10);
		wait.until(ExpectedConditions.urlContains(url));

		general = new GeneralActions();

	}

	@When("I select the search country")
	public void i_select_the_search_country() {

		general.SelectCountry();

	}

	@When("I perform a search for {string}")
	public void i_perform_a_search_for(String string) {

		general.Search(string);

	}

	@Then("I obtain the item information from the first three pages")
	public void i_obtain_the_item_information_from_the_first_three_pages() throws InterruptedException, IOException {

		general.cookiesBanner();

		for (int page = 1; page <= 3; page++) {

			List<String> Names = general.getItemNames();
			List<String> Price = general.getItemPrices();
			List<String> links = general.getItemLinks();

			File file = new File(

					"C:\\Users\\Gusta\\eclipse-workspace\\Abstracta-FrameWork\\src\\test\\resources\\ShirtsInfo_Page"
							+ page + ".txt");
			FileWriter fw = new FileWriter(file);

			for (int i = 0; i < Names.size(); i++) {

				fw.write("Item Name: " + Names.get(i) + "\n");
				fw.write("Item Price: " + Price.get(i) + "\n");
				fw.write("Item Link: " + links.get(i) + "\n");
				fw.write("\n");

			}
			fw.close();

			general.Next();

		}

		Driver.driver.quit();

	}

}
