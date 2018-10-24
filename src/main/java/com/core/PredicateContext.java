package com.core;

import com.ipredocate.Predicate;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PredicateContext {
    /** get the number predicate result
     * @param i
     * @param n
     * @return
     * @throws Exception
     */

    public static Boolean NumberPredicateTest(Integer i, Predicate n) throws Exception {
        Method rule = n.getClass().getMethod("rule", Integer.class);
        return  (Boolean) rule.invoke(n, i);
    }

    public void NumberPredicate(Integer k) {
        PredicateFactory factory = PredicateFactory.getInstance();
        Map<String, Predicate> predicateMap = factory.getPredicateMap();

        for (int i = 1; i <= k; i++) {
            try {
                NumberPredicate(predicateMap,i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static List getKeyByValue(Map map, Object value){
        List<Object> keyList = new ArrayList<Object>();
        for(Object key: map.keySet()){
            if(map.get(key).equals(value)){
                keyList.add(key);
            }
        }
        return keyList;
    }

    /**
     * search all the  strategy
     * @param predicateMap  List<className,classInstance>
     * @param i     number needs test
     * @throws Exception
     */
    private void NumberPredicate(Map<String, Predicate> predicateMap,Integer i) throws Exception{
        //<className,result>
        Map<String,Boolean> map = new HashMap();
        String a;
        for (String s : predicateMap.keySet()) {
            if (!s.equals("com.impl.NonePredicate") && !s.equals("com.impl.FizzBuzzPredicate")) {
                    Boolean b = PredicateContext.NumberPredicateTest(i, predicateMap.get(s));
                    map.put(s, b);
            }
        }
        //do the default  all the false
        if(!(map.values().contains(true)))
             a =  predicateMap.get("com.impl.NonePredicate").behavior(i);
        //all the true
        else if(!(map.values().contains(false)))
             a =  predicateMap.get("com.impl.FizzBuzzPredicate").behavior(i);
        //other
        else
            a =  predicateMap.get( PredicateContext.getKeyByValue(map,true).get(0)).behavior(i);
        //deal with the result
        System.out.println(a);
    }

    public static void main(String[] args) {
        PredicateFactory factory = PredicateFactory.getInstance();
        Map<String, Predicate> predicateMap = factory.getPredicateMap();
        PredicateContext predicateContext = new PredicateContext();
        try {
            predicateContext.NumberPredicate(predicateMap,15);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
