package com.bodkasoft.wrapper;

/**
 * The {@code Letter} class represents a single character.
 * <p>
 * This class provides functionality to encapsulate a character and retrieve its value
 * as well as a string representation of the character.
 * </p>
 */
public class Letter {

    /**
     * The character represented by this {@code Letter} instance.
     */
    private final char character;

    /**
     * Constructs a {@code Letter} object with the specified character.
     *
     * @param character The character to be encapsulated in this {@code Letter}.
     */
    public Letter(char character) {
        this.character = character;
    }

    /**
     * Returns the character value of this {@code Letter}.
     *
     * @return The character represented by this {@code Letter}.
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Returns a string representation of this {@code Letter}.
     * <p>
     * This method converts the character to a {@code String} and returns it.
     * </p>
     *
     * @return A string representation of the character.
     */
    @Override
    public String toString() {
        return Character.toString(character);
    }
}
