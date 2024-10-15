package com.bodkasoft.wrapper;

/**
 * The {@code Word} class represents a word as a sequence of {@link Letter} objects.
 * Each instance of this class encapsulates a string and provides functionality to
 * access and manipulate the individual characters (letters) that comprise the word.
 * <p>
 * This class offers:
 * <ul>
 *   <li>Initialization of a word from a given string.</li>
 *   <li>Methods to retrieve the length of the word.</li>
 *   <li>Access to individual letters within the word.</li>
 *   <li>A custom {@code toString()} method for displaying the word as a string.</li>
 * </ul>
 */
public class Word implements SentencePart {

    /**
     * An array of {@link Letter} objects representing the individual characters of the word.
     */
    private Letter[] word;

    /**
     * Constructs a {@code Word} object from the provided string.
     * <p>
     * Each character in the string is converted into a {@link Letter} object, which is stored
     * in the internal array.
     *
     * @param word The input string representing the word to be created.
     * @throws IllegalArgumentException if the provided word is null or empty.
     */
    public Word(String word) {
        if (word == null || word.isEmpty()){
            throw new IllegalArgumentException("Word cannot be null or empty");
        }

        this.word = new Letter[word.length()];
        for(int i = 0; i < word.length(); i++){
            this.word[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * Returns the length of the word, which is the number of characters it contains.
     *
     * @return The number of {@link Letter} objects in the word.
     */
    public int length(){
        return word.length;
    }

    /**
     * Returns the array of {@link Letter} objects that make up the word.
     *
     * @return An array of {@link Letter} objects representing the characters in the word.
     */
    public Letter[] getWord() {
        return word;
    }

    /**
     * Returns the character at the specified index in the word.
     *
     * @param i The index of the character to retrieve.
     * @return The character at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public char getCharById(int i){
        if (i < 0 || i >= word.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return word[i].getCharacter();
    }

    /**
     * Returns a string representation of the word by concatenating all the letters.
     * <p>
     * This method reconstructs the word from its individual {@link Letter} objects.
     *
     * @return The full word as a single {@code String}.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : word) {
            sb.append(letter);
        }
        return sb.toString();
    }
}
