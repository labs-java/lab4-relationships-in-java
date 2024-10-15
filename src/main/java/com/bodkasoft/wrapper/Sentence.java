package com.bodkasoft.wrapper;

import java.util.regex.Pattern;

/**
 * The {@code Sentence} class represents a sentence consisting of multiple {@link SentencePart} objects,
 * which can be either {@link Word} or {@link Punctuation}. It processes a given string, breaking it into
 * words and punctuation marks, and provides access to the individual components of the sentence.
 * <p>
 * This class offers:
 * <ul>
 *   <li>Sentence parsing and tokenization from a given string.</li>
 *   <li>Methods to retrieve or set individual elements of the sentence.</li>
 *   <li>A method to get the length of the sentence.</li>
 *   <li>A custom {@code toString()} method to reconstruct the sentence as a string.</li>
 * </ul>
 */
public class Sentence {

    /**
     * An array of {@link SentencePart} objects representing the individual components
     * of the sentence. Components can be either {@link Word} or {@link Punctuation}.
     */
    private final SentencePart[] elements;

    /**
     * Constructs a {@code Sentence} object from the provided string.
     * <p>
     * The constructor tokenizes the input string by separating it into words and punctuation marks.
     * Words are identified using a regular expression pattern that matches alphabetic characters,
     * while punctuation marks are identified by standard punctuation symbols.
     *
     * @param sentence The input string representing a sentence.
     */
    public Sentence(String sentence) {
        String[] tokens = sentence.split("(?=\\p{Punct})|(?<=\\p{Punct})|\\s+");
        this.elements = new SentencePart[tokens.length];

        deleteSpaceInTokens(tokens);

        Pattern wordPattern = Pattern.compile("^[a-zA-Zа-яА-Я’]+$");
        Pattern punctPattern = Pattern.compile("\\p{Punct}");

        for (int i = 0; i < tokens.length; i++) {
            if (wordPattern.matcher(tokens[i]).matches()) {
                this.elements[i] = new Word(tokens[i]);
            }else if (punctPattern.matcher(tokens[i]).matches()) {
                this.elements[i] = new Punctuation(tokens[i].charAt(0));
            }
        }
    }

    /**
     * Constructs a {@code Sentence} object with a specified number of elements.
     * This constructor is typically used when creating a sentence of a known length
     * but where the individual parts are not yet initialized.
     *
     * @param sentenceLength The number of {@link SentencePart} elements in the sentence.
     */
    public Sentence(int sentenceLength) {
        this.elements = new SentencePart[sentenceLength];
    }

    /**
     * Sets the specified element at the given index in the sentence.
     *
     * @param index   The index at which to set the element.
     * @param element The {@link SentencePart} to set at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void setElement(int index, SentencePart element) {
        if (index < 0 || index >= this.elements.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        this.elements[index] = element;
    }

    /**
     * Returns the element at the specified index in the sentence.
     *
     * @param index The index of the element to retrieve.
     * @return The {@link SentencePart} at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public SentencePart getElementById(int index) {
        if (index < 0 || index >= this.elements.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return this.elements[index];
    }

    /**
     * Returns the array of {@link SentencePart} elements that make up the sentence.
     * <p>
     * This method provides access to the components of the sentence, including both words and punctuation.
     *
     * @return An array of {@link SentencePart} objects representing the sentence elements.
     */
    public SentencePart[] getElements(){
        return this.elements;
    }

    /**
     * Returns the number of elements in the sentence.
     * <p>
     * This method is useful to get the total number of {@link SentencePart} components (words and punctuation)
     * that make up the sentence.
     *
     * @return The length of the sentence (number of elements).
     */
    public int getLength() {
        return this.elements.length;
    }

    /**
     * Removes leading spaces from the tokens in the input array.
     * <p>
     * This method processes each token and, if the token starts with a space, removes it.
     * It is primarily used to clean up the tokens after splitting the sentence.
     *
     * @param tokens The array of tokens to process.
     */
    private void deleteSpaceInTokens(String[] tokens) {
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].charAt(0) == ' '){
                tokens[i] = tokens[i].substring(1);
            }
        }
    }

    /**
     * Returns a string representation of the sentence by concatenating all the elements.
     * <p>
     * Punctuation marks are placed directly after words without spaces, while words are separated by spaces.
     *
     * @return The full sentence as a single {@code String}.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                if (!(elements[i + 1] instanceof Punctuation)) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
