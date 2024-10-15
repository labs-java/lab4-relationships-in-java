package com.bodkasoft.wrapper;

public class Punctuation implements SentencePart {

    private char symbol;

    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
