package main.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Polyomino {
    private Monomino endOfPolyomino;
    private Monomino beginningOfPolyomino;
    private HashMap<Point,String> monominos = new HashMap<>();

    public Polyomino copy(){
        Polyomino result = new Polyomino();
        result.setEndOfPolyomino(endOfPolyomino.copy());
        result.setBeginningOfPolyomino(beginningOfPolyomino.copy());
        result.monominos = (HashMap<Point, String>) monominos.clone();

        return result;
    }

    public Polyomino(Map<Point, String> monominos) {
        this.monominos = (HashMap)monominos;
    }

    public Polyomino(){}


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Polyomino) {
            Polyomino tmp = (Polyomino) obj;
            return (beginningOfPolyomino.equals(tmp.getBeginningOfPolyomino()) &&  monominos.equals(tmp.getMonominos()) && endOfPolyomino.equals(tmp.getEndOfPolyomino()));
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        Iterator it = monominos.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Point,String> pair = (Map.Entry)it.next();
            hash ^= pair.hashCode()*19;
        }

        return hash;
    }

    public Monomino getEndOfPolyomino() {
        return endOfPolyomino;
    }

    public Monomino getBeginningOfPolyomino() {
        return beginningOfPolyomino;
    }

    public void setBeginningOfPolyomino(Monomino beginningOfPolyomino) {
        this.beginningOfPolyomino = beginningOfPolyomino;
    }

    public void setEndOfPolyomino(Monomino endOfPolyomino) {
        this.endOfPolyomino= endOfPolyomino;
    }


    @Override
    public String toString() {
        return "Polyomino{" +
                "monominos=" + monominos +
                ", endOfPolyomino=" + endOfPolyomino +
                ", beginningOfPolyomino=" + beginningOfPolyomino +
                '}';
    }

    public HashMap<Point, String> getMonominos(){
        return monominos;
    }
}
