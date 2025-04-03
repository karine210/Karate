/*package runner;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;


public class RunnerApi {

    @Test
    public void runner(){
        Results results = Runner.path("src/test/resources/features").parallel(1);
        assert results.getFailCount() == 0;
    }
}*/

package runner;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunnerTest {

    @Test
    public void testParallel() {
        Results results = Runner.path("classpath:features")
                .parallel(1);
        assertTrue(results.getFailCount() == 0, "Il y a des échecs : " + results.getErrorMessages());
    }
}

