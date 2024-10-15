package com.bodkasoft.handler;

public class Text {

    private final Sentence[] sentences;

    public Text(String text) {
        String processedText = removeExtraSpaces(text);
        String[] sentenceStrings = processedText.split("(?<=[.!?])\\s+");
        this.sentences = new Sentence[sentenceStrings.length];

        for (int i = 0; i < sentenceStrings.length; i++) {
            this.sentences[i] = new Sentence(sentenceStrings[i]);
        }
    }

    private String removeExtraSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    public boolean isEmpty(){
        return sentences.length == 0;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            text.append(sentences[i]);
            if(i < sentences.length - 1){
                text.append(" ");
            }
        }
        return text.toString();
    }
}
