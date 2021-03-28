package io.github.codeinpublic.raytracer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;//

import org.junit.Before;
import org.junit.Test;

/**
 * Feature tests for Tuples, Vectors, and Points
 */
public class TupleTest
{
    TupleFactory tupleFactory;

    @Before
    public void init() {
        this.tupleFactory = new TupleFactory();
    }

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

    /*
     * Scenario: Adding two tuples
     *   Given a1 ← tuple(3, -2, 5, 1)
     *     And a2 ← tuple(-2, 3, 1, 0)
     *      Then a1 + a2 = tuple(1, 1, 6, 1)
     */
    @Test
    public void addTwoTuples()
    {
        TupleFactory tupleFactory = new TupleFactory();
        Tuple a1 = new Vector(3.0, -2.0, 5, 1);
        Tuple a2 = new Vector(-2.0, 3.0, 1, 0);

        assertEquals(Tuple.add(a1, a2), tupleFactory.getTuple(1.0, 1.0, 6.0, 1.0));
    }

    /*
     * Scenario: Subtracting two points
     *   Given p1 ← point(3, 2, 1)
     *     And p2 ← point(5, 6, 7)
     *       Then p1 - p2 = vector(-2, -4, -6)
     */
    @Test
    public void subtractTwoPoints()
    {
        Point p1 = new Point(3.0, 2.0, 1.0);
        Point p2 = new Point(5.0, 6.0, 7.0);

        assertEquals(Tuple.subtract(p1, p2), new Vector(-2.0, -4.0, -6.0));
    }

    /*
     * Scenario: Subtracting a vector from a point
     *   Given p ← point(3, 2, 1)
     *     And v ← vector(5, 6, 7)
     *       Then p - v = point(-2, -4, -6)
     */
    @Test
    public void subtractVectorFromPoint()
    {
        Point p = new Point(3.0, 2.0, 1.0);
        Vector v = new Vector(5.0, 6.0, 7.0);

        assertEquals(Tuple.subtract(p, v), new Point(-2.0, -4.0, -6.0));
    }

    /*
     *  Scenario: Subtracting two vectors
     *    Given v1 ← vector(3, 2, 1)
     *      And v2 ← vector(5, 6, 7)
     *        Then v1 - v2 = vector(-2, -4, -6)
     */
    @Test
    public void subtractTwoVectors()
    {
        Vector v1 = new Vector(3.0, 2.0, 1.0);
        Vector v2 = new Vector(5.0, 6.0, 7.0);

        assertEquals(Tuple.subtract(v1, v2), new Vector(-2.0, -4.0, -6.0));
    }

    /*
     *  Scenario: Subtracting a vector from the zero vector
     *    Given zero ← vector(0, 0, 0)
     *         And v ← vector(1, -2, 3)
     *    Then zero - v = vector(-1, 2, -3)
     */
    @Test
    public void subtractVectorFromZeroVector()
    {
        Vector zero = new Vector(0.0, 0.0, 0.0);
        Vector v = new Vector(1.0, -2.0, 3.0);

        assertEquals(Tuple.subtract(zero, v), new Vector(-1.0, 2.0, -3.0));
    }

    /*
     *  Scenario: Negating a tuple
     *    Given a ← tuple(1, -2, 3, -4)
     *      Then -a = tuple(-1, 2, -3, 4)
     */
    @Test
    public void negateTuple()
    {
        Tuple a = tupleFactory.getTuple(1.0, -2.0, 3.0, -4.0);

        assertEquals(Tuple.negate(a), tupleFactory.getTuple(-1.0, 2.0, -3.0, 4.0));
    }

    /*
     *  Scenario: Multiplying a tuple by a scalar
     *    Given a ← tuple(1, -2, 3, -4)
     *      Then a * 3.5 = tuple(3.5, -7, 10.5, -14)
     */
    @Test
    public void multiplyTupleByScalar()
    {
        Tuple a = tupleFactory.getTuple(1.0, -2.0, 3.0, -4.0);

        assertEquals(Tuple.multiply(a, 3.5), tupleFactory.getTuple(3.5, -7, 10.5, -14));
    }

    /*
     *  Scenario: Multiplying a tuple by a fraction
     *    Given a ← tuple(1, -2, 3, -4)
     *      Then a * 0.5 = tuple(0.5, -1, 1.5, -2)
     */
    @Test
    public void multiplyTupleByFraction()
    {
        Tuple a = tupleFactory.getTuple(1.0, -2.0, 3.0, -4.0);

        assertEquals(Tuple.multiply(a, 0.5), tupleFactory.getTuple(0.5, -1, 1.5, -2));
    }

