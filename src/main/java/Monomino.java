package main.java;

public class Monomino {
    private Point coordinates;
    private String label;

    public Monomino(Point coordinates, String label) {
        this.coordinates = coordinates;
        this.label = label;
    }

    public Monomino copy() {
        return new Monomino(coordinates.copy(), label);
    }

    @Override
    public int hashCode() {
        return (((coordinates.getCoordinateX() * 11) ^ (coordinates.getCoordinateY() * 7)));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getLabel() == null) {
            return false;
        }
        else if(obj instanceof Monomino){
            Monomino tmp = (Monomino) obj;
            if(tmp.getLabel()==null){
                return false;
            }

            return (coordinates.equals(tmp.getCoordinates()) && getLabel().equals(tmp.getLabel())) ;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{"+ coordinates + ", " + label + "}";
    }

    public String getLabel(){
        return label;
    }

    public Point getCoordinates() {
        return coordinates;
    }

}
