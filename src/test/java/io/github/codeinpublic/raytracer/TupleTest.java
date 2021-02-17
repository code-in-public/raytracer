package io.github.codeinpublic.raytracer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;//

import org.junit.Test;

/**
 * Feature tests for Tuples, Vectors, and Points
 */
public class TupleTest
{
    private double EPSILON = 0.001;
    /**
     * Scenario: A tuple with w=1.0 is a point
     * Given a ← tuple(4.3, -4.2, 3.1, 1.0)
     * Then a.x = 4.3
     * And a.y = -4.2
     * And a.z = 3.1
     * And a.w = 1.0
     * And a is a point
     * And a is not a vector
     */

    @Test
    public void creatPointTuple()
    {
        TupleFactory tupleFactory = new TupleFactory();
        Tuple a = tupleFactory.getTuple(4.3, -4.2, 3.1, 1.0);

        assertEquals(a.getX(), 4.3);
        assertEquals(a.getY(), -4.2);
        assertEquals(a.getZ(), 3.1);
        assertEquals(a.getW(), 1.0);

        assertTrue("a is a point", a instanceof Point);
        assertFalse("a is not a vector", a instanceof Vector);
    }

    /**
     * Helper function for testing floating point values are close to equal
     */
    private boolean assertEquals(double value1, double value2) {
        return Math.abs(value1 - value2) < EPSILON;
    }
}
