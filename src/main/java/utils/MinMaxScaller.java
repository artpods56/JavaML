package utils;

import java.util.ArrayList;
import java.util.Collections;

public class MinMaxScaller{

    public static ArrayList<Double> transform(ArrayList<Double> Array) {
        double xMin = Collections.min(Array);
        double xMax = Collections.max(Array);
        ArrayList<Double> scaledArray = new ArrayList<>();

        for (int i = 0; i < Array.size(); i++) {
            scaledArray.add((Array.get(i) - xMin)/(xMax - xMin));
        }

        return scaledArray;
    }

}

