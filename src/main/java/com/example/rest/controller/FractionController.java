package com.example.rest.controller;

import com.example.rest.Fraction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fractions")
public class FractionController {
    @GetMapping("/{numerator}/{denominator}")
    public String getFraction(@PathVariable int numerator, @PathVariable int denominator) {
        Fraction fraction = new Fraction(numerator, denominator);
        return fraction.toString(numerator, denominator);
    }

    @GetMapping("/{numerator}/{denominator}/isProper")
    public boolean isProper(@PathVariable int numerator, @PathVariable int denominator) {
        Fraction fraction = new Fraction(numerator, denominator);
        return fraction.isProper();
    }

    @GetMapping("/{numerator}/{denominator}/reduction")
    public String reduction(@PathVariable int numerator, @PathVariable int denominator) {

        Fraction fraction = new Fraction(numerator, denominator);
        int integer = fraction.fractionReduction();
        numerator = numerator - integer * denominator;
        denominator = numerator % denominator < 0.01 ? 0 : denominator;

        if (denominator == 0) {
            Fraction fraction1 = new Fraction(integer);
            return fraction1.toString(integer);
        } else if (integer == 0) {
            return fraction.toString(numerator, denominator);
        } else return fraction.toString(integer, numerator, denominator);
    }

    @GetMapping("/{numerator}/{denominator}/addiction/{numerator1}/{denominator1}")
    public String addiction(@PathVariable int numerator, @PathVariable int denominator,
                            @PathVariable int numerator1, @PathVariable int denominator1) {
        Fraction fraction = new Fraction(numerator, denominator);
        Fraction fraction1 = new Fraction(numerator1, denominator1);
        Fraction sumFraction = new Fraction().fractionAdduction(fraction,fraction1);
        return sumFraction.toString(sumFraction.getNumerator(),sumFraction.getDenominator());
    }
}

