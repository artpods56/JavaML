import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import cost.MSE;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        final String COMMA_DELIMITER = ",";

        CSVParser

        List<List<String>> records = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader("book.csv"))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        }


        MSE mse = new MSE();


        ArrayList<Double> arr1 = new ArrayList<Double>(Arrays.asList(2.0, 3.0, 4.1));

        ArrayList<Double> arr2 = new ArrayList<Double>(Arrays.asList(1.0, 7.1, 3.14));


        double cost = mse.computeCost(arr1, arr2);

        System.out.println(cost);
    }
}
