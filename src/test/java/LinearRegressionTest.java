import models.LinearRegression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LinearRegressionTest {

    private LinearRegression model;

    @Before
    public void setUp() throws Exception {
        model = new LinearRegression();
    }

    @After
    public void tearDown() throws Exception {
        model = null;
    }

    @Test
    public void fit() {


    }

    @Test
    public void compareArray() {

        ArrayList<Double> arr1 = new ArrayList<Double>(Arrays.asList(0.1,0.2,0.3));
        ArrayList<Double> arr2 = new ArrayList<Double>(Arrays.asList(0.1,0.2,0.3, 0.4));

        boolean equality = model.compareArray(arr1,arr2);

        assertTrue("The arrays should be the same size", equality);


    }
}