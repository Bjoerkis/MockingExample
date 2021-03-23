package com.example;

import java.util.Arrays;
import java.util.function.Consumer;


public class Calculator {

    public int add(String text) {

        int sum;



        if (text.isEmpty()) {

            sum = 0;

        } else {

            if (text.startsWith("//")) {

                String[] newText;

                var textSubstring = text.substring(2, 3);
                var textWithoutDelimiter = text.substring(4);

                newText = textWithoutDelimiter.split(textSubstring);


                sum = Arrays.stream(newText)
                        .map(Integer::parseInt)
                        .mapToInt(each -> each).sum();

            } else {

                String[] newText = text.split("[\n,;/^*=]");

                sum = Arrays.stream(newText)
                        .map(Integer::parseInt)
                        .peek(exceptionThrowing)
                        .mapToInt(each -> each).sum();

            }
        }
        return sum;
    }
    Consumer<Integer> exceptionThrowing = x ->{
        if(x<0) {
            throw new RuntimeException();
        }
    };
}
