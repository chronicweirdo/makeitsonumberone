package org.chronicweirdo.tdd;

import com.sun.javafx.animation.TickCalculation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by scacoveanu on 5/26/2014.
 */
@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        Object[][] data = {
                {0, 0, 0}, {1, 1, 0}, {2, 1, 1}, {3, 2, 1},
                {4, 3, 1}, {5, 5, 0}, {6, 8, -2}
        };
        return Arrays.asList(data);
    }

    public int expected, input1, input2;

    public ParameterizedTest(int expected, int input1, int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void executeParameterizedTest() throws Exception {
        Assert.assertEquals(expected, new Calculator().add(input1, input2));
    }
}
