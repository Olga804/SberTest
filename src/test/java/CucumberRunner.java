import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"steps"},
        tags = {"@all"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}
)
public class CucumberRunner {

}
