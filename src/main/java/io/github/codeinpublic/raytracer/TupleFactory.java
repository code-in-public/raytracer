package io.github.codeinpublic.raytracer;

public class TupleFactory
{
    public Tuple getTuple(double x, double y, double z, double w) {
        if (w == 1) {
            // If w == 1, return a point
            return new Point(x, y, z, w);
        } else {
            // If w == 0, return a vector
            return new Vector(x, y, z, w);
        }

    }
}
