package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefinitions.CukeHooks;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/order.feature",
        tags = "@UITest and @Smoke",
        glue = {"stepdefinitions"},
        plugin = {"pretty","html:Reports/cucumberHTMLReport.html",
				"json:Reports/cucumberJSONReport/jsonreport"},

		monochrome = true
)
public class TestsRunner {

    private TestsRunner() {

    }

    protected static final Logger LOG = LoggerFactory.getLogger(TestsRunner.class);
    protected static Integer passedCount;
    protected static Integer failedCount;
    protected static String finalOutput = "{\"moduleName\":regressiontest_ui/regressiontest_api/regressiontest_rwd_ui,\"pass\":passCount,\"fail\":failCount,\"status\":In Progress/Pass/Fail};";

    @BeforeClass
    public static void beforeClass() {
        LOG.info("########### INSIDE BEFORE CLASS ###########");
        CukeHooks.passedCount = 0;
        CukeHooks.failedCount = 0;


    }


    @AfterClass
    public static void afterSuite() {

        String status = "PASS";
        if (CukeHooks.failedCount > 0) {
            status = "FAIL";
        }


    }
}
