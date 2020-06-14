package runners.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import steps.webservis.HttpRequestSteps;

@RunWith(Suite.class)
@Suite.SuiteClasses({HttpRequestSteps.class})
public class JUnitRunnerWebServisTest {
}
