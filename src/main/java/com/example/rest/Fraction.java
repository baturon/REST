package com.example.rest;

import lombok.Data;

@Data
public class Fraction{
    private int integer;
    private int numerator;
    private int denominator;


    public Fraction(int integer, int numerator, int denominator) {
        this.integer = integer;
        this.numerator = numerator;
        this.denominator = denominator;

    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int integer) {
        this.integer = integer;
    }

    public Fraction() {
    }

    @Override
    public String toString() {
        return "Fraction{" +
                +integer +
                " целых " + numerator +
                "/" + denominator +
                '}';
    }

    public String toString(int numerator, int denominator) {
        return "Fraction " +
                numerator +
                "/" + denominator;
    }

    public String toString(int integer) {
        return "" + integer;
    }

    public String toString(int integer, int numerator, int denominator) {
        return integer + " целых " + numerator + "/" + denominator;
    }



    public Fraction fractionAdduction(Fraction fraction,Fraction fraction1) {
        int sumNumerator = fraction.getNumerator() + fraction1.getNumerator();
        int sumDenominator = fraction.getDenominator() + fraction1.getDenominator();
        return new Fraction(sumNumerator, sumDenominator);

    }

    public boolean isProper() {
        return numerator < denominator;
    }

    public int fractionReduction() {
        return numerator / denominator;
    }
}
