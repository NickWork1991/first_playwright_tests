import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.*;

import java.util.Arrays;

@UsePlaywright ()
public  class simplePlaywrightTest {

        private static Playwright playwright;
        private static Browser browser;
        private   static BrowserContext browserContext;
        Page titlePage;

        @BeforeAll
        static void setUpAll(){
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setArgs(Arrays.asList("--no-sandbox",
                                    "--disable-gpu",
                                    "--disable-extensions"))
            );
            browserContext=browser.newContext();
        }

        @BeforeEach
        void setUp(){
            titlePage= browserContext.newPage();
        }
        @AfterAll
        static void tearDown(){
            browser.close();
            playwright.close();
        }

        @Test
        void titleAppearsTest() {
            titlePage.navigate("https://practicesoftwaretesting.com");
            String titleName = titlePage.title();
            Assertions.assertTrue(titleName.contains("Practice Software Testing"));
        }
        @Test
        void searchFieldTest() {
            titlePage.navigate("https://practicesoftwaretesting.com");
            titlePage.locator("[Placeholder=Search]").fill("Pliers");
            titlePage.locator("button:has-text('Search')").click();

            int matchingSearchResult = titlePage.locator(".card").count();
            Assertions.assertTrue(matchingSearchResult > 0);
        }
}
