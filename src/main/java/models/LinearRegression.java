package models;

import utils.ArrayValidator;

import java.util.ArrayList;

public class LinearRegression {
    private double slope;
    private double intercept;
    private boolean isFitted;


    private double compute(double x){
        return (this.slope * x) + this.intercept;
    }

    public void fit(ArrayList<Double> x, ArrayList<Double> y) throws Exception {
        ArrayValidator.validateInputs(y,x);

    }

    public ArrayList<Double> predict(ArrayList<Double> xArray) {
        ArrayList<Double> result = new ArrayList<Double>();
        for (Double value : xArray) {
            result.add(this.compute(value));
        }
        return result;
    }
}


