package io.github.codeinpublic.raytracer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;//

import org.junit.Test;

/**
 * Feature tests for Tuples, Vectors, and Points
 */
public class TupleTest
{
    /**
     * Scenario: A tuple with w=1.0 is a point
     *   Given a ← tuple(4.3, -4.2, 3.1, 1.0)
     *     Then a.x = 4.3
     *     And a.y = -4.2
     *     And a.z = 3.1
     *     And a.w = 1.0
     *     And a is a point
     *     And a is not a vector
     */
    @Test
    public void createTupleWithWEqualOne()
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
     *
     * Scenario: A tuple with w=0 is a vector
     *   Given a ← tuple(4.3, -4.2, 3.1, 0.0)
     *     Then a.x = 4.3
     *     And a.y = -4.2
     *     And a.z = 3.1
     *     And a.w = 0.0
     *     And a is not a point
     *     And a is a vector
     **/
    @Test
    public void createTupleWithWEqualZero()
    {
        TupleFactory tupleFactory = new TupleFactory();
        Tuple a = tupleFactory.getTuple(4.3, -4.2, 3.1, 0.0);

        assertEquals(a.getX(), 4.3);
        assertEquals(a.getY(), -4.2);
        assertEquals(a.getZ(), 3.1);
        assertEquals(a.getW(), 0.0);

        assertFalse("a is not a point", a instanceof Point);
        assertTrue("a is a vector", a instanceof Vector);
    }

    /*
    * Scenario: point() creates tuples with w=1
    *   Given p ← point(4, -4, 3)
    *     Then p = tuple(4, -4, 3, 1)
    */
    @Test
    public void createPoint()
    {
        TupleFactory tupleFactory = new TupleFactory();
        Point p = new Point(4.0, -4.0, 3.0);

        assertEquals(p, tupleFactory.getTuple(4.0, -4.0, 3, 1));
    }

    /*
    * Scenario: vector() creates tuples with w=0
    *   Given v ← vector(4, -4, 3)
    *     Then v = tuple(4, -4, 3, 0)
    */
    @Test
    public void createVector()
    {
        TupleFactory tupleFactory = new TupleFactory();
        Vector v = new Vector(4.0, -4.0, 3.0);

        assertEquals(v, tupleFactory.getTuple(4.0, -4.0, 3.0, 0.0));
    }

    private double EPSILON = 0.00001;

    /*
     * Checks if the values are close enough
     */
    private boolean equalish(double value1, double value2) {
        return Math.abs(value1 - value2) < EPSILON;
    }

    /**
     * Helper function for testing floating point values are close to equal
     */
    private void assertEquals(double value1, double value2) {
        assertTrue("Values " + value1 + " and " + value2 + " are not within " + EPSILON + " of each other.", equalish(value1, value2));
    }

    /**
     * Helper function for testing floating point values are close to equal
     */
    private void assertEquals(Tuple tuple1, Tuple tuple2) {
        // Compare each of the tuple dimensions
        assertEquals(tuple1.getX(), tuple2.getX());
        assertEquals(tuple1.getY(), tuple2.getY());
        assertEquals(tuple1.getZ(), tuple2.getZ());
        assertEquals(tuple1.getW(), tuple2.getW());
    }
}
