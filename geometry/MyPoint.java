public class MyPoint{

    // private instance variables
    // only integer coordinate values are considered
    private int x;
    private int y;

    // Constructors
    public MyPoint()
    {
        this.x = 0;
        this.y = 0;
    }
    public MyPoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
	
    public MyPoint(MyPoint p)
    {
        this.x = p.x;
        this.y = p.y;
    }

    // getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // added getter for both x and y
    public int[] getXY()
    {
        int[] xy = new int[2];
        xy[0] = this.x;
        xy[1] = this.y;
        return xy;
    }

    // setters
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setXY(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // toString() method
    public String toString()
    {
    return("("+this.x+","+this.y+")") ;
    }

    // distance to (0,0)
    public double distance()
    {
        int xDiff = this.x-0;
        int yDiff = this.y-0;
        return Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
    }

    // distance to (x,y)
    public double distance(int x, int y)
    {
        int xDiff = this.x-x;
        int yDiff = this.y-y;
        return Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
    }

    // distance to another point
    public double distance(MyPoint p)
    {
        int xDiff = this.x-p.x;
        int yDiff = this.y-p.y;
        return Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
    }
    
}
