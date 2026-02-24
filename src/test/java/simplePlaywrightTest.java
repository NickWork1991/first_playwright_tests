import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class simplePlaywrightTest {


    @Test
    void titleAppearsTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page titlePage = browser.newPage();

        titlePage.navigate("https://practicesoftwaretesting.com");
        String titleName=titlePage.title();

        Assertions.assertTrue(titleName.contains("Practice Software Testing"));
        browser.close();
        playwright.close();
    }
}
