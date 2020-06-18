package runners.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import steps.junit4.web_service.HttpRequestSteps;

@RunWith(Suite.class)
@Suite.SuiteClasses({HttpRequestSteps.class})
public class JUnitRunnerWebServiceTest {
}
