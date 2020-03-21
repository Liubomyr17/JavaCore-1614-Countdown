package com.company;

/*

1614 Countdown
1. Understand what the program does.
2. Implement the logic of the printCountdown method so that the program outputs an object from a list variable every half a second. It is necessary to deduce in the reverse order - from passed in Countdownindeks to zero.
Example:
Index 3 has been submitted
Console output example:
Line 2
Line 1
Line 0

Requirements:
1. The printCountdown method should work in about half a second.
2. The printCountdown method must reduce (decimate) the value of the countFrom variable.
3. The printCountdown method should output a list item with an index equal to the new countFrom value.
4. The main method must create a single object of type Countdown.
5. The output of the program should follow the example of the condition.

 */

import java.util.ArrayList;
import java.util.List;

/*
Horse Racing
*/

public class Solution {
    public static volatile List<String> list = new ArrayList<String>(5);

    static {
        for (int i = 0; i < 5; i++) {
            list.add("Строка " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Countdown(3), "Countdown");
        t.start();
    }

    public static class Countdown implements Runnable {
        private int countFrom;

        public Countdown(int countFrom) {
            this.countFrom = countFrom;
        }

        public void run() {
            try {
                while (countFrom > 0) {
                    printCountdown();
                }
            } catch (InterruptedException e) {
            }
        }

        public void printCountdown() throws InterruptedException {
            //add your code here - добавь код тут
            countFrom -=1;
            System.out.println(list.get(countFrom));
            Thread.sleep(500);
        }
    }
}





