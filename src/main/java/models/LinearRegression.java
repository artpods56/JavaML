package models;

import cost.MSE;
import utils.ArrayValidator;
import utils.MinMaxScaller;

import java.util.ArrayList;

public class LinearRegression {
    private double slope;
    private double intercept;
    private boolean isFitted;
    private double learningRate;
    private int epochs;
    private MSE mse;

    public double getIntercept() {
        return intercept;
    }

    public void setIntercept(double intercept) {
        this.intercept = intercept;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

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

    private double computeSlopeDerivative(ArrayList<Double> xFeature, ArrayList<Double> yTrue, ArrayList<Double> yPred) {

        double derivativeSum = 0;

        for (int i = 0; i < yTrue.size(); i++) {
            derivativeSum += xFeature.get(i)*(yTrue.get(i) - yPred.get(i));
        }

        return (-2 * derivativeSum) / xFeature.size();
    }

    private double computeInterceptDerivative(ArrayList<Double> yTrue, ArrayList<Double> yPred) {

        double derivativeSum = 0;

        for (int i = 0; i < yTrue.size(); i++) {
            derivativeSum += (yTrue.get(i) - yPred.get(i));
        }

        return (-2 * derivativeSum) / yTrue.size();
    }

    public void fit_transform(ArrayList<Double> xFeature, ArrayList<Double> yTrue) throws Exception {
        ArrayValidator.validateInputs(yTrue,xFeature);

        xFeature = MinMaxScaller.transform(xFeature);
        yTrue = MinMaxScaller.transform(yTrue);

        for (int i = 0; i < this.epochs; i++) {
            ArrayList<Double> yPred = this.predict(xFeature);

            this.slope = this.slope - (this.learningRate * this.computeSlopeDerivative(xFeature, yTrue, yPred));
            this.intercept = this.intercept - (this.learningRate * this.computeInterceptDerivative(yTrue, yPred));

            if (i % 10 == 0) {
                double mse = this.mse.computeCost(yTrue, yPred);
                System.out.println("Epoch: " + i + ", Loss: " + mse);
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


