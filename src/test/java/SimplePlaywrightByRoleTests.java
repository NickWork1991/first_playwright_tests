import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.util.Arrays;

public class SimplePlaywrightTestsPLAndLabels {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;
    String BASE_URL="https://practicesoftwaretesting.com";
    Page titlepage;
    Page registrPage;

    @DisplayName("Test by using Labels")

    @BeforeAll
    static void setUpAll(){
        playwright = Playwright.create();
        browser= playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(Arrays.asList("--no-sandbox",
                                "--disabled-gpu",
                                "--disabled-exceptions"))
        );
        browserContext=browser.newContext();
    }
    @BeforeEach
    void setUp(){
        titlepage=browserContext.newPage();
    }
    @AfterEach
    void tearDown(){
        browser.close();
        playwright.close();
    }

    @Test
    void byRole(){
        titlepage.navigate(BASE_URL);
        titlepage.getByText("Sign In").click();

       Locator loginHeading= titlepage.getByRole(AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("Login"));

       PlaywrightAssertions.assertThat(loginHeading).isVisible();
    }
}
