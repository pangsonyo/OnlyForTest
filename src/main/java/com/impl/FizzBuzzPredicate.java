package com.impl;

import com.ipredocate.Predicate;

public class FizzBuzzPredicate implements Predicate {


    public boolean rule(Integer i) {
        return i % 15 == 0;
    }

    public String behavior(Integer i) {
        return  "FizzBuzz";
    }
}
