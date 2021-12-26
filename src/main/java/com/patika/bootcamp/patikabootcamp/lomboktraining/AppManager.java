package com.patika.bootcamp.patikabootcamp.lomboktraining;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class AppManager {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("s1");
        s1.setNumber(13);

        Student s2 = new Student();
        s2.setName("s2");
        s2.setNumber(13);

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(s1);
        studentSet.add(s2);

        System.out.println(studentSet.size());
    }
}
