/*import runner.SecondRunner;
import utils.APICall;

import java.io.IOException;

import static utils.APICall.*;
import static utils.JsonConcatenator.concatenateJsonFiles;

public class Main {

    static String generatedToken;

    public static void main(String[] args) {
        generatedToken = APICall.token;
        //generatedToken = generateToken();
        getFeatures(generatedToken);

        JUnitCore.runClasses(SecondRunner.class);


        try {
            concatenateJsonFiles("target/surefire-reports/", "target/combined.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        jsonExportXray(generatedToken);
    }

}
*/