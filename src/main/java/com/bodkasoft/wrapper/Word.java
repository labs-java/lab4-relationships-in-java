package com.bodkasoft.wrapper;

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

    public char getCharById(int i){
        if (i < 0 || i >= word.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return word[i].getCharacter();
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
