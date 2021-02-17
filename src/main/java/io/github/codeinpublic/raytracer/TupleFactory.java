package io.github.codeinpublic.raytracer;

public class TupleFactory
{
    public Tuple getTuple(double x, double y, double z, double w) {
        // If w == 1, return a point
        return new Point(x, y, z, w);

        // If w == 0, return a vector
    }
}
