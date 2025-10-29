import com.opencsv.CSVReader;
import models.LinearRegression;

import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        final String file_path = "Salary_dataset.csv";

        ArrayList<Double> salaries = new ArrayList<Double>();
        ArrayList<Double> experiences = new ArrayList<Double>();

        try (CSVReader reader = new CSVReader(new FileReader(file_path))) {
            String[] line;
            boolean skipHeader = true;

            while ((line = reader.readNext()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                experiences.add(Double.parseDouble(line[1]));
                salaries.add(Double.parseDouble(line[2]));
            }
        }

        System.out.println("Salaries");
        System.out.println(salaries);
        System.out.println("Experiences");
        System.out.println(experiences);


        LinearRegression model = new LinearRegression(
                0.009, 100
        );

        model.fit_transform(experiences, salaries);

        System.out.println("Final slope: " + model.getSlope());
        System.out.println("Final intercept: " + model.getIntercept());

//        MSE mse = new MSE();
//
//
//        ArrayList<Double> arr1 = new ArrayList<Double>(Arrays.asList(2.0, 3.0, 4.1));
//
//        ArrayList<Double> arr2 = new ArrayList<Double>(Arrays.asList(1.0, 7.1, 3.14));
//
//
//        double cost = mse.computeCost(arr1, arr2);
//
//        System.out.println(cost);
    }
}
