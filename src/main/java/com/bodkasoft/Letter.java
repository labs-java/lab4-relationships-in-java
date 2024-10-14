package com.bodkasoft;

public class Letter {

    private char character;

    public Letter(char character) {
        this.character = character;
    }

    public char getLetter() {
        return character;
    }
    public void setLetter(char character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return Character.toString(character);
    }
}
