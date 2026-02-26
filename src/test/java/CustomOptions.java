import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

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
