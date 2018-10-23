package com.impl;

import com.ipredocate.Predicate;

public class NonePredicate implements Predicate {

    public boolean rule(Integer i) { return false; }

    public String behavior(Integer i) {
        return i.toString();
    }
}
