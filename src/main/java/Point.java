package main.java;

public class Point {
    private int coordinateX;
    private int coordinateY;

    public Point(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Point copy() {
        return new Point(coordinateX, coordinateY);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (obj instanceof Point) {
            Point tmp = (Point) obj;
            return (coordinateX == tmp.coordinateX && coordinateY == tmp.coordinateY);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((coordinateX * 839) ^ (coordinateY * 907));
    }

    @Override
    public String toString() {
        return "[" + coordinateX + "," + coordinateY + "]";
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public Point differenceOfTwoPoints(Point point) {
        return new Point(point.getCoordinateX() - getCoordinateX(),
                point.getCoordinateY() - getCoordinateY());
    }


}
