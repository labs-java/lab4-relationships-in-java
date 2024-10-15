package com.bodkasoft.processor;

import com.bodkasoft.handler.Sentence;
import com.bodkasoft.handler.SentencePart;
import com.bodkasoft.handler.Text;
import com.bodkasoft.handler.Word;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private final Text text;

    public StringProcessor(Text text) {
        if (text == null || text.isEmpty()){
            throw new IllegalArgumentException("String cannot be null or empty");
        }

        this.text = text;
    }

    public SentencePart[] getWords() {
        Sentence[] sentences = text.getSentences();

        int wordsCount = 0;
        for (Sentence sentence : sentences) {
            SentencePart[] sentenceParts = sentence.getElements();
            for (SentencePart part : sentenceParts) {
                if (part instanceof Word && isWord(part)) {
                    wordsCount++;
                }
            }
        }

        SentencePart[] words = new Word[wordsCount];

        int wordIndex = 0;
        for (Sentence sentence : sentences) {
            SentencePart[] sentenceParts = sentence.getElements();
            for (SentencePart part : sentenceParts) {
                if (part instanceof Word && isWord(part)) {
                    words[wordIndex++] = part;
                }
            }
        }

        return words;
    }

    private boolean isWord(SentencePart sentencePart){
        if (sentencePart instanceof Word word){
            return word.length() >= 2;
        }else {
            return false;
        }
    }
}
