package playlistRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features={"src\\test\\resources\\featureFile\\Playlist.feature"},
		glue= {"playlistSteps"},
		plugin= {"pretty"},
		publish=true
		
		)
public class ProjectRunner extends AbstractTestNGCucumberTests {

}
