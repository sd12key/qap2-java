public class MyLine {

    // private class instance variables
    // two points of the class MyPoint: begin and end
    private MyPoint begin;
    private MyPoint end;
    
    // constructors
    public MyLine(int x1, int y1, int x2, int y2)
    {
        this.begin = new MyPoint(x1, y1);
        this.end = new MyPoint(x2, y2);
    }
    
    public MyLine(MyPoint begin, MyPoint end)
    {
        this.begin = new MyPoint(begin.getX(), begin.getY());
        this.end = new MyPoint(end.getX(), end.getY());
    }
    
    // getters
    public MyPoint getBegin()
    {
        return this.begin;
    }
    
    public MyPoint getEnd()
    {
        return this.end;
    }
    
    public int getBeginX()
    {
        return this.begin.getX();
    }
    
    public int getBeginY()
    {
        return this.begin.getY();
    }
    
    public int[] getBeginXY()
    {
        return this.begin.getXY();
    }

    public int getEndX()
    {
        return this.end.getX();
    }
    
    public int getEndY()
    {
        return this.end.getY();
    }
   
    public int[] getEndXY()
    {
        return this.end.getXY();
    }

    // setters
    public void setBegin(MyPoint begin)
    {
        this.begin = begin;
    }
    
    public void setEnd(MyPoint end)
    {
        this.end = end;
    }      
    
    public void setBeginX(int x)
    {
        this.begin.setX(x);
    }
    
    public void setBeginY(int y)
    {
        this.begin.setY(y);
    }
    
    public void setBeginXY(int x, int y)
    {
        this.begin.setXY(x, y);
    }
    
    public void setEndX(int x)
    {
        this.end.setX(x);
    }
    
    public void setEndY(int y)
    {
        this.end.setY(y);
    }
    
    public void setEndXY(int x, int y)
    {
        this.end.setXY(x, y);
    }
    
    // other methods

    // calculate the length of the line
    // using distance method from MyPoint class
    public double getLength()
    {
        return this.begin.distance(this.end);
    }
    
    // calculate the gradient of the line
    // using Math.atan2() method
    // returning the slope of the line in radians
    // (counterclockwise angle with regards to x-axis
    // is positive, and clockwise is negative)
    public double getGradient()
    {
        int xDiff = this.end.getX() - this.begin.getX();
        int yDiff = this.end.getY() - this.begin.getY();

        // check if the line is a valid line
        // if line si defined by two the same points
        // then the angle is not defined
        if (xDiff == 0 && yDiff == 0)
        {
            // System.out.println("Angle is not defined, returning NaN");
            return Double.NaN;
        }
        return Math.atan2(yDiff, xDiff);
    }

    // toString() method
    public String toString()
    {
        return ("MyLine[begin=" + this.begin + ",end=" + this.end + "]");
    }
    
}