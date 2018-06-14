package test;

import main.java.*;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class DecoderTest {
    private Polyomino polyomino1;
    private Polyomino polyomino2;
    private Polyomino polyomino3;
    private Polyomino polyomino4;
    private Polyomino polyomino5;
    private Polyomino polyomino6;
    private Polyomino polyomino7;
    private List<Polyomino> toEncode;
    private List<Polyomino> code1;
    private List<Polyomino> code2;
    private HashMap<String,String> hashtable;
    private HashMap<String,String> hashtable2;
    private MergingFunction function;
    private MergingFunction function2;

    @org.junit.Before
    public void setUp() throws Exception {
        toEncode = new ArrayList<>();
        hashtable = new HashMap(){{put("aa","a");
            put("ba","a");put("ab","b");put("bb","b");}};

        hashtable2 = new HashMap(){{put("ab","a");
            put("ba","b");put("aa","b");put("bb","b");}};
        function = new MergingFunction(hashtable);
        function2 = new MergingFunction(hashtable2);


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

        Map<Point,String> listOfMonominos = new HashMap<>();
        listOfMonominos.put(new Point(0,0),"b");
        listOfMonominos.put(new Point(1,0),"b");
        Monomino beg1 = new Monomino(new Point(0,0),"b");
        Monomino end1 = new Monomino(new Point(2,0),"");
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
        listOfMonominos4.put(new Point(2,0),"a");
        Monomino beg4 = new Monomino(new Point(0,0),"a");
        Monomino end4 = new Monomino(new Point(2,1),"");
        polyomino4 = new Polyomino(listOfMonominos4);
        polyomino4.setBeginningOfPolyomino(beg4);
        polyomino4.setEndOfPolyomino(end4);

        Map<Point,String> listOfMonominos5 = new HashMap<>();
        listOfMonominos5.put(new Point(1,2),"a");
        listOfMonominos5.put(new Point(0,1),"a");
        listOfMonominos5.put(new Point(1,1),"b");
        Monomino beg5 = new Monomino(new Point(1,2),"a");
        Monomino end5 = new Monomino(new Point(0,0), "");
        polyomino5 = new Polyomino(listOfMonominos5);
        polyomino5.setBeginningOfPolyomino(beg5);
        polyomino5.setEndOfPolyomino(end5);


        code1 = new ArrayList<Polyomino>(){{add(polyomino7);add(polyomino6);add(polyomino1);}};
        code2 = new ArrayList<Polyomino>(){{add(polyomino1);add(polyomino3);add(polyomino4);add(polyomino5);}};

    }

    @org.junit.Test
    public void decodeCode() throws Exception {
        List<Integer> list = new ArrayList<Integer>(){{add(2);add(1);add(0);add(1);add(2);add(2);}};
        Polyomino encoded = Coder.encodeCode(code1, list, function);
        List<Integer> series = Decoder.decodeCode(code1, encoded, function);
        assertEquals(list,series);
    }

    @org.junit.Test
    public void decodeCode2() throws Exception {
        List<Integer> list = new ArrayList<Integer>(){{add(0);add(3);add(2);add(1);}};
        Polyomino encoded = Coder.encodeCode(code2, list, function);
        System.out.println(encoded);
        List <Integer> series = Decoder.decodeCode(code2, encoded, function);

        System.out.println(series.size());
//        for (int i = 0; i < 100000; i++){
//            set.add(Decoder.decodeCode(code2, encoded, function));
//        }
//
//        System.out.println(set.size());
    }

}
