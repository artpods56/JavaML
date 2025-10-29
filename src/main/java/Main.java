import cost.MSE;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        MSE mse = new MSE();


        ArrayList<Double> arr1 = new ArrayList<Double>(Arrays.asList(2.0,3.0,4.1));

        ArrayList<Double> arr2 = new ArrayList<Double>(Arrays.asList(1.0,7.1,3.14));


        double cost = mse.computeCost(arr1, arr2);

        System.out.println(cost);
    }
}
