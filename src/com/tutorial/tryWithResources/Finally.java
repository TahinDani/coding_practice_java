package com.tutorial.tryWithResources;

import java.util.ArrayList;
import java.util.List;

public class Finally {


    private static void testOutOfMemoryError() {
        try {
            try {
                List<byte[]> bytes = new ArrayList<>();
                while(true)
                    bytes.add(new byte[8*1024*1024]);
            } finally {
                System.out.print("finally called");
                //System.exit(1);
            }
        } catch (OutOfMemoryError t) {
            System.out.println("\nCatching");
            t.printStackTrace();

        }

    }


    public static String testReturn() {
        try{

            System.out.println("Trying");
            System.out.println(5 / 0);
            return "Try";

        } catch (ArithmeticException e){  // what happens when I don't catch it?

            System.out.println("Catching");
            e.printStackTrace();
            return "Catch";

        } finally {

            //System.out.println(5/0);
            System.out.println("Finally");
            //return "Finally";           // what happens when return to "Finally"?
        }

        //System.out.println("code...");  // why is it unreachable?
    }


    private static void testStackOverflow() {
        try {
            try {
                testStackOverflow0();
            } finally {
                System.out.print("finally called after ");
            }
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }
    }

    private static void testStackOverflow0() {
        testStackOverflow0();
    }

    private static void testThreadInterrupted() {
        try {
            try {
                final Thread thread = Thread.currentThread();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        thread.interrupt();
                    }
                }).start();
                while(true)
                    Thread.sleep(1000);
            } finally {
                System.out.print("finally called after ");
            }
        } catch (Throwable t) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        //System.out.println("returned: " + Finally.testReturn());
        //Finally.testOutOfMemoryError();
        //Finally.testStackOverflow();
        //Finally.testThreadInterrupted();
    }

}
