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

    // ==============================================================
    // setters for topLeft
    // ==============================================================
    // they return boolean True if the point is set, otherwise False. 
    // check is done if topLeft coordinates make sense, that is,
    // if topLeft is really top left corner of the rectangle
    // ==============================================================
    public boolean setTopLeft(MyPoint topLeft) {
        if  ((topLeft.getX() <= this.bottomRight.getX()) 
            && (topLeft.getY() >= this.bottomRight.getY())) {
            this.topLeft = new MyPoint(topLeft);
            return true;
        }
        return false;
    }

    public boolean setTopLeftXY(int x, int y) {
        if ((x <= this.bottomRight.getX()) && (y >= this.bottomRight.getY())) {
            this.topLeft.setXY(x, y);
            return true;
        }
        return false;
    }

    public boolean setTopLeftX(int x) {
        if (x <= this.bottomRight.getX()) {
            this.topLeft.setX(x);
            return true;
        }
        return false;
    }

    public boolean setTopLeftY(int y) {
        if (y >= this.bottomRight.getY()) {
            this.topLeft.setY(y);
            return true;
        }
        return false;
    }

    // ==============================================================
    // setters for bottomRight
    // ==============================================================
    // they return boolean True if the point is set, otherwise False. 
    // check is done if bottomRight coordinates make sense, that is,
    // if bottomRight is really bottom right corner of the rectangle
    // ==============================================================
    public boolean setBottomRight(MyPoint bottomRight) {
        if  ((bottomRight.getX() >= this.topLeft.getX()) 
            && (bottomRight.getY() <= this.topLeft.getY())) {
            this.bottomRight = new MyPoint(bottomRight);
            return true;
        }
        return false;
    }

    public boolean setBottomRightXY(int x, int y) {
        if (x >= this.topLeft.getX() && y <= this.topLeft.getY()) {
            this.bottomRight.setXY(x, y);
            return true;
        }
        return false;
    }

    public boolean setBottomRightX(int x) {
        if (x >= this.topLeft.getX()) {
            this.bottomRight.setX(x);
            return true;
        }
        return false;
    }

    public boolean setBottomRightY(int y) {
        if (y <= this.topLeft.getY()) {
            this.bottomRight.setY(y);
            return true;
        }
        return false;
    }

    // ==============================================================
    // setters for bottomLeft
    // ==============================================================
    // since rectangle is defined by topLeft and bottomRight, 
    // we can't set bottomLeft directly but we can modify
    // corresponding coordinates of topLeft and bottomRight
    // ==============================================================
    // they return boolean True if the point is set, otherwise False. 
    // check is done if bottomLeft coordinates make sense, that is,
    // if bottomLeft is really bottom left corner of the rectangle
    // ==============================================================
    public boolean setBottomLeft(MyPoint bottomLeft) {
        if  ((bottomLeft.getX() <= this.bottomRight.getX()) 
            && (bottomLeft.getY() <= this.topLeft.getY())) {
            this.topLeft.setX(bottomLeft.getX());
            this.bottomRight.setY(bottomLeft.getY());
            return true;
        }
        return false;    
    }

    public boolean setBottomLeftXY(int x, int y) {
        if (x <= this.bottomRight.getX() && y <= this.topLeft.getY()) {
            this.topLeft.setX(x);
            this.bottomRight.setY(y);
            return true;
        }
        return false;
    }

    public boolean setBottomLeftX(int x) {
        if (x <= this.bottomRight.getX()) {
            this.topLeft.setX(x);
            return true;
        }
        return false;
    }

    public boolean setBottomLeftY(int y) {
        if (y <= this.topLeft.getY()) {
            this.bottomRight.setY(y);
            return true;
        }
        return false;
    }

    // ==============================================================
    // setters for topRight
    // ==============================================================
    // same topRight: modify coordinates of topLeft and bottomRight
    // ==============================================================
    // they return boolean True if the point is set, otherwise False. 
    // check is done if topRight coordinates make sense, that is,
    // if topRight is really top right corner of the rectangle
    // ==============================================================
    public boolean setTopRight(MyPoint topRight) {
        if  ((topRight.getX() >= this.topLeft.getX()) 
            && (topRight.getY() >= this.bottomRight.getY())) {
            this.bottomRight.setX(topRight.getX());
            this.topLeft.setY(topRight.getY());
            return true;
        }
        return false;
    }

    public boolean setTopRightXY(int x, int y) {
        if (x >= this.topLeft.getX() && y >= this.bottomRight.getY()) {
            this.bottomRight.setX(x);
            this.topLeft.setY(y);
            return true;
        }
        return false;
    }

    public boolean setTopRightX(int x) {
        if (x >= this.topLeft.getX()) {
            this.bottomRight.setX(x);
            return true;
        }
        return false;
    }

    public boolean setTopRightY(int y) {
        if (y >= this.bottomRight.getY()) {
            this.topLeft.setY(y);
            return true;
        }
        return false;
    }

    // ====================================
    // setter for changing rectangle points
    // ====================================
    public void setAllRectanglePoints(MyPoint p1, MyPoint p2) {
        // calculate the correct topLeft and bottomRight points 
        // based on the coordinates of p1 and p2
        int topLeftX = Math.min(p1.getX(), p2.getX());
        int topLeftY = Math.max(p1.getY(), p2.getY());
        int bottomRightX = Math.max(p1.getX(), p2.getX());
        int bottomRightY = Math.min(p1.getY(), p2.getY());
    
        // set new the rectangle points
        this.topLeft = new MyPoint(topLeftX, topLeftY);
        this.bottomRight = new MyPoint(bottomRightX, bottomRightY);
    }

    public void setAllRectanglePoints(int x1, int y1, int x2, int y2) {
        // calculate the correct topLeft and bottomRight points 
        // based on the coordinates x1, y1 and x2, y2
        int topLeftX = Math.min(x1, x2);
        int topLeftY = Math.max(y1, y2);
        int bottomRightX = Math.max(x1, x2);
        int bottomRightY = Math.min(y1, y2);
    
        // set new the rectangle points
        this.topLeft = new MyPoint(topLeftX, topLeftY);
        this.bottomRight = new MyPoint(bottomRightX, bottomRightY);
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
        return ((this.topLeft.getX() + this.bottomRight.getX()) / 2.0);
    }

    // get the center y-coordinate
    public double getCenterY() {
        return ((this.topLeft.getY() + this.bottomRight.getY()) / 2.0);
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

    // check if a point is inside the rectangle (myPoint)
    public boolean contains(MyPoint p) {
        return ((p.getX() >= this.topLeft.getX()) && (p.getX() <= this.bottomRight.getX()) &&
               (p.getY() <= this.topLeft.getY()) && (p.getY() >= this.bottomRight.getY()));
    }

    // check if a point is inside the rectangle (x,y)
    public boolean contains(int x, int y) {
        return ((x >= this.topLeft.getX()) && (x <= this.bottomRight.getX()) &&
               (y <= this.topLeft.getY()) && (y >= this.bottomRight.getY()));
    }    

    // translate the rectangle by dx and dy
    public void translate(int dx, int dy) {
        this.topLeft.setXY(this.topLeft.getX() + dx, this.topLeft.getY() + dy);
        this.bottomRight.setXY(this.bottomRight.getX() + dx, this.bottomRight.getY() + dy);
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
