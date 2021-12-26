package com.patika.bootcamp.patikabootcamp;

import java.util.function.Predicate;

public class Customer {

    private String name;
    private Integer age;

    public static void main(String[] args) {
        Customer c = new Customer();
    }

    public void predicateDeneme() {
        Predicate<Integer> ageControl = this::check;
        System.out.println(ageControl.test(4));
        System.out.println(ageControl.test(14));
        
        Predicate<Integer> ageControl2 = (Integer age) -> {
            if (age >= 18)
                return true;
            else
                return false;
        };

        Predicate<Integer> ageControl3 = x -> x >= 18;
    }

    public Boolean check(Integer age) {
        if (age >= 18)
            return true;
        else
            return false;
    }
}
