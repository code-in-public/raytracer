package io.github.codeinpublic.raytracer;

import static org.junit.Assert.assertEquals;
import static io.github.codeinpublic.raytracer.TupleTest.assertEquals;

import org.junit.Test;
import org.junit.Ignore;

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
    public void createCanvas()
    {
        int width = 10;
        int height = 20;
        Canvas c = new Canvas(width, height);
        assertEquals(c.getWidth(), width);
        assertEquals(c.getHeight(), height);

        // Test that all pixels have color(0, 0, 0)
        for (int col = 0; col < height; col++) {
            for (int row = 0; row < width; row++) {
                Color pixel = c.getPixel(row, col);
                assertEquals(new Color(0, 0, 0), pixel);
            }
        }
    }

    /*
     *  Scenario: Writing pixels to a canvas
     *    Given c ← canvas(10, 20)
     *    And red ← color(1, 0, 0)
     *  When write_pixel(c, 2, 3, red)
     *  Then pixel_at(c, 2, 3) = red
     */
    @Test
    public void writePixels()
    {
        Canvas c = new Canvas(10, 20);
        Color red = new Color(1, 0, 0);

        c.writePixel(2, 3, red);
        assertEquals(c.getPixel(2, 3), red);
    }

    /*
     * Scenario: Constructing the PPM header
     * Given c ← canvas(5, 3)
     * When ppm ← canvas_to_ppm(c)
     * Then lines 1-3 of ppm are
     *   """
     *   P3
     *   5 3
     *   255
     *   """
     *
     */
    @Test
    public void constructPPMheader()
    {
        Canvas c = new Canvas(5, 3);

        String ppm_string = c.toPPM();
        String expected = "P3\n" +
            "5 3\n" +
            "255\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n";
        assertEquals(expected, ppm_string);
    }

    /*
     *  Scenario: Constructing the PPM pixel data
     *  Given c ← canvas(5, 3)
     *      And c1 ← color(1.5, 0, 0)
     *      And c2 ← color(0, 0.5, 0)
     *      And c3 ← color(-0.5, 0, 1)
     *  When write_pixel(c, 0, 0, c1)
     *      And write_pixel(c, 2, 1, c2)
     *      And write_pixel(c, 4, 2, c3)
     *      And ppm ← canvas_to_ppm(c)
     *  Then lines 4-6 of ppm are
     *      """
     *      255 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     *      0 0 0 0 0 0 0 128 0 0 0 0 0 0 0
     *      0 0 0 0 0 0 0 0 0 0 0 0 0 0 255
     *      """
     */
    @Test
    public void constructPPMPixelData()
    {
        Canvas c = new Canvas(5, 3);

        Color c1 = new Color(1.5, 0, 0);
        Color c2 = new Color(0, 0.5, 0);
        Color c3 = new Color(-0.5, 0, 1);

        c.writePixel(0, 0, c1);
        c.writePixel(2, 1, c2);
        c.writePixel(4, 2, c3);

        String ppm_string = c.toPPM();
        String expected = "P3\n" +
            "5 3\n" +
            "255\n" +
            "255 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 128 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 255\n";
        assertEquals(expected, ppm_string);
    }

    /*
     *
     * Scenario: Splitting long lines in PPM files
     * Given c ← canvas(10, 2)
     * When every pixel of c is set to color(1, 0.8, 0.6)
     *      And ppm ← canvas_to_ppm(c)
     *  Then lines 4-7 of ppm are
     *      """
     *      255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204
     *      153 255 204 153 255 204 153 255 204 153 255 204 153
     *      255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204
     *      153 255 204 153 255 204 153 255 204 153 255 204 153
     *      """
     */
    //@Ignore
    @Test
    public void splittingLongLines()
    {
        int width = 10;
        int height = 2;
        Canvas c = new Canvas(width, height);

        for (int col = 0; col < height; col++) {
            for (int row = 0; row < width; row++) {
                Color pixel = new Color(1, 0.8, 0.6);
                c.writePixel(row, col, pixel);
            }
        }

        String ppm_string = c.toPPM();
        String expected = "P3\n" +
            "10 2\n" +
            "255\n" +
            "255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204\n" +
            "153 255 204 153 255 204 153 255 204 153 255 204 153\n" +
            "255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204\n" +
            "153 255 204 153 255 204 153 255 204 153 255 204 153\n";

        assertEquals(expected, ppm_string);
    }
}
