public class TestMyRectangle {

    // format double numbers to 2 decimal places
    private static String format(double value) {
        return String.format("%.2f", value);
    }

    // display double coordinates as a point (x.xx,y.xx)
    private static String double_coord_to_point(double x, double y) {
        return "(" + format(x) + "," + format(y) + ")";
    }
  
    // calculate expected values for a rectangle given two points
    private static double[] calculate_expected_values(int x1, int y1, int x2, int y2) {
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        int area = width * height;
        int perimeter = 2 * (width + height);
        double diagonal = Math.sqrt(width * width + height * height);
        double centerX = (x1 + x2) / 2.0;
        double centerY = (y1 + y2) / 2.0;
        return new double[]{width, height, area, perimeter, diagonal, centerX, centerY};
    }

    // run test for a rectangle created from two MyPoint objects
    private static void run_rectangle_test(MyPoint p1, MyPoint p2, MyRectangle rect_tested, String test_name) {
        double[] expected_values = calculate_expected_values(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        System.out.println("--> " + test_name);
        System.out.println("    Points used for test: " + p1 + " and " + p2);
        System.out.println("*** " + rect_tested + " ***");
        System.out.println("    Expected width:	" + (int)expected_values[0] + "\t\tActual: " + rect_tested.getWidth());
        System.out.println("    Expected height:	" + (int)expected_values[1] + "\t\tActual: " + rect_tested.getHeight());
        System.out.println("    Expected area:	" + (int)expected_values[2] + "\t\tActual: " + rect_tested.getArea());
        System.out.println("    Expected perimeter:	" + (int)expected_values[3] + "\t\tActual: " + rect_tested.getPerimeter());
        System.out.println("    Expected diagonal:	" + format(expected_values[4]) + "\t\tActual: " + 
                             format(rect_tested.getDiagonalLength()));
        System.out.println("    Expected center:	" + double_coord_to_point(expected_values[5], expected_values[6]) +
                             "\tActual: " + double_coord_to_point(rect_tested.getCenterX(), rect_tested.getCenterY()));
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("\n========= TESTING MyRectangle =========\n");

        // ===========================================================================
        // test 1: rectangle from two MyPoint objects
        MyPoint p1 = new MyPoint(2, 6);
        MyPoint p2 = new MyPoint(7, 2);
        MyRectangle rect1 = new MyRectangle(p1, p2);
        run_rectangle_test(p1, p2, rect1, "Test 1: MyRectangle using MyPoint objects");

        // ===========================================================================
        // test 2: rectangle from coordinate values
        // points are (10,3) and (3,8)
        // they are not top-left and bottom-right
        p1.setXY(10, 3);
        p2.setXY(3, 8);
        MyRectangle rect2 = new MyRectangle(p1.getX(), p1.getY(), p2.getX() , p2.getY());
        run_rectangle_test(p1, p2, rect2, "Test 2: MyRectangle using coordinates");

        // ===========================================================================
        // test 3: rectangle when points lie on a horizontal line (zero height)
        p1.setXY(9, 5);
        p2.setXY(3, 5);
        MyRectangle rect3 = new MyRectangle(p1.getX(), p1.getY(), p2.getX() , p2.getY());
        run_rectangle_test(p1, p2, rect3, "Test 3: horizontal line - zero height rectangle");

        // ===========================================================================
        // test 4: testing MyRectangle setters (both points and coordinates)
        // showing that incorrect values are not accepted
        System.out.println("--> Test 4: MyRectangle setters)");

        p1.setXY(10, 3);
        p2.setXY(3, 8);
        System.out.println("    Points used for test:\t" + p1 + " and " + p2);
        MyRectangle rect4 = new MyRectangle(p1, p2);
        System.out.println("*** " + rect4);
        System.out.println("    Initial topLeft:\t\t" + rect4.getTopLeft());
        System.out.println("    Initial bottomRight:\t" + rect4.getBottomRight());

        // test setTopLeft with valid value
        System.out.println("\n    >>> Testing setTopLeft with valid value");
        MyPoint newTopLeftValid = new MyPoint(2, 9);
        System.out.println("    Attempting to set topLeft to:\t" + newTopLeftValid);
        System.out.println("    Rectange was modified:\t\t" + rect4.setTopLeft(newTopLeftValid));
        System.out.println("*** " + rect4);

        // test setTopLeft with invalid value
        System.out.println("\n    >>> Testing setTopLeft with invalid value");
        MyPoint newTopLeftInvalid = new MyPoint(15, 1);
        System.out.println("    Attempting to set topLeft to:\t" + newTopLeftInvalid);
        System.out.println("    Rectangle was modified:\t\t" + rect4.setTopLeft(newTopLeftInvalid));
        System.out.println("*** " + rect4);

        // Test setTopRight with valid values
        System.out.println("\n    >>> Testing setTopRight with valid value");
        MyPoint newTopRightValid = new MyPoint(15, 9);
        System.out.println("    Attempting to set topRight to:\t" + newTopRightValid);
        System.out.println("    Rectangle was modified:\t\t" + rect4.setTopRight(newTopRightValid));
        System.out.println("*** " + rect4);

        // Test setTopRight with invalid values
        System.out.println("\n    >>> Testing setTopRight with invalid value");
        MyPoint newTopRightInvalid = new MyPoint(1, 1); // Invalid because x < topLeft.x and y < bottomRight.y
        System.out.println("    Attempting to set topRight to:\t" + newTopRightInvalid);
        System.out.println("    Rectangle was modified:\t\t" + rect4.setTopRight(newTopRightInvalid));
        System.out.println("*** " + rect4);
        System.out.println();        

        // test 5: testing translate()
        System.out.println("--> Test 5: testing translate()");
        // Create a rectangle with initial points (2, 6) and (7, 2)
        p1.setXY(2, 6);
        p2.setXY(7, 2);
        MyRectangle rect5 = new MyRectangle(p1, p2);
        System.out.println("*** " + rect5);
        System.out.println("    >>> Translating rectangle by (3, -2)");
        rect5.translate(3, -2);
        System.out.println("*** " + rect5);
        System.out.println();

        // test 6: testing translate()
        System.out.println("--> Test 6: testing contains()");
        System.out.println("*** " + rect5);        
        MyPoint pointInside = new MyPoint(6, 3);
        MyPoint pointOutside = new MyPoint(1, 1);
        System.out.println("    >>> Contains " + pointInside + "?\t\t" + rect5.contains(pointInside));
        System.out.println("    >>> Contains " + pointOutside + "?\t\t" + rect5.contains(pointOutside));
        System.out.println();

        System.out.println("===== ALL TESTS COMPLETED =====\n");
    }
}
