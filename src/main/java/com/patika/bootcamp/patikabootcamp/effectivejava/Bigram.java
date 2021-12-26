package com.patika.bootcamp.patikabootcamp.effectivejava;

import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

public class Bigram{

    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        Bigram b = (Bigram) obj;
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();

        s.contains(new Bigram('x', 'x'));

        for (int i = 0; i < 10; i++)
            for (char ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigram(ch, ch));

        System.out.println(s.size());
    }
}
