package com.bodkasoft;

public class Main {

    private static String _text = "In the quiet of early morning, the world seemed to hold its breath. " +
                "The sky, tinged with soft shades of pink and gold, hinted at the day’s promise. " +
                "A gentle breeze rustled the leaves, carrying with it the scent of fresh dew. " +
                "As the first rays of sunlight stretched across the horizon, they illuminated the path ahead, " +
                "reminding everyone that each new day holds the potential for growth, hope, and endless possibilities!" +
                " All it takes is a single step forward to begin the journey?";

    public static void main(String[] args) {
        Text text = new Text(_text);

        System.out.println(text);
    }
}