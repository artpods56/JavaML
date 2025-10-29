package utils;

import java.util.ArrayList;

public class ArrayValidator {

    private ArrayValidator() {
    }

    public static void validateInputs(ArrayList<Double> aArray,
                                      ArrayList<Double> bArray) throws ArrayValidationException {

        if (bArray.size() != aArray.size()) {
            throw new ArrayValidationException("Arrays must have matching sizes");
        }
        if (bArray.isEmpty() || aArray.isEmpty()) {
            throw new ArrayValidationException("Arrays must not be empty");
        }


    }
}
