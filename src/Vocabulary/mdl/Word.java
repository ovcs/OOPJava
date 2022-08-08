package Vocabulary.mdl;

public class Word implements Comparable<Word> {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public int compareTo(Word o) {
        return word.compareTo(o.toString());
    }
}
