package io.github.codeinpublic.raytracer;

public class Environment
{
    private final Vector gravity;
    private final Vector wind;

	public Environment(final Vector gravity, final Vector wind) {
		this.gravity = gravity;
		this.wind = wind;
	}

	public Vector getGravity() {
		return gravity;
	}

	public Vector getWind() {
		return wind;
	}
}
