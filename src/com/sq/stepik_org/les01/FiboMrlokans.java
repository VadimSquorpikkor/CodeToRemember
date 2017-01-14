package com.sq.stepik_org.les01; // Created by mrlokans

import java.math.BigInteger;

public class FiboMrlokans {

    private long startTime = System.currentTimeMillis();
    private static int FIBO_MATRIX_INDEX = 1;

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboMrlokans fibo = new FiboMrlokans();
        fibo = new FiboMrlokans();
        int n = 999999;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n), fibo.time());
    }

    BigInteger fasterC(Integer n) {
        BigInteger[] initialMatrix = new BigInteger[]{
                BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO
        };

        BigInteger[] calculatedMatrix = exponentiateMatrix(initialMatrix, n);
        return calculatedMatrix[FIBO_MATRIX_INDEX];
    }

    public static BigInteger[] exponentiateMatrix(BigInteger[] matrix, int power){
        BigInteger[] result = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE};

        // Here we use exponentiation by squaring to optimize calculations
        // https://en.wikipedia.org/wiki/Exponentiation_by_squaring
        while (power != 0){
            if (power % 2 != 0){
                result = multiplySquareMatrices(result, matrix);
            }
            power /= 2;
            matrix = multiplySquareMatrices(matrix, matrix);
        }
        return result;
    }

    // Multiplies two 2x2 square matrices
    public static BigInteger[] multiplySquareMatrices(BigInteger[] first, BigInteger[] second){
        // multiplies row by column
        BigInteger[] result = new BigInteger[] {
                first[0].multiply(second[0]).add(first[1].multiply(second[2])),
                first[0].multiply(second[1]).add(first[1].multiply(second[3])),
                first[2].multiply(second[0]).add(first[3].multiply(second[2])),
                first[2].multiply(second[1]).add(first[3].multiply(second[3]))
        };
        return result;
    }
}

