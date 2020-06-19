package runners.cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cucumber.base_steps", "steps.cucumber.silverscreen"},
        features = {"src/test/resources/features/silverscreen.feature" },
       // tags = "@cinema",
        //   snippets = SnippetType.CAMELCASE,
        strict = false     )
public class CucumberRunnerSilverscreenTest {
}