    /*
     *  Scenario: Dividing a tuple by a scalar
     *    Given a ← tuple(1, -2, 3, -4)
     *      Then a / 2 = tuple(0.5, -1, 1.5, -2)
     */
    @Test
    public void divideTupleByScalar()
    {
        Tuple a = tupleFactory.getTuple(1.0, -2.0, 3.0, -4.0);

        assertEquals(Tuple.divide(a, 2), tupleFactory.getTuple(0.5, -1, 1.5, -2));
    }

    /*
     * Scenario: Computing the magnitude of vector(1, 0, 0)
     *   Given v ← vector(1, 0, 0)
     *     Then magnitude(v) = 1
     */
    @Test
    public void computeMagnitudeOfXUnitVector()
    {
        Vector v = new Vector(1, 0, 0);
        assertEquals(Tuple.magnitude(v), 1.0);
    }

    /*
     * Scenario: Computing the magnitude of vector(0, 1, 0)
     *   Given v ← vector(0, 1, 0)
     *     Then magnitude(v) = 1
     */
    @Test
    public void computeMagnitudeOfYUnitVector()
    {
        Vector v = new Vector(0, 1, 0);
        assertEquals(Tuple.magnitude(v), 1.0);
    }

    /*
     * Scenario: Computing the magnitude of vector(0, 0, 1)
     *   Given v ← vector(0, 0, 1)
     *     Then magnitude(v) = 1
     */
    @Test
    public void computeMagnitudeOfZUnitVector()
    {
        Vector v = new Vector(0, 0, 1);
        assertEquals(Tuple.magnitude(v), 1.0);
    }

    /*
     * Scenario: Computing the magnitude of vector(1, 2, 3)
     *   Given v ← vector(1, 2, 3)
     *    Then magnitude(v) = √14
     */
    @Test
    public void computeMagnitudeOfPositiveVector()
    {
        Vector v = new Vector(1, 2, 3);
        assertEquals(Tuple.magnitude(v), Math.sqrt(14.0));
    }

    /*
     * Scenario: Computing the magnitude of vector(-1, -2, -3)
     *   Given v ← vector(-1, -2, -3)
     *    Then magnitude(v) = √14
     */
    @Test
    public void computeMagnitudeOfNegativeVector()
    {
        Vector v = new Vector(-1, -2, -3);
        assertEquals(Tuple.magnitude(v), Math.sqrt(14.0));
    }

    /*
     * Scenario: Normalizing vector(4, 0, 0) gives (1, 0, 0)
     *   Given v ← vector(4, 0, 0)
     *     Then normalize(v) = vector(1, 0, 0)
     */
    @Test
    public void normalizeVector()
    {
        Vector v = new Vector(4, 0, 0);
        assertEquals(Tuple.normalize(v), new Vector(1, 0, 0));
    }

    /*
     * Scenario: Normalizing vector(1, 2, 3)
     *   Given v ← vector(1, 2, 3)
     *                                   # vector(1/√14,   2/√14,   3/√14)
     *   Then normalize(v) = approximately vector(0.26726, 0.53452, 0.80178)
     */
    @Test
    public void normalizeComplexVector()
    {
        Vector v = new Vector(1, 2, 3);
        assertEquals(Tuple.normalize(v), new Vector(0.26726, 0.53452, 0.80178));
    }

    /*
     * Scenario: The magnitude of a normalized vector
     *  Given v ← vector(1, 2, 3)
     *     When norm ← normalize(v)
     *     Then magnitude(norm) = 1
     */
    @Test
    public void magnitudeOfNormalizedVector()
    {
        Vector v = new Vector(1, 2, 3);
        Tuple norm = Tuple.normalize(v);
        assertEquals(Tuple.magnitude(norm), 1);
    }

    /*
     * Scenario: The dot product of two tuples
     *   Given a ← vector(1, 2, 3)
     *     And b ← vector(2, 3, 4)
     *     Then dot(a, b) = 20
     */
    @Test
    public void dotProduct()
    {
        Vector a = new Vector(1, 2, 3);
        Vector b = new Vector(2, 3, 4);
        assertEquals(Vector.dot(a, b), 20);
    }

    /*
     * Scenario: The cross product of two vectors
     *   Given a ← vector(1, 2, 3)
     *     And b ← vector(2, 3, 4)
     *    Then cross(a, b) = vector(-1, 2, -1)
     *    And cross(b, a) = vector(1, -2, 1)
     */
    @Test
    public void crossProduct()
    {
        Vector a = new Vector(1, 2, 3);
        Vector b = new Vector(2, 3, 4);
        assertEquals(Vector.cross(a, b), new Vector(-1, 2, -1));
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
        //TODO Add a null check for both Tuples
        // Compare each of the tuple dimensions
        assertEquals(tuple1.getX(), tuple2.getX());
        assertEquals(tuple1.getY(), tuple2.getY());
        assertEquals(tuple1.getZ(), tuple2.getZ());
        assertEquals(tuple1.getW(), tuple2.getW());
    }
}
