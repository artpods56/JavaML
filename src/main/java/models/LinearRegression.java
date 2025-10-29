package models;

import cost.MSE;
import utils.ArrayValidator;

import java.util.ArrayList;

public class LinearRegression {
    private double slope;
    private double intercept;
    private boolean isFitted;
    private double learningRate;
    private int epochs;
    private MSE mse;


    public LinearRegression(double learningRate, int epochs) throws Exception{
        this.validateModelParams(learningRate, epochs);
        this.slope = 1;
        this.intercept = 1;
        this.isFitted = false;
        this.learningRate = learningRate;
        this.epochs = epochs;
        this.mse = new MSE();
    }

    private void validateModelParams(double learningRate, int epochs) throws Exception{
        if (learningRate == 0) {
            throw new Exception("The model can't be initialized with learning rate set to 0.0");
        }

        if (epochs == 0) {
            throw new Exception("The model won't run of the number of epochs is set to 0");
        }
    }

    private double compute(double x){
        return (this.slope * x) + this.intercept;
    }

    private double computeSlopeDerivative(ArrayList<Double> xArray, ArrayList<Double> yTrue, ArrayList<Double> yPred) {

        double derivativeSum = 0;

        for (int i = 0; i < yTrue.size(); i++) {
            derivativeSum += xArray.get(i)*(yTrue.get(i) - yPred.get(i));
        }

        return (-2 * derivativeSum) / xArray.size();
    }

    private double computeInterceptDerivative(ArrayList<Double> yTrue, ArrayList<Double> yPred) {

        double derivativeSum = 0;

        for (int i = 0; i < yTrue.size(); i++) {
            derivativeSum += (yTrue.get(i) - yPred.get(i));
        }

        return (-2 * derivativeSum) / yTrue.size();
    }

    public void fit(ArrayList<Double> xArray, ArrayList<Double> yTrue) throws Exception {
        ArrayValidator.validateInputs(yTrue,xArray);

        for (int i = 0; i < this.epochs; i++) {
            ArrayList<Double> yPred = this.predict(xArray);

            this.slope = this.slope - (this.learningRate * this.computeSlopeDerivative(xArray, yTrue, yPred));
            this.intercept = this.intercept - (this.learningRate * this.computeInterceptDerivative(yTrue, yPred));

            if (i % 10 == 0) {
                double mse = this.mse.computeCost(yTrue, yPred);
                System.out.printf("Epoch: " + i + ", Loss: " + mse);
            }

        }

        this.isFitted = true;



    }

    public ArrayList<Double> predict(ArrayList<Double> xArray) {
        ArrayList<Double> result = new ArrayList<Double>();
        for (Double value : xArray) {
            result.add(this.compute(value));
        }
        return result;
    }
}


