package leetcode.problems;

/**
 * https://leetcode.com/problems/generate-random-point-in-a-circle/discuss/154037/Polar-Coordinates-10-lines
 */
public class P883_RandomInCircle {

    double radius, x_center, y_center;

    public P883_RandomInCircle(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }

    public double[] randPoint() {
        double len= Math.sqrt(Math.random())*radius;
        double deg= Math.random()*2*Math.PI;
        double x= x_center+len*Math.cos(deg);
        double y= y_center+len*Math.sin(deg);
        return new double[]{x,y};
    }
}
