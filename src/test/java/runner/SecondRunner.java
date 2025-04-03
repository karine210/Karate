package runner;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.Test;

public class SecondRunner {

    @Test
    public void runner(){
        Results results = Runner.path("src/test/resources/importedFeatures").parallel(1);
        assert results.getFailCount() == 0;
    }
}