package com.bodkasoft.wrapper;

/**
 * The {@code Punctuation} class represents a punctuation mark.
 * <p>
 * This class encapsulates a single punctuation character and provides functionality
 * to retrieve its value and represent it as a string.
 * </p>
 */
public class Punctuation implements SentencePart {

    /**
     * The punctuation symbol represented by this {@code Punctuation} instance.
     */
    private final char symbol;

    /**
     * Constructs a {@code Punctuation} object with the specified symbol.
     *
     * @param symbol The punctuation character to be encapsulated in this {@code Punctuation}.
     */
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns a string representation of this {@code Punctuation}.
     * <p>
     * This method converts the punctuation symbol to a {@code String} and returns it.
     * </p>
     *
     * @return A string representation of the punctuation symbol.
     */
    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
