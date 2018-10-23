package com.core;

import com.ipredocate.Predicate;

import java.lang.reflect.Method;
import java.util.Map;

public class PredicateContext {

    public static void NumberPredicateTest(Integer i, Predicate n) throws Exception {
        Method rule = n.getClass().getMethod("rule", Integer.class);
        Method behavior = n.getClass().getMethod("behavior", Integer.class);

        Boolean b = (Boolean) rule.invoke(n, i);
        if (!b) {
            //continue;
        } else {
            String a = (String) behavior.invoke(n, i);

            //deal with the bussiness
            System.out.println(a);
        }
    }

    public void NumberPredicate(Integer k) {

        PredicateFactory factory = PredicateFactory.getInstance();
        Map<String, Predicate> predicateMap = factory.getPredicateMap();

        for (int i = 1; i <= k; i++) {
            for (String s : predicateMap.keySet()) {
                try {
                    PredicateContext.NumberPredicateTest(i, predicateMap.get(s));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
