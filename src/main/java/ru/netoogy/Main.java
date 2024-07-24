package ru.netoogy;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.netoogy.CompareMethods.*;
import static ru.netoogy.GenerateText.generateText;

public class Main {
    public static AtomicInteger lengthThree = new AtomicInteger();
    public static AtomicInteger lengthFour = new AtomicInteger();
    public static AtomicInteger lengthFive = new AtomicInteger();

    public static void main(String[] args) {

        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread threadPalindrom = new Thread(() -> {
            for (String string : texts) {
                if (isPalindrom(string)) {
                    incrementValue(string.length());
                }
            }
        });

        Thread CompareIdentical = new Thread(() -> {
            for (String string : texts) {
                if (CompareIdentical(string)) {
                    incrementValue(string.length());
                }
            }
        });

        Thread CompareNaturalOrder = new Thread(() -> {
            for (String string : texts) {
                if (CompareNaturalOrder(string)) {
                    incrementValue(string.length());
                }
            }
        });

        threadPalindrom.start();
        CompareIdentical.start();
        CompareNaturalOrder.start();
        try {
            threadPalindrom.join();
            CompareIdentical.join();
            CompareNaturalOrder.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadPalindrom.interrupt();
        CompareIdentical.interrupt();
        CompareNaturalOrder.interrupt();

        System.out.println("Красивых слов с длиной 3: " + lengthThree.get() + " шт." +
                           "\nКрасивых слов с длиной 4 : " + lengthFour + " шт." +
                           "\nКрасивых слов с длиной 5 : " + lengthFive + " шт.");
    }
}
