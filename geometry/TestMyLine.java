public class TestMyLine {

    // format float and double numbers to 2 decimal places
    private static String format(double value) {
        return String.format("%.2f", value);
    }
    
    public static void main(String[] args) {
        System.out.println("\n========= TESTING MyLine =========\n");

        // test 1: line from two MyPoint objects
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(3, 4);
        MyLine line1 = new MyLine(p1, p2);

        double expected_length1 = Math.sqrt(3 * 3 + 4 * 4);
        double expected_gradient1 = Math.atan2(4, 3);

        System.out.println("--> Test 1 (Line using MyPoint objects)");
        System.out.println("*** " + line1 + " ***");
        System.out.println("    Expected length:\t" + format(expected_length1) + "\t\tActual: " + format(line1.getLength()));
        System.out.println("    Expected gradient:\t" + format(expected_gradient1) + "rad\t\tActual: " + format(line1.getGradient()) + "rad");
        System.out.println();

        // test 2: line from coordinates
        MyLine line2 = new MyLine(1, 1, 4, 5);
        double expected_length2 = Math.sqrt(3 * 3 + 4 * 4);
        double expected_gradient2 = Math.atan2(4, 3);

        System.out.println("--> Test 2 (Line using coordinates)");
        System.out.println("*** " + line2 + " ***");
        System.out.println("    Expected length:\t" + format(expected_length2) + "\t\tActual: " + format(line2.getLength()));
        System.out.println("    Expected gradient:\t" + format(expected_gradient2) + "rad\t\tActual: " + format(line2.getGradient()) + "rad");
        System.out.println();

        // test 3: identical points (undefined gradient)
        MyLine line3 = new MyLine(5, 5, 5, 5);

        System.out.println("--> Test 3 (Identical points - line is undefined)");
        System.out.println("*** " + line3 + " ***");
        System.out.println("    Expected length:\t0.00\t\tActual: " + format(line3.getLength()));
        System.out.println("    Expected gradient:\tNaN\t\tActual: " + line3.getGradient());
        System.out.println("    Gradient is NaN? \t" + Double.isNaN(line3.getGradient()));
        System.out.println();

        // test 4: vertical line (x1=x2)
        MyLine line4 = new MyLine(2, 2, 2, 8);
        double expected_length4 = 6.0;
        double expected_gradient4 = Math.PI / 2;

        System.out.println("--> Test 4 (Vertical line)");
        System.out.println("*** " + line4 + " ***");
        System.out.println("    Expected length:\t" + format(expected_length4) + "\t\tActual: " + format(line4.getLength()));
        System.out.println("    Expected gradient:\t" + format(expected_gradient4) + "rad\t\tActual: " + format(line4.getGradient()) + "rad");
        System.out.println();

        // test 5: horizontal line (y1 == y2)
        MyLine line5 = new MyLine(3, 5, 10, 5);
        double expected_length5 = 7.0;
        double expected_gradient5 = 0.0;

        System.out.println("--> Test 5 (Horizontal line)");
        System.out.println("*** " + line5 + " ***");
        System.out.println("    Expected length:\t" + format(expected_length5) + "\t\tActual: " + format(line5.getLength()));
        System.out.println("    Expected gradient:\t" + format(expected_gradient5) + "rad\t\tActual: " + format(line5.getGradient()) + "rad");
        System.out.println();

        // test 6: modifying a line
        line1.setBeginXY(2, 2);
        line1.setEndXY(6, 6);
        double expected_length6 = Math.sqrt(4 * 4 + 4 * 4);
        double expected_gradient6 = Math.atan2(4, 4);

        System.out.println("--> Test 6 (Modifying line's begin/end coordinates)");
        System.out.println("*** " + line1 + " ***");
        System.out.println("    Expected length:\t" + format(expected_length6) + "\t\tActual: " + format(line1.getLength()));
        System.out.println("    Expected gradient:\t" + format(expected_gradient6) + "rad\t\tActual: " + format(line1.getGradient()) + "rad");
        System.out.println();

        // test 7: distance function
        MyPoint p3 = new MyPoint(3, 4);
        MyPoint p4 = new MyPoint(6, 8);
        double expected_distance = Math.sqrt(3 * 3 + 4 * 4);

        System.out.println("--> Test 7 (Distance method)");
        System.out.println("    Expected distance between " + p3 + " and " + p4 + ": \t" + format(expected_distance) + "\tActual: " + format(p3.distance(p4)));

        MyPoint p5 = new MyPoint(5, 5);
        System.out.println("    Expected distance from " + p5 + " to (0,0):\t" + format(p5.distance()) + "\tActual: " + format(p5.distance()));
        System.out.println();

        System.out.println("===== ALL TESTS COMPLETED =====\n");
    }

}
