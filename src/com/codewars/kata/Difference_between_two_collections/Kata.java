package com.codewars.kata.Difference_between_two_collections;


import java.util.*;

public class Kata {

    public static TreeSet<Character> diff(List<Character> a, List<Character> b) {
        TreeSet<Character> diff = new TreeSet<>();
        Iterator itr = a.iterator();
        while(itr.hasNext()) {
            Character element = (Character) itr.next();
            if (b.contains(element)){
                itr.remove();
                b.remove(element);
            }
        }
        diff.addAll(a);
        diff.addAll(b);

        return diff;
    }


    public static void main(String[] args) {
        List<Character> a = new LinkedList<>(Arrays.asList('a', 'b', 'c', 'd', 'd'));
        List<Character> b = new LinkedList<>(Arrays.asList('a', 'b', 'e', 'e'));
        System.out.println(diff(a, b));
    }

}

