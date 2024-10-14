package com.bodkasoft;

import java.util.regex.Pattern;

public class Sentence {

    private Object[] elements;

    public Sentence(String sentence) {
        String[] tokens = sentence.split("(?=\\p{Punct})|(?<=\\p{Punct})|\\s+");
        this.elements = new Object[tokens.length];

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
