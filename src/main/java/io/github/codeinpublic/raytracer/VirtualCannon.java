package io.github.codeinpublic.raytracer;

/*
 * Run this with this: mvn exec:java -Dexec.mainClass="io.github.codeinpublic.raytracer.VirtualCannon"
 */
public class VirtualCannon
{
    public static Projectile tick(Projectile proj, Environment env) {
        /* function tick(proj, env)
         * position ← proj.position + proj.velocity
         * velocity ← proj.velocity + env.gravity + env.wind
         * return projectile(position, velocity)
         * end function
         */
        Tuple position = Tuple.add(proj.getPosition(), proj.getVelocity());
        Tuple velocity = Tuple.add(Tuple.add(env.getWind(), env.getGravity()), proj.getVelocity());

        return new Projectile(position, velocity);
    }

    public static void main( String[] args )
    {
        /*
         * projectile starts one unit above the origin.
         * # velocity is normalized to 1 unit/tick.
         * p ← projectile(point(0, 1, 0), normalize(vector(1, 1, 0)))
         * # gravity -0.1 unit/tick, and wind is -0.01 unit/tick.
         * e ← environment(vector(0, -0.1, 0), vector(-0.01, 0, 0))
         */
        Projectile p = new Projectile(new Point(0, 1, 0), Tuple.normalize(new Vector(1, 1, 0)));
        Environment e = new Environment(new Vector(0, -0.1, 0), new Vector(-0.01, 0, 0));

        while (p.getPosition().getY() > 0) {
            System.out.println("Projectile position is " + p.getPosition());
            p = tick(p, e);
        }
    }
}
