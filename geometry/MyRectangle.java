public class MyRectangle {

    // ===================================
    // instance variables
    // rectangle is defined by 
    // two points: topLeft and bottomRight
    // ===================================
    private MyPoint topLeft;
    private MyPoint bottomRight;

    // ============================================
    // constructors
    // ============================================
    // constructor from two MyPoint objects
    // they dont have to be topLeft and bottomRight
    //
    // constructors will determine 
    // topLeft and bottomRight based on the 
    // coordinates of these two points
    //
    // but there is still a chance that the user
    // will provide points belonging to horizontal 
    // or vertical line, in this case the rectangle 
    // will have zero width or height
    // ============================================
    
    // constructor from two MyPoint objects
    public MyRectangle(MyPoint p1, MyPoint p2) {
        int topLeftX = Math.min(p1.getX(), p2.getX());
        int topLeftY = Math.max(p1.getY(), p2.getY());
        int bottomRightX = Math.max(p1.getX(), p2.getX());
        int bottomRightY = Math.min(p1.getY(), p2.getY());

        this.topLeft = new MyPoint(topLeftX, topLeftY);
        this.bottomRight = new MyPoint(bottomRightX, bottomRightY);
    }

    // constructor from coordinate values
    public MyRectangle(int x1, int y1, int x2, int y2) {
        int topLeftX = Math.min(x1, x2);
        int topLeftY = Math.max(y1, y2);
        int bottomRightX = Math.max(x1, x2);
        int bottomRightY = Math.min(y1, y2);

        this.topLeft = new MyPoint(topLeftX, topLeftY);
        this.bottomRight = new MyPoint(bottomRightX, bottomRightY);
    }

    // ===================
    // getters for topLeft
    // ===================
    public MyPoint getTopLeft() {
        return this.topLeft;
    }

    public int getTopLeftX() {
        return this.topLeft.getX();
    }

    public int getTopLeftY() {
        return this.topLeft.getY();
    }

    public int[] getTopLeftXY() {
        int[] xy = new int[2];
        xy[0] = this.topLeft.getX();
        xy[1] = this.topLeft.getY();
        return xy;
    }

    // =======================
    // getters for bottomRight
    // =======================
    public MyPoint getBottomRight() {
        return this.bottomRight;
    }

    public int getBottomRightX() {
        return this.bottomRight.getX();
    }

    public int getBottomRightY() {
        return this.bottomRight.getY();
    }

    public int[] getBottomRightXY() {
        int[] xy = new int[2];
        xy[0] = this.bottomRight.getX();
        xy[1] = this.bottomRight.getY();
        return xy;
    }

    // ======================
    // getters for bottomLeft
    // ======================
    public MyPoint getBottomLeft() {
        return new MyPoint(this.topLeft.getX(), this.bottomRight.getY());
    }

    public int getBottomLeftX() {
        return this.topLeft.getX();
    }

    public int getBottomLeftY() {
        return this.bottomRight.getY();
    }

    public int[] getBottomLeftXY() {
        int[] xy = new int[2];
        xy[0] = this.topLeft.getX();
        xy[1] = this.bottomRight.getY();
        return xy;
    }

    // ====================
    // getters for topRight
    // ====================
    public MyPoint getTopRight() {
        return new MyPoint(this.bottomRight.getX(), this.topLeft.getY());
    }

    public int getTopRightX() {
        return this.bottomRight.getX();
    }

    public int getTopRightY() {
        return this.topLeft.getY();
    }

    public int[] getTopRightXY() {
        int[] xy = new int[2];
        xy[0] = this.bottomRight.getX();
        xy[1] = this.topLeft.getY();
        return xy;
    }

    // ===================
    // setters for topLeft
    // ===================
    public void setTopLeft(MyPoint topLeft) {
        this.topLeft = new MyPoint(topLeft);
    }

    public void setTopLeftX(int x) {
        this.topLeft.setX(x);
    }

    public void setTopLeftY(int y) {
        this.topLeft.setY(y);
    }

    public void setTopLeftXY(int x, int y) {
        this.topLeft.setXY(x, y);
    }

    // =======================
    // setters for bottomRight
    // =======================
    public void setBottomRight(MyPoint bottomRight) {
        this.bottomRight = new MyPoint(bottomRight);
    }

    public void setBottomRightX(int x) {
        this.bottomRight.setX(x);
    }

    public void setBottomRightY(int y) {
        this.bottomRight.setY(y);
    }

    public void setBottomRightXY(int x, int y) {
        this.bottomRight.setXY(x, y);
    }

    // ================================
    // setters for bottomLeft
    // ================================
    // since rectangle is defined by 
    // topLeft and bottomRight, 
    // we can't set bottomLeft directly
    // but we can modify corresponding 
    // coordinates of 
    // topLeft and bottomRight
    // ================================
    public void setBottomLeft(MyPoint bottomLeft) {
        this.topLeft.setX(bottomLeft.getX());
        this.bottomRight.setY(bottomLeft.getY());
    }

    public void setBottomLeftX(int x) {
        this.topLeft.setX(x);
    }

    public void setBottomLeftY(int y) {
        this.bottomRight.setY(y);
    }

    public void setBottomLeftXY(int x, int y) {
        this.topLeft.setX(x);
        this.bottomRight.setY(y);
    }

    // ========================
    // setters for topRight
    // ========================
    // same goes for topRight
    // we modify coordinates of
    // topLeft and bottomRight
    // ========================
    public void setTopRight(MyPoint topRight) {
        this.bottomRight.setX(topRight.getX());
        this.topLeft.setY(topRight.getY());
    }

    public void setTopRightX(int x) {
        this.bottomRight.setX(x);
    }

    public void setTopRightY(int y) {
        this.topLeft.setY(y);
    }

    public void setTopRightXY(int x, int y) {
        this.bottomRight.setX(x);
        this.topLeft.setY(y);
    }

    // =============
    // other methods
    // =============
    
    // get all four vertices (clockwise order starting from top-left)
    // return as an array of MyPoint objects
    public MyPoint[] getVertices() {
        return new MyPoint[] { 
            this.topLeft, 
            this.getTopRight(), 
            this.bottomRight, 
            this.getBottomLeft() 
        };
    }

    // width of the rectangle
    public int getWidth() {
        return (this.bottomRight.getX() - this.topLeft.getX());
    }

    // height of the rectangle
    public int getHeight() {
        return (this.topLeft.getY() - this.bottomRight.getY());
    }

    // calculate area
    public int getArea() {
        return (this.getWidth() * this.getHeight());
    }

    // calculate perimeter
    public int getPerimeter() {
        return (2 * (this.getWidth() + this.getHeight()));
    }

    // get the center x-coordinate
    public double getCenterX() {
        return (((double)this.topLeft.getX() + (double)this.bottomRight.getX()) / 2.0);
    }

    // get the center y-coordinate
    public double getCenterY() {
        return (((double)this.topLeft.getY() + (double)this.bottomRight.getY()) / 2.0);
    }

    // get the center coordinates as [x,y]
    public double[] getCenterXY() {
        double[] xy = new double[2];
        xy[0] = this.getCenterX();
        xy[1] = this.getCenterY();
        return xy;
    }

    // length of the diagonal
    public double getDiagonalLength() {
        return Math.sqrt(this.getWidth() * this.getWidth() + this.getHeight() * this.getHeight());
    }

    // toString method
    public String toString() {
        return ("MyRectangle[topL" + this.getTopLeft() + "->" +
               "topR" + this.getTopRight() + "->" +
               "botR" + this.getBottomRight() + "->" +
               "botL" + this.getBottomLeft() +
               ",width=" + this.getWidth() + ",height=" + this.getHeight() + "]");
    }
}
