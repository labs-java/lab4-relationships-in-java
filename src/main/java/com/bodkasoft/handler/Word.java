package com.bodkasoft.handler;

public class Word implements SentencePart {

    private Letter[] word;

    public Word(String word) {
        this.word = new Letter[word.length()];
        for(int i = 0; i < word.length(); i++){
            this.word[i] = new Letter(word.charAt(i));
        }
    }

    public int length(){
        return word.length;
    }

    public Letter[] getWord() {
        return word;
    }

    public void setWord(Letter[] word) {
        this.word = word;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : word) {
            sb.append(letter);
        }
        return sb.toString();
    }
}
