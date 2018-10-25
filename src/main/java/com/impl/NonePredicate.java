package com.impl;

import com.ipredocate.Predicate;

public class NonePredicate implements Predicate {

    public String behavior(Integer i) {
        return i.toString();
    }
}
