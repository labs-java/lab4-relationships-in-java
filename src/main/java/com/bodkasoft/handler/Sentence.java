package com.bodkasoft.handler;

import java.util.regex.Pattern;

public class Sentence {

    private final SentencePart[] elements;

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

    public Sentence(int sentenceLength) {
        this.elements = new SentencePart[sentenceLength];
    }

    public void setElement(int index, SentencePart element) {
        this.elements[index] = element;
    }

    public SentencePart[] getElements(){
        return this.elements;
    }

    public int getLength() {
        return this.elements.length;
    }

    private void deleteSpaceInTokens(String[] tokens) {
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].charAt(0) == ' '){
                tokens[i] = tokens[i].substring(1);
            }
        }
    }

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
