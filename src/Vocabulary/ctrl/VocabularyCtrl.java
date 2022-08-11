package Vocabulary.ctrl;

import Vocabulary.mdl.Word;
import Vocabulary.srv.SMatchWords;

public class VocabularyCtrl implements CMatchWords {
    private SMatchWords sMatchWords;
    public VocabularyCtrl() {

    }

    @Override
    public void loadMatchWords(SMatchWords sMatchWords) {
        this.sMatchWords = sMatchWords;
    }

    @Override
    public void setInputWord(String input) {
        sMatchWords.compareWords(new Word(input));
    }

    @Override
    public boolean getCorrectAnswer() {
        return sMatchWords.getLastCompare();
    }

    @Override
    public Word loadRandomKeyWord() {
        return sMatchWords.getRandomWord();
    }
}
