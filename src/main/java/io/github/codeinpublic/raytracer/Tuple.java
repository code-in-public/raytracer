package io.github.codeinpublic.raytracer;

public abstract class Tuple {
	private double x;
	private double y;
	private double z;
	private double w;

	protected Tuple(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public static Tuple create(double x, double y, double z, double w) {
		if (w == 1) {
			// If w == 1, return a point
			return new Point(x, y, z, w);
		} else {
			// If w == 0, return a vector
			return new Vector(x, y, z, w);
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double getW() {
		return w;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public void setW(double w) {
		this.w = w;
	}

	public static Tuple add(Tuple a1, Tuple a2) {
		return create(a1.getX() + a2.getX(), a1.getY() + a2.getY(), a1.getZ() + a2.getZ(), a1.getW() + a2.getW());
	}

	public static Tuple subtract(Tuple a1, Tuple a2) {
		return create(a1.getX() - a2.getX(), a1.getY() - a2.getY(), a1.getZ() - a2.getZ(), a1.getW() - a2.getW());
	}

	public static Tuple negate(Tuple a) {
		return multiply(a, -1);
	}

	public static Tuple multiply(Tuple a, double d) {
		return create(a.getX() * d, a.getY() * d, a.getZ() * d, a.getW() * d);
	}

	public static Tuple multiply(Tuple a1, Tuple a2) {
		return create(a1.getX() * a2.getX(), a1.getY() * a2.getY(), a1.getZ() * a2.getZ(), a1.getW() * a2.getZ());
	}

	public static Tuple divide(Tuple a, double d) {
		return multiply(a, 1.0 / d);
	}

	public static double magnitude(Tuple t) {
		return Math.sqrt(Math.pow(t.getX(), 2) + Math.pow(t.getY(), 2) + Math.pow(t.getZ(), 2) + Math.pow(t.getW(), 2));

	}

	public static Tuple normalize(Vector v) {
		return Vector.divide(v, magnitude(v));
	}

	@Override
	public String toString() {
		return "Tuple [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
