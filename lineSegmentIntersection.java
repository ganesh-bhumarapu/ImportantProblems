public class LineSegmentIntersection {

    public static void main(String[] args) {
        // Define points for two line segments
        Point p1 = new Point(1, 2);
        Point q1 = new Point(3, 4);
        Point p2 = new Point(1, 4);
        Point q2 = new Point(2, 3);

        // Check if the line segments intersect
        if (doIntersect(p1, q1, p2, q2)) {
            System.out.println("The line segments intersect.");
        } else {
            System.out.println("The line segments do not intersect.");
        }
    }

    // Class to represent a point in 2D space
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Function to check if two line segments intersect
    public static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
        // Find the four orientations needed for the general and special cases
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // General case
        if (o1 != o2 && o3 != o4) {
            return true;
        }

        // Special cases
        // p1, q1, and p2 are collinear and p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;

        // p1, q1, and q2 are collinear and q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;

        // p2, q2, and p1 are collinear and p1 lies on segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;

        // p2, q2, and q1 are collinear and q1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        // Doesn't fall in any of the above cases
        return false;
    }

    // Function to find the orientation of the ordered triplet (p, q, r)
    // 0 -> p, q and r are collinear
    // 1 -> Clockwise
    // 2 -> Counterclockwise
    public static int orientation(Point p, Point q, Point r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0; // collinear
        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }

    // Function to check if point q lies on line segment pr
    public static boolean onSegment(Point p, Point q, Point r) {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) {
            return true;
        }
        return false;
    }
}
