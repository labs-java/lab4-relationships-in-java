package com.bodkasoft.wrapper;

/**
 * The {@code Text} class represents a collection of sentences extracted from a given text string.
 * It processes the input string, splits it into individual sentences, and provides functionality
 * to retrieve and manipulate the text at the sentence level.
 * <p>
 * This class provides:
 * <ul>
 *   <li>Text initialization with sentence parsing and processing.</li>
 *   <li>Methods to check if the text is empty.</li>
 *   <li>A method to retrieve all sentences from the text.</li>
 *   <li>A custom {@code toString()} method for displaying the entire text.</li>
 * </ul>
 * <p>
 * The {@link Sentence} class is used to represent each individual sentence within the text.
 */
public class Text {

    /**
     * An array of {@link Sentence} objects representing the sentences in the text.
     */
    private final Sentence[] sentences;

    /**
     * Constructs a {@code Text} object from a given string.
     * <p>
     * The constructor processes the input string to remove extra spaces and splits the text into sentences.
     * Sentences are determined by punctuation marks ('.', '!', '?') followed by a space.
     * Each sentence is then used to create an instance of the {@link Sentence} class.
     *
     * @param text The input string to be processed and split into sentences.
     * @throws IllegalArgumentException if the provided text is null or empty.
     */
    public Text(String text) {
        String processedText = removeExtraSpaces(text);
        String[] sentenceStrings = processedText.split("(?<=[.!?])\\s+");
        this.sentences = new Sentence[sentenceStrings.length];

        for (int i = 0; i < sentenceStrings.length; i++) {
            this.sentences[i] = new Sentence(sentenceStrings[i]);
        }
    }

    /**
     * Removes extra spaces from the given text.
     * <p>
     * Consecutive spaces are replaced with a single space, and any leading or trailing spaces are trimmed.
     *
     * @param text The input string to be cleaned of extra spaces.
     * @return A processed string with no extra spaces.
     */
    private String removeExtraSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    /**
     * Checks if the text is empty, i.e., it contains no sentences.
     *
     * @return {@code true} if the text contains no sentences, {@code false} otherwise.
     */
    public boolean isEmpty(){
        return sentences.length == 0;
    }

    /**
     * Returns the array of {@link Sentence} objects that make up the text.
     *
     * @return An array of {@link Sentence} objects.
     */
    public Sentence[] getSentences() {
        return sentences;
    }

    /**
     * Returns a string representation of the entire text.
     * <p>
     * The method concatenates all the sentences into a single string, separated by a space between sentences.
     *
     * @return The entire text as a {@code String}.
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            text.append(sentences[i]);
            if(i < sentences.length - 1){
                text.append(" ");
            }
        }
        return text.toString();
    }
}
