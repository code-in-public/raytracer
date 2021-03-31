package io.github.codeinpublic.raytracer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CanvasTest
{
    /*
     * Scenario: Creating a canvas
     *  Given c ← canvas(10, 20)
     *   Then c.width = 10
     *   And c.height = 20
     *  And every pixel of c is color(0, 0, 0)
     */
    @Test
    public void createColors()
    {
        Canvas c = new Canvas(10, 20);
        assertEquals(c.getWidth(), 10);
        assertEquals(c.getHeight(), 20);

        // Test that all pixels have color(0, 0, 0)
    }
}
