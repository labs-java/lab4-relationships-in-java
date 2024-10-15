package com.bodkasoft.processor;

import com.bodkasoft.wrapper.Sentence;
import com.bodkasoft.wrapper.SentencePart;
import com.bodkasoft.wrapper.Text;
import com.bodkasoft.wrapper.Word;

import java.util.Arrays;

public class StringProcessor {

    private final Text text;

    public StringProcessor(Text text) {
        if (text == null || text.isEmpty()){
            throw new IllegalArgumentException("String cannot be null or empty");
        }

        this.text = text;
    }

    public Word[] getWords() {
        Sentence[] sentences = text.getSentences();

        Word[] words = getSentenceParts(sentences);

        int wordIndex = 0;
        for (Sentence sentence : sentences) {
            SentencePart[] sentenceParts = sentence.getElements();
            for (SentencePart part : sentenceParts) {
                if (part instanceof Word word && isWord(part)) {
                    words[wordIndex++] = word;
                }
            }
        }

        return words;
    }

    private static Word[] getSentenceParts(Sentence[] sentences) {
        int wordsCount = 0;
        for (Sentence sentence : sentences) {
            SentencePart[] sentencePart = sentence.getElements();
            for (SentencePart part : sentencePart) {
                if (part instanceof Word && isWord(part)) {
                    wordsCount++;
                }
            }
        }
        return new Word[wordsCount];
    }

    private static boolean isWord(SentencePart sentencePart){
        if (sentencePart instanceof Word word){
            return word.length() >= 2;
        }else {
            return false;
        }
    }

    public Word[] findVowel(Word[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException("Words array cannot be null or empty");
        }

        int count = countVowelWords(words);

        Word[] wordsWithVowels = new Word[count];

        int index = 0;
        for (Word word : words) {
            if (isValidVowelWord(word)) {
                wordsWithVowels[index++] = word;
            }
        }

        return wordsWithVowels;
    }

    private boolean isValidVowelWord(Word word) {
        return word != null && word.length() >= 2 && "aeiouAEIOU".indexOf(word.getCharById(0)) != -1;
    }

    private int countVowelWords(Word[] words) {
        int count = 0;
        for (Word word : words) {
            if (isValidVowelWord(word)) {
                count++;
            }
        }
        return count;
    }

    public Word[] sortBySecondLetter(Word[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException("Words array cannot be null or empty");
        }

        for (Word word : words) {
            if (word.length() < 2) {
                throw new IllegalArgumentException("All words must have at least 2 characters");
            }
        }

        Arrays.sort(words, (word1, word2) -> Character.compare(word1.getCharById(1), word2.getCharById(1)));

        return words;
    }
}
