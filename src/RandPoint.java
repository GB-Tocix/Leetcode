import java.util.Random;

class RandPoint {
    double r;
    double x;
    double y;
    Random rand;

    public RandPoint(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
        rand = new Random();
    }

    public double[] randPoint() {
        double r_cur = rand.nextDouble();
        double theta = rand.nextDouble() * 2 * Math.PI;
        double p = Math.sqrt(r_cur);
        return new double[]{x + p * r *  Math.cos(theta), y + p * r * Math.sin(theta)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */