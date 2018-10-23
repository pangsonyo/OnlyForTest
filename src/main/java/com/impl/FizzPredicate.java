package com.impl;

import com.ipredocate.Predicate;

public class FizzPredicate implements Predicate {

    public boolean rule(Integer i) {
        return i % 5 == 0;
    }

    public String behavior(Integer i) {
        return  "Fizz";
    }
}
