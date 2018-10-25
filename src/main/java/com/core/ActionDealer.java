package com.core;

import com.ipredocate.Predicate;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Map;

public class ActionDealer {

    private ScriptEngineManager manager = new ScriptEngineManager();

    private ScriptEngine engine = manager.getEngineByName("js");

    private RulePraser rulePraser;

    public ActionDealer(RulePraser rulePraser) {
        this.rulePraser = rulePraser;
    }

    /**
     * put the number need predicate into the expression and turn the string into expression
     * and iterate the number in the container
     * when the expression is true  then call the behavior
     * @param k
     * @throws Exception
     */
    public void behavior(Integer k) throws Exception {
        Map<String, Predicate> objPool =rulePraser.getObjPool();
        String n = String.valueOf(k);
        for (String s: objPool.keySet()) {
            if((Boolean)engine.eval(s.replace("i",n))){
                //get the result
                String a = objPool.get(s).behavior(k);
                //deal with the resulit
                System.out.println(a);
                break;
            }
        }
    }


}
