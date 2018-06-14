package main.java; /**
 * Created by michal on 8/4/17.
 */

import java.util.*;

public class MergingFunction {

    private HashMap <String,String> function;
    public MergingFunction(HashMap<String, String> function) {
        this.function = function;
    }

    public String getResultOfFunction(String argument1, String argument2){
        return function.get(argument1 + argument2);

    }


}
