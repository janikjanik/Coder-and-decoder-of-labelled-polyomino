package main.java;

import java.util.*;
public class Decoder {
    public static List<Integer> decodeCode(List <Polyomino> code,
                                           Polyomino catenation,
                                           MergingFunction mergingFunction){
        Polyomino compareToCatenation;
        ArrayList<Integer> series;
        for(int i = 0; i < code.size(); i++){
            series = new ArrayList<>();
            if(catenation.getBeginningOfPolyomino().getLabel().equals(
                    code.get(i).getBeginningOfPolyomino().getLabel()) &&
                    checkIfPolyominoFits(catenation, code.get(i),
                            code.get(i).getBeginningOfPolyomino())){
                compareToCatenation = code.get(i).copy();
                series.add(i);
                if(decodePolyominos(catenation, compareToCatenation,
                        series,
                        code, mergingFunction) != null) {

                    return series;
                }
            }
        }
        return null;
    }

    public static List<Integer> decodePolyominos(Polyomino catenation,
                                          Polyomino compareToCatenation,
                                          List<Integer> series,
                                          List<Polyomino> code,
                                          MergingFunction mergingFunction) {


        if(catenation.equals(compareToCatenation)){
            return series;
        }

        else{
            for (int i = 0; i < code.size(); i++) {
                if (checkIfPolyominoFits(catenation, code.get(i),
                        compareToCatenation.getEndOfPolyomino())) {
                    Polyomino compareToCatenationCopy =
                            Coder.concatenatePolyominos(
                            compareToCatenation.copy(), code.get(i),
                                    mergingFunction);
                    series.add(i);

                    if (decodePolyominos(catenation,
                            compareToCatenationCopy,
                            series, code, mergingFunction) != null) {
                        return series;
                    }
                    series.remove(series.size()-1);
                }
            }

        }
        return null;
    }

    public static boolean checkIfPolyominoFits(Polyomino catenation,
                                               Polyomino polyomino,
                                               Monomino monomino){
        Point vector = polyomino.getBeginningOfPolyomino().getCoordinates()
                .differenceOfTwoPoints(monomino.getCoordinates());
        Iterator it = polyomino.getMonominos().entrySet().iterator();
        Polyomino polyominoCopy = polyomino.copy();

        while (it.hasNext()) {
            Map.Entry<Point, String> pair = (Map.Entry) it.next();
            Point point = new Point(pair.getKey().getCoordinateX() +
                    vector.getCoordinateX(),
                    pair.getKey().getCoordinateY() +
                            vector.getCoordinateY());
            polyominoCopy.getMonominos().put(point, pair.getValue());
            polyominoCopy.getMonominos().remove(pair.getKey());
            if (!catenation.getMonominos().containsKey(point)) {
                return false;
            }
        }

        polyominoCopy.setEndOfPolyomino(new Monomino(new Point(
                polyominoCopy.getEndOfPolyomino().getCoordinates().
                        getCoordinateX() + vector.getCoordinateX(),
                polyominoCopy.getEndOfPolyomino().getCoordinates()
                        .getCoordinateY()
                        + vector.getCoordinateY()), ""));

        if(!(catenation.getMonominos().containsKey(
                polyominoCopy.getEndOfPolyomino().getCoordinates()) ||
                catenation.getEndOfPolyomino().equals(
                        polyominoCopy.getEndOfPolyomino()))) {
            return false;
        }

        return true;
    }
}
