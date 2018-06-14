package main.java;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Coder {
    public static Polyomino encodeCode(List<Polyomino> code,
                                       List<Integer> series,
                                       MergingFunction mergingFunction){
        Polyomino catenation = code.get(series.get(0));
        for(int i=1; i < series.size() ; i++) {
            catenation = concatenatePolyominos(catenation,
                    code.get(series.get(i)), mergingFunction);
        }
        return catenation;
    }

    public static Polyomino concatenatePolyominos(Polyomino first,
                                                  Polyomino second,
                                      MergingFunction mergingFunction) {
        Point vector = first.getEndOfPolyomino().getCoordinates().
                differenceOfTwoPoints(second.getBeginningOfPolyomino().
                        getCoordinates());
        Polyomino firstCopy = first.copy();
        Polyomino secondCopy = second.copy();
        Iterator it = second.getMonominos().entrySet().iterator();


        while (it.hasNext()) {
            Map.Entry<Point,String> pair = (Map.Entry)it.next();
            Point point = new Point(pair.getKey().
                    getCoordinateX()
                    -vector.getCoordinateX(),
                    pair.getKey().getCoordinateY()-vector.
                            getCoordinateY());
            secondCopy.getMonominos().put(point, pair.getValue());
            secondCopy.getMonominos().remove(pair);
            if (firstCopy.getMonominos().containsKey(point)){
                String firstArgument = firstCopy.getMonominos().
                        get(point);
                String result = mergingFunction.getResultOfFunction(
                        firstArgument,
                        pair.getValue());
                firstCopy.getMonominos().put(point, result);
            } else {
                firstCopy.getMonominos().put(point, pair.getValue());
            }
        }

        firstCopy.setEndOfPolyomino(new Monomino(new Point(
                secondCopy.getEndOfPolyomino().
                        getCoordinates()
                        .getCoordinateX()-vector.getCoordinateX(),
                secondCopy.getEndOfPolyomino().
                        getCoordinates().
                        getCoordinateY()-vector.getCoordinateY()),
                secondCopy.
                getEndOfPolyomino().getLabel()));

        return firstCopy;
    }
}
