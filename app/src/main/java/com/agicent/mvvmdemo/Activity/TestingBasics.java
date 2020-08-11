package com.agicent.mvvmdemo.Activity;

import android.app.Person;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TestingBasics {
    private final String firstName;
    private final String lastName;

    private final LocalDate dob;

    public TestingBasics(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    // omitting getters for brevity

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof TestingBasics)) {
//            return false;
//        }
//        TestingBasics p = (TestingBasics)o;
//        return firstName.equals(p.firstName)
//                && lastName.equals(p.lastName)
//                && dob.equals(p.dob);
//    }
}

class Main {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
        Map<TestingBasics, String> peopleMap = new HashMap<>();
        TestingBasics me = new TestingBasics("Adam", "McQuistan", LocalDate.parse("1987-09-23"));
        TestingBasics me2 = new TestingBasics("Adam", "McQuistan", LocalDate.parse("1987-09-23"));
        System.out.println("Default hash: " + me.hashCode());
        System.out.println("Default hash: " + me2.hashCode());

        peopleMap.put(me, me.toString());
        System.out.println("me and me2 same? " + me.equals(me2));
        System.out.println("me2 in here? " + peopleMap.containsKey(me2));
    }
}
