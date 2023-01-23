package com.splabs.google;

public class Point implements Comparable<Point> {
    private int x;
    private int y;
    private int hashCode;
    private Point parent;

    public Point getParent() {
        return parent;
    }

    public void setParent(Point parent) {
        this.parent = parent;
    }

    public Point(int x, int y) {
        this(x,y,null);
    }

    public Point(int x, int y, Point parent) {
        this.x = x;
        this.y = y;
        hashCode = newHashCode();
    }

    private int newHashCode() {
        int tmp = ( y +  ((x+1)/2));
        return x +  ( tmp * tmp);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        hashCode = newHashCode();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        hashCode = newHashCode();
    }

    public boolean equals(Point rhs) {
        return x == rhs.x && y == rhs.y;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof Point) {
            return this.equals((Point)obj);
        }
        return false;
    }

    @Override
    public int compareTo(Point arg0) {
        long distSq = (arg0.y - y) * (arg0.y - y) + (arg0.x - x) * (arg0.x - x);
        if (distSq != 0) {
            return (int) Math.sqrt(distSq);
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    public int hashCode() {
        return this.hashCode;
    }
}
