package runner;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.Test;


public class RunnerApi {

    @Test
    public void runner(){
        Results results = Runner.path("src/test/resources/features").parallel(1);
        assert results.getFailCount() == 0;
    }
}
