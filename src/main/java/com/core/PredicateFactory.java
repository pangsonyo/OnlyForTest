package com.core;

import com.ipredocate.Predicate;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PredicateFactory {

    private static PredicateFactory factory;

    private static Map<String, Predicate> predicateMap=new HashMap<String, Predicate>();

    private PredicateFactory() {
        initPredicateList();
    }

    public Map getPredicateMap(){
        return  predicateMap;
    }

    public static PredicateFactory getInstance() {
        if (factory == null) {
            factory = new PredicateFactory();
        }
        return factory;
    }

    public void initPredicateList()  {
        Reflections reflections = new Reflections("com.impl");
        Set<Class<? extends Predicate>> classes =  reflections.getSubTypesOf(Predicate.class);

        for (Class predicate:classes) {
            try {
                predicateMap.put(predicate.getName(), (Predicate) predicate.forName(predicate.getName()).newInstance());
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
