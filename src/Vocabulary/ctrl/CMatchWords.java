package Vocabulary.ctrl;

import Vocabulary.mdl.Word;
import Vocabulary.srv.SMatchWords;

public interface CMatchWords {
    void loadMatchWords(SMatchWords sMatchWords);
    void setInputWord(String input);
    boolean getCorrectAnswer();
    Word loadRandomKeyWord();
}
