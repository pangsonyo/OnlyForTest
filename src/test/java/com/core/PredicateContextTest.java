package com.core;


import org.junit.Test;

public class PredicateContextTest {

    @Test
    public void numberPredicate() throws Exception {
       RulePraser rulePraser = new RulePraser("src\\main\\resources\\Bean.xml");
       ActionDealer actionDealer = new ActionDealer(rulePraser);

       for (int i=1; i<=100;i++){
           actionDealer.behavior(i);
       }

    }
}
