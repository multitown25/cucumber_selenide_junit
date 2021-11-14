import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.codeborne.selenide.Configuration;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps"},
        features = {"src/test/java/features"})
public class CucumberTestOptions {

    @BeforeClass
    static public void setupTimeOut() {
        Configuration.headless = true;
    }
}


