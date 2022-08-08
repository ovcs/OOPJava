package Vocabulary.ctrl;

import Vocabulary.mdl.Pair;
import Vocabulary.mdl.Word;
import Vocabulary.srv.IService;
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

    }

    @Override
    public boolean correctAnswer() {
        return false;
    }

    @Override
    public Word loadRandomKeyWord() {
        return null;
    }
}
