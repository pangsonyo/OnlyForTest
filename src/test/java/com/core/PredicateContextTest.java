package com.core;


import org.junit.Test;

public class PredicateContextTest {

    @Test
    public void numberPredicate() {
        PredicateContext predicateContext = new PredicateContext();
        predicateContext.NumberPredicate(100);
    }
}