package com.bodkasoft.handler;

public class Letter {

    private char character;

    public Letter(char character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return Character.toString(character);
    }
}
