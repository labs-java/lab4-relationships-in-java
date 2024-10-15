package com.bodkasoft;

import com.bodkasoft.wrapper.Text;
import com.bodkasoft.wrapper.Word;
import com.bodkasoft.processor.StringProcessor;

import java.util.Arrays;

public class Main {

    private static String _text = "In the quiet of early morning, the world seemed to hold its breath. " +
                "The sky, tinged with soft shades of pink and gold, hinted at the day’s promise. " +
                "A gentle breeze rustled the leaves, carrying with it the scent of fresh dew. " +
                "As the first rays of sunlight stretched across the horizon, they illuminated the path ahead, " +
                "reminding everyone that each new day holds the potential for growth, hope, and endless possibilities!" +
                " All it takes is a single step forward to begin the journey?";

    public static void main(String[] args) {
        try{
            Text text = new Text(_text);

            StringProcessor stringProcessor = new StringProcessor(text);

            System.out.println("<---Text--->");
            System.out.println(text);
            System.out.println();

            Word[] words = stringProcessor.getWords();

            Word[] wordsWithVowels = stringProcessor.findVowel(words);

            System.out.println("<---Words with Vowels--->");
            System.out.println(Arrays.toString(wordsWithVowels));
            System.out.println();

            Word[] sortedWords = stringProcessor.sortBySecondLetter(wordsWithVowels);

            System.out.println("<---Sorted Words--->");
            System.out.println(Arrays.toString(sortedWords));

        }catch (IllegalArgumentException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}