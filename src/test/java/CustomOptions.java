import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

import java.util.Arrays;



public class CustomOptions implements OptionsFactory {


    @Override
    public Options getOptions() {
        return new Options()
                .setHeadless(false)
                .setLaunchOptions(
                        new BrowserType.LaunchOptions()
                                .setArgs(Arrays.asList(
                                        "--no-sandbox",
                                        "--disable-gpu",
                                        "--disable-extensions"))
                );

    }
}
