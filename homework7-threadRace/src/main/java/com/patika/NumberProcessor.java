package com.patika;

import java.util.ArrayList;
import java.util.List;

public class NumberProcessor extends Thread {
    private final List<Integer> numbers;
    private final List<Integer> oddNumbers;
    private final List<Integer> evenNumbers;

    public NumberProcessor(List<Integer> numbers, List<Integer> oddNumbers, List<Integer> evenNumbers) {
        this.numbers = numbers;
        this.oddNumbers = oddNumbers;
        this.evenNumbers = evenNumbers;
    }

    @Override
    public void run() {
        synchronized (oddNumbers) {
            synchronized (evenNumbers) {
                for (int number : numbers) {
                    if (number % 2 == 0) {
                        evenNumbers.add(number);
                    } else {
                        oddNumbers.add(number);
                    }
                }
            }
        }
    }
}

