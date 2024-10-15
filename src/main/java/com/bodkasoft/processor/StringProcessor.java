package com.bodkasoft.processor;

import com.bodkasoft.wrapper.Sentence;
import com.bodkasoft.wrapper.SentencePart;
import com.bodkasoft.wrapper.Text;
import com.bodkasoft.wrapper.Word;

import java.util.Arrays;

/**
 * The {@code StringProcessor} class provides utility methods to process and manipulate text represented
 * by the {@link Text} object. It allows for the extraction of words from text, filtering words that
 * contain vowels, and sorting words based on specific criteria.
 * <p>
 * The class performs the following operations:
 * <ul>
 *   <li>Extract words from sentences in the text.</li>
 *   <li>Identify words that begin with vowels.</li>
 *   <li>Sort words by their second letter.</li>
 * </ul>
 * <p>
 * This class relies on {@link Sentence}, {@link SentencePart}, and {@link Word} classes to structure and
 * operate on text elements.
 */
public class StringProcessor {

    /**
     * The {@link Text} object that contains the text to be processed.
     */
    private final Text text;

    /**
     * Constructs a {@code StringProcessor} with the given {@link Text}.
     * <p>
     * Throws an {@link IllegalArgumentException} if the provided {@link Text} is null or empty.
     *
     * @param text The {@link Text} object to be processed.
     * @throws IllegalArgumentException if the {@link Text} is null or empty.
     */
    public StringProcessor(Text text) {
        if (text == null || text.isEmpty()){
            throw new IllegalArgumentException("String cannot be null or empty");
        }

        this.text = text;
    }

    /**
     * Extracts all {@link Word} objects from the {@link Text} object by iterating through the sentences
     * and sentence parts.
     *
     * @return an array of {@link Word} objects from the text.
     */
    public Word[] getWords() {
        Sentence[] sentences = text.getSentences();

        Word[] words = getSentenceParts(sentences);

        int wordIndex = 0;
        for (Sentence sentence : sentences) {
            SentencePart[] sentenceParts = sentence.getElements();
            for (SentencePart part : sentenceParts) {
                if (part instanceof Word word && isWord(word)) {
                    words[wordIndex++] = word;
                }
            }
        }

        return words;
    }

    /**
     * Helper method to count how many {@link Word} objects are present in an array of sentences.
     * <p>
     * This method iterates through all sentences and sentence parts, counting only those
     * {@link SentencePart} objects that are instances of {@link Word}.
     *
     * @param sentences an array of {@link Sentence} objects to process.
     * @return a new array of {@link Word} objects with the correct count.
     */
    private static Word[] getSentenceParts(Sentence[] sentences) {
        int wordsCount = 0;
        for (Sentence sentence : sentences) {
            SentencePart[] sentencePart = sentence.getElements();
            for (SentencePart part : sentencePart) {
                if (part instanceof Word word && isWord(word)) {
                    wordsCount++;
                }
            }
        }
        return new Word[wordsCount];
    }

    /**
     * Helper method to check if a {@link Word} object is a valid word.
     * A valid {@link Word} is defined as having at least 2 characters.
     *
     * @param word the {@link Word} to check.
     * @return {@code true} if the sentence part is a {@link Word} with at least 2 characters, {@code false} otherwise.
     */
    private static boolean isWord(Word word){
        return word.length() >= 2;
    }

    /**
     * Finds and returns an array of words that begin with a vowel ('a', 'e', 'i', 'o', 'u', case-insensitive).
     *
     * @param words an array of {@link Word} objects to search through.
     * @return an array of {@link Word} objects that start with a vowel.
     * @throws IllegalArgumentException if the {@code words} array is null or empty.
     */
    public Word[] findVowel(Word[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException("Words array cannot be null or empty");
        }

        int count = countVowelWords(words);

        Word[] wordsWithVowels = new Word[count];

        int index = 0;
        for (Word word : words) {
            if (isValidVowelWord(word)) {
                wordsWithVowels[index++] = word;
            }
        }

        return wordsWithVowels;
    }

    /**
     * Helper method to determine if a {@link Word} starts with a vowel.
     *
     * @param word the {@link Word} to check.
     * @return {@code true} if the word starts with a vowel, {@code false} otherwise.
     */
    private boolean isValidVowelWord(Word word) {
        return word != null && word.length() >= 2 && "aeiouAEIOU".indexOf(word.getCharById(0)) != -1;
    }

    /**
     * Counts the number of words that start with a vowel in the given array of {@link Word} objects.
     *
     * @param words an array of {@link Word} objects to search through.
     * @return the number of words that start with a vowel.
     */
    private int countVowelWords(Word[] words) {
        int count = 0;
        for (Word word : words) {
            if (isValidVowelWord(word)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Sorts the given array of {@link Word} objects based on their second letter.
     * <p>
     * Throws an {@link IllegalArgumentException} if any word has less than 2 characters.
     *
     * @param words an array of {@link Word} objects to sort.
     * @return the sorted array of {@link Word} objects.
     * @throws IllegalArgumentException if the {@code words} array is null, empty, or contains words with less than 2 characters.
     */
    public Word[] sortBySecondLetter(Word[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException("Words array cannot be null or empty");
        }

        for (Word word : words) {
            if (word.length() < 2) {
                throw new IllegalArgumentException("All words must have at least 2 characters");
            }
        }

        Arrays.sort(words, (word1, word2) -> Character.compare(word1.getCharById(1), word2.getCharById(1)));

        return words;
    }
}
