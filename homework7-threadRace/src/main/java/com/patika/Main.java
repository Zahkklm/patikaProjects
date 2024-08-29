package com.patika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1'den 10.000'e kadar olan sayıları içeren liste oluşturuluyor.
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        // 10.000 elemanı 4 eşit parçaya bölelim.
        int chunkSize = 10000 / 4;
        List<Integer> chunk1 = numbers.subList(0, chunkSize);
        List<Integer> chunk2 = numbers.subList(chunkSize, 2 * chunkSize);
        List<Integer> chunk3 = numbers.subList(2 * chunkSize, 3 * chunkSize);
        List<Integer> chunk4 = numbers.subList(3 * chunkSize, 10000);

        // Tek ve çift sayıları tutacak olan ArrayList'ler.
        List<Integer> oddNumbers = Collections.synchronizedList(new ArrayList<>());
        List<Integer> evenNumbers = Collections.synchronizedList(new ArrayList<>());

        // Thread'leri oluşturuyoruz.
        NumberProcessor thread1 = new NumberProcessor(chunk1, oddNumbers, evenNumbers);
        NumberProcessor thread2 = new NumberProcessor(chunk2, oddNumbers, evenNumbers);
        NumberProcessor thread3 = new NumberProcessor(chunk3, oddNumbers, evenNumbers);
        NumberProcessor thread4 = new NumberProcessor(chunk4, oddNumbers, evenNumbers);

        // Thread'leri başlatıyoruz.
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Thread'lerin bitmesini bekliyoruz.
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sonuçları yazdırıyoruz.
        System.out.println("Even Numbers Count: " + evenNumbers.size());
        System.out.println("Odd Numbers Count: " + oddNumbers.size());

        // Optional: İlk birkaç sayıyı görmek için.
        System.out.println("First 10 Even Numbers: " + evenNumbers.subList(0, Math.min(10, evenNumbers.size())));
        System.out.println("First 10 Odd Numbers: " + oddNumbers.subList(0, Math.min(10, oddNumbers.size())));
    }
}
