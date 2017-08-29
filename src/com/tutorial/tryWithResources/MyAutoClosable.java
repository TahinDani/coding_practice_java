package com.tutorial.tryWithResources;

/*
Created by TahinDani on 2017.08.28..
*/

public class MyAutoClosable implements AutoCloseable {


    public void doIt() {
        System.out.println("MyAutoClosable doing it!");
    }

    @Override
    public void close() throws Exception {

        System.out.println("MyAutoClosable closed!");
        //throw new ArithmeticException();   // this will be suppressed
    }

    private static void testMyAutoClosable() throws Exception {

        try(MyAutoClosable myAutoClosable = new MyAutoClosable()){

            //throw new IllegalArgumentException();  // this will be thrown to the outside world
            myAutoClosable.doIt();


        }
    }

    public static void main(String[] args) throws Exception {
        MyAutoClosable.testMyAutoClosable();
    }
}
