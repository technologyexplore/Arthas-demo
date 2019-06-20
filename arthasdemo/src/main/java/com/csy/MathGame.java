package com.csy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MathGame {
    private static Random random = new Random();

    public int illegalArgumentCount = 0;

    public static void main(String[] args) {
        MathGame game = new MathGame();
        Thread t = new Thread(() -> {
            while (true) {
                game.run();
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setName("9527");
        t.start();
    }

    public void run() {
        try {
            int number = random.nextInt() / 10000;
            List<Integer> primeFactors = primeFactors(number);
            print(number, primeFactors);
        } catch (Exception e) {
            System.out.println(String.format("illegalArgumentCount:%3d, ", new Object[]{Integer.valueOf(this.illegalArgumentCount)}) + e.getMessage());
        }
    }

    public static void print(int number, List<Integer> primeFactors) {
        StringBuffer sb = new StringBuffer(number + "=");
        for (Iterator iterator = primeFactors.iterator(); iterator.hasNext(); ) {
            int factor = ((Integer) iterator.next()).intValue();
            sb.append(factor).append('*');
        }

        if (sb.charAt(sb.length() - 1) == '*') {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }

    public List<Integer> primeFactors(int number) {
        if (number < 2) {
            this.illegalArgumentCount++;
            throw new IllegalArgumentException("number is: " + number + ", need >= 2");
        }

        List<Integer> result = new ArrayList<Integer>();
        int i = 2;
        while (i <= number) {
            if (number % i == 0) {
                result.add(Integer.valueOf(i));
                number /= i;
                i = 2;
                continue;
            }
            i++;
        }


        return result;
    }

    private void hh() {
        System.out.println("ksjdfkljkl");

    }
}
