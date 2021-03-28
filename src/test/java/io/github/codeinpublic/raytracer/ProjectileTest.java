package io.github.codeinpublic.raytracer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProjectileTest
{
    @Test
    public void createBasicProjectile()
    {
        Point position = new Point(0, 0, 0);
        Vector velocity = new Vector(0, 0, 0);
        Projectile projectile = new Projectile(position, velocity);

        assertTrue("projectile is a projectile ", projectile instanceof Projectile);
    }

    @Test
    public void createProjectile()
    {
        Point position = new Point(0, 0, 0);
        Tuple velocity = Vector.normalize(new Vector(1, 1, 0));
        Projectile projectile = new Projectile(position, velocity);

        assertTrue("projectile is a projectile ", projectile instanceof Projectile);
    }
}
