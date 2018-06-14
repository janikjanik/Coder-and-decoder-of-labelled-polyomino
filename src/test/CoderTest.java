package test;

import main.java.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CoderTest {
    private static Polyomino polyomino1;
    private static Polyomino polyomino2;
    private static Polyomino polyomino3;
    private static Polyomino polyomino4;
    private static Polyomino polyomino5;
    private static Polyomino polyomino6;
    private Polyomino polyomino7;
    private List<Polyomino> code1;
    private List<Polyomino> code2;
    private static Polyomino checkedEncoded;
    private static Polyomino checkedEncodedComplex;

    HashMap<String,String> hashtable;
    HashMap<String,String> hashtable2;
    MergingFunction function;
    MergingFunction function2;

    @org.junit.Before
    public void setUp() throws Exception {

        hashtable = new HashMap(){{put("aa","a");
            put("ba","a");put("ab","b");put("bb","b");}};
        hashtable2 = new HashMap(){{put("ab","a");
            put("ba","b");put("aa","b");put("bb","b");}};
        function = new MergingFunction(hashtable);
        function2 = new MergingFunction(hashtable2);

        Map<Point,String> listOfMonominos = new HashMap<>();
        listOfMonominos.put(new Point(0,0),"a");
        listOfMonominos.put(new Point(1,0),"b");
        listOfMonominos.put(new Point(2,0),"a");
        Monomino beg1 = new Monomino(new Point(0,0),"a");
        Monomino end1 = new Monomino(new Point(2,1),"");
        polyomino1 = new Polyomino(listOfMonominos);
        polyomino1.setBeginningOfPolyomino(beg1);
        polyomino1.setEndOfPolyomino(end1);

        Map<Point,String> listOfMonominos2 = new HashMap<>();
        listOfMonominos2.put(new Point(1,2),"a");
        listOfMonominos2.put(new Point(0,1),"a");
        listOfMonominos2.put(new Point(1,1),"b");
        Monomino beg2 = new Monomino(new Point(1,2),"a");
        Monomino end2 = new Monomino(new Point(0,0), "");
        polyomino2 = new Polyomino(listOfMonominos2);
        polyomino2.setBeginningOfPolyomino(beg2);
        polyomino2.setEndOfPolyomino(end2);

        Map<Point,String> listOfMonominos3 = new HashMap<>();
        listOfMonominos3.put(new Point(1,0),"a");
        listOfMonominos3.put(new Point(1,1),"b");
        Monomino beg3 = new Monomino(new Point(1,0),"a");
        Monomino end3 = new Monomino(new Point(0,1),"");
        polyomino3 = new Polyomino(listOfMonominos3);
        polyomino3.setBeginningOfPolyomino(beg3);
        polyomino3.setEndOfPolyomino(end3);

        Map<Point,String> listOfMonominos4 = new HashMap<>();
        listOfMonominos4.put(new Point(0,0),"a");
        listOfMonominos4.put(new Point(1,0),"b");
        Monomino beg4 = new Monomino(new Point(0,0),"a");
        Monomino end4 = new Monomino(new Point(1,1),"");
        polyomino4 = new Polyomino(listOfMonominos4);
        polyomino4.setBeginningOfPolyomino(beg4);
        polyomino4.setEndOfPolyomino(end4);

        Map<Point,String> listOfMonominos5 = new HashMap<>();
        listOfMonominos5.put(new Point(0,0),"b");
        listOfMonominos5.put(new Point(1,0),"b");
        Monomino beg5 = new Monomino(new Point(0,0),"b");
        Monomino end5 = new Monomino(new Point(1,-1),"");
        polyomino5 = new Polyomino(listOfMonominos5);
        polyomino5.setBeginningOfPolyomino(beg5);
        polyomino5.setEndOfPolyomino(end5);

        Map<Point,String> listOfMonominos6 = new HashMap<>();
        listOfMonominos6.put(new Point(0,0),"a");
        Monomino beg6 = new Monomino(new Point(0,0),"a");
        Monomino end6 = new Monomino(new Point(1,0), "");
        polyomino6 = new Polyomino(listOfMonominos6);
        polyomino6.setBeginningOfPolyomino(beg6);
        polyomino6.setEndOfPolyomino(end6);


        Map<Point,String> listOfMonominos7 = new HashMap<>();
        listOfMonominos7.put(new Point(0,0),"b");
        listOfMonominos7.put(new Point(1,0),"a");
        Monomino beg7 = new Monomino(new Point(0,0),"b");
        Monomino end7 = new Monomino(new Point(2,0), "");
        polyomino7 = new Polyomino(listOfMonominos7);
        polyomino7.setBeginningOfPolyomino(beg7);
        polyomino7.setEndOfPolyomino(end7);


        Map<Point,String> listOfMonominoss = new HashMap<>();
        listOfMonominoss.put(new Point(0,0),"a");
        listOfMonominoss.put(new Point(1,0),"b");
        listOfMonominoss.put(new Point(2,0),"a");
        listOfMonominoss.put(new Point(2,1),"a");
        listOfMonominoss.put(new Point(3,1),"b");
        listOfMonominoss.put(new Point(3,2),"b");
        listOfMonominoss.put(new Point(4,2),"b");
        listOfMonominoss.put(new Point(4,1),"a");
        listOfMonominoss.put(new Point(5,1),"b");
        listOfMonominoss.put(new Point(6,1),"a");
        Monomino begg = new Monomino(new Point(0,0),"a");
        Monomino endd = new Monomino(new Point(6,2),"");
        checkedEncoded = new Polyomino(listOfMonominoss);
        checkedEncoded.setBeginningOfPolyomino(begg);
        checkedEncoded.setEndOfPolyomino(endd);
        Monomino begOfComplex = new Monomino(new Point(0,0),"a");
        Monomino endOfComplex = new Monomino(new Point(0,0),"");
        Map<Point,String> listOfMonominosOfComplex = new HashMap<>();
        listOfMonominosOfComplex.put(new Point(1,0),"b");
        listOfMonominosOfComplex.put(new Point(2,0),"b");
        listOfMonominosOfComplex.put(new Point(2,1),"a");
        listOfMonominosOfComplex.put(new Point(1,-1),"a");
        listOfMonominosOfComplex.put(new Point(0,0),"a");
        checkedEncodedComplex = new Polyomino(listOfMonominosOfComplex);
        checkedEncodedComplex.setBeginningOfPolyomino(begOfComplex);
        checkedEncodedComplex.setEndOfPolyomino(endOfComplex);

        code1 = new ArrayList<Polyomino>(){{add(polyomino1);add(polyomino4);add(polyomino5);}};
        code2 = new ArrayList<Polyomino>(){{add(polyomino2);add(polyomino1);add(polyomino3);add(polyomino5);}};
    }

    @org.junit.Test
    public void encodeCode() throws Exception {
        List<Integer> list = new ArrayList<Integer>(){{add(0); add(1); add(2); add(0);}};
        assertEquals(Coder.encodeCode(code1, list, function),checkedEncoded);
    }

    @org.junit.Test
    public void encodeCode2() throws Exception {
        List<Integer> list = new ArrayList<Integer>(){{add(1); add(0); add(2);}};
        assertEquals(Coder.encodeCode(code2, list, function), checkedEncodedComplex);
    }

}