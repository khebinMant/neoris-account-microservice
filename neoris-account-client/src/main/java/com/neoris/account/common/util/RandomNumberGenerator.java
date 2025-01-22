package com.neoris.account.common.util;

import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        // Generar un número aleatorio de 10 dígitos
        long randomNumber = generateRandomNumber(10);
        System.out.println("Número aleatorio de 10 dígitos: " + randomNumber);
    }

    public static long generateRandomNumber(int numDigits) {
        Random random = new Random();
        long number = (long) (random.nextDouble() * Math.pow(10, numDigits));
        return number;
    }
}