package io.github.codeinpublic.raytracer;

import static io.github.codeinpublic.raytracer.TupleTest.assertEquals;

import org.junit.Test;

public class ColorTest
{
    /* Scenario: Colors are (red, green, blue) tuples
     * Given c ← color(-0.5, 0.4, 1.7)
     * Then c.red = -0.5
     * And c.green = 0.4
     * And c.blue = 1.7
     */
    @Test
    public void createColors()
    {
        Color c = new Color(-0.5, 0.4, 1.7);
        assertEquals(c.getRed(), -0.5);
        assertEquals(c.getGreen(), 0.4);
        assertEquals(c.getBlue(), 1.7);
    }

    /*
     * Scenario: Adding colors
     * Given c1 ← color(0.9, 0.6, 0.75)
     *   And c2 ← color(0.7, 0.1, 0.25)
     *     Then c1 + c2 = color(1.6, 0.7, 1.0)
     */
    @Test
    public void addColors()
    {
        Color c1 = new Color(0.9, 0.6, 0.75);
        Color c2 = new Color(0.7, 0.1, 0.25);

        assertEquals(Tuple.add(c1, c2), new Color(1.6, 0.7, 1.0));
    }

    /*
     * Scenario: Subtracting colors
     *    Given c1 ← color(0.9, 0.6, 0.75)
     *      And c2 ← color(0.7, 0.1, 0.25)
     *  Then c1 - c2 = color(0.2, 0.5, 0.5)
     */
    @Test
    public void subtractColors()
    {
        Color c1 = new Color(0.9, 0.6, 0.75);
        Color c2 = new Color(0.7, 0.1, 0.25);

        assertEquals(Tuple.subtract(c1, c2), new Color(0.2, 0.5, 0.5));
    }

    /*
     * Scenario: Multiplying a color by a scalar
     * Given c ← color(0.2, 0.3, 0.4)
     *  Then c * 2 = color(0.4, 0.6, 0.8)
     */
    @Test
    public void multiplyColorByScalar()
    {
        Color c = new Color(0.2, 0.3, 0.4);

        assertEquals(Tuple.multiply(c, 2), new Color(0.4, 0.6, 0.8));
    }

    /*
     * Scenario: Multiplying colors
     *  Given c1 ← color(1, 0.2, 0.4)
     *    And c2 ← color(0.9, 1, 0.1)
     *   Then c1 * c2 = color(0.9, 0.2, 0.04)
     */
    @Test
    public void multiplyColors()
    {
        Color c1 = new Color(1, 0.2, 0.4);
        Color c2 = new Color(0.9, 1, 0.1);

        assertEquals(Tuple.multiply(c1, c2), new Color(0.9, 0.2, 0.04));
    }
}
