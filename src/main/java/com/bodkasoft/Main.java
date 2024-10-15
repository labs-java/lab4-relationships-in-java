package com.bodkasoft;

import com.bodkasoft.wrapper.Text;
import com.bodkasoft.wrapper.Word;
import com.bodkasoft.processor.StringProcessor;

import java.util.Arrays;

/**
 * The Main class demonstrates basic text processing by extracting words from a given text,
 * identifying words with vowels, and sorting them by the second letter.
 * It uses the {@link Text} and {@link StringProcessor} classes to perform these operations.
 * <p>
 * The following steps are executed:
 * <ul>
 *   <li>Initialize a {@link Text} object with a sample text.</li>
 *   <li>Use {@link StringProcessor} to extract words from the text.</li>
 *   <li>Find words that contain vowels.</li>
 *   <li>Sort the words by the second letter.</li>
 * </ul>
 * <p>
 * It handles basic exceptions such as {@link IllegalArgumentException} and {@link IndexOutOfBoundsException}.
 */
public class Main {

    /**
     * A sample text used for the text processing demonstration.
     * It contains multiple sentences with a mix of punctuation, words, and different sentence structures.
     */
    private static String _text = "In the quiet of early morning, the world seemed to hold its breath. " +
                "The sky, tinged with soft shades of pink and gold, hinted at the day’s promise. " +
                "A gentle breeze rustled the leaves, carrying with it the scent of fresh dew. " +
                "As the first rays of sunlight stretched across the horizon, they illuminated the path ahead, " +
                "reminding everyone that each new day holds the potential for growth, hope, and endless possibilities!" +
                " All it takes is a single step forward to begin the journey?";

    public static void main(String[] args) {
        try{
            // Initialize the Text object with the sample text
            Text text = new Text(_text);

            // Initialize the StringProcessor object to work with the Text object
            StringProcessor stringProcessor = new StringProcessor(text);

            // Display the original text
            System.out.println("<---Text--->");
            System.out.println(text);
            System.out.println();

            // Extract all words from the text
            Word[] words = stringProcessor.getWords();

            // Find words that contain vowels
            Word[] wordsWithVowels = stringProcessor.findVowel(words);

            // Display words containing vowels
            System.out.println("<---Words with Vowels--->");
            System.out.println(Arrays.toString(wordsWithVowels));
            System.out.println();

            // Sort words with vowels by their second letter
            Word[] sortedWords = stringProcessor.sortBySecondLetter(wordsWithVowels);

            // Display the sorted words
            System.out.println("<---Sorted Words--->");
            System.out.println(Arrays.toString(sortedWords));

        }catch (IllegalArgumentException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}