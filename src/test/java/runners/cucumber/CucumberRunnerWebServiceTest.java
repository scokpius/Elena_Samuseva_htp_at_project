package runners.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cucumber.web_service"},
        features = {"src/test/resources/features/web_service_test.feature"},
//        monochrome = false,
//        snippets = SnippetType.CAMELCASE,
        strict = false
)
public class CucumberRunnerWebServiceTest {
}

