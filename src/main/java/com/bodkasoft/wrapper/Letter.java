package com.bodkasoft.wrapper;

public class Letter {

    private char character;

    public Letter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return Character.toString(character);
    }
}
