import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UsePlaywright
public class simplePlaywrightTest {

    @Test
    void titleAppearsTest(Page titlePage) {
        titlePage.navigate("https://practicesoftwaretesting.com");
        String titleName=titlePage.title();

        Assertions.assertTrue(titleName.contains("Practice Software Testing"));
    }

    @Test
    void searchFieldTest(Page titlePage){
        titlePage.navigate("https://practicesoftwaretesting.com");
        titlePage.locator("[Placeholder=Search]").fill("Pliers");
        titlePage.locator("button:has-text('Search')").click();

        int matchingSearchResult =titlePage.locator(".card").count();
        Assertions.assertTrue(matchingSearchResult>0);
    }
}
