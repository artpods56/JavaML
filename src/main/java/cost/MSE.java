package cost;

import utils.ArrayValidationException;
import utils.ArrayValidator;

import java.util.ArrayList;

interface CostFunction {
    double computeCost(ArrayList<Double> yTrue, ArrayList<Double> yPred) throws Exception;
}

abstract class CostMetric implements CostFunction {
}


public class MSE extends CostMetric {

    @Override
    public double computeCost(ArrayList<Double> yTrue, ArrayList<Double> yPred) throws Exception {
        ArrayValidator.validateInputs(yTrue, yPred);


        int m = yPred.size();

        double sum = 0.0;

        for (int i = 0; i < m; i++) {
            sum += Math.pow((yPred.get(i) - yTrue.get(i)),2);
        }

        return sum/m;
    }
}
