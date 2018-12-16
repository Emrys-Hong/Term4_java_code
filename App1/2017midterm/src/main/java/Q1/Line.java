
package Q1;

public class Line implements Comparable<Line>{
     //TODO: IMPLEMENT CLASS
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    double computeSlope() {
        return (this.y2-this.y1)/(this.x2-this.x1);
    }

    double computeLength() {
        double square = Math.pow((this.y1-this.y2), 2)+Math.pow((this.x1-this.x2), 2);
        return Math.pow(square, 0.5);
    }

    @Override
    public String toString() {
        return "Line:(" + x1 + "," + y1 + ");(" + x2 + "," + y2 + ")";
    }

    @Override
    public int compareTo(Line line) {
        if (this.computeLength() > line.computeLength()) {
            return 1;
        } else if (this.computeLength() == line.computeLength()) {
            return 0;
        } else {
            return -1;
        }
    }


}
