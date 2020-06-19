package runners.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cucumber.base_steps", "steps.cucumber.booking"},
        features = {"src/test/resources/features/booking_city_test.feature",
                    "src/test/resources/features/booking_create_new_user_test.feature",
                    "src/test/resources/features/booking_favorite_hotels_test.feature",
                    "src/test/resources/features/booking_header_elements_test.feature"
                    },
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        strict = false
)
public class CucumberRunnerBookingTest {

}
