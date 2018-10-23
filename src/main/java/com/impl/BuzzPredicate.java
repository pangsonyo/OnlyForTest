package com.impl;

import com.ipredocate.Predicate;

public class BuzzPredicate implements Predicate {

    public boolean rule(Integer i) {
        return  i % 3 == 0;
    }

    public String behavior(Integer i) {
        return  "Buzz";
    }
}
