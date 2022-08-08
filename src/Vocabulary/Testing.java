package Vocabulary;

import Vocabulary.ctrl.VocabularyCtrl;
import Vocabulary.ext.Randomizer;
import Vocabulary.io.Input;
import Vocabulary.repo.Repository;
import Vocabulary.srv.SMatchWords;
import Vocabulary.io.Output;

public class Testing {
    public static void main(String[] args) {
        VocabularyCtrl vc = new VocabularyCtrl();
        Input keyboard = new Input();
        Output view = new Output();

        vc.loadMatchWords(new SMatchWords(new Randomizer(), new Repository<>()));
        for (int i = 0; i < 5; i++) {
            view.showKeyWord(vc.loadRandomKeyWord());
            vc.setInputWord(keyboard.enterString());
            view.showCorrectAnswer(vc.getCorrectAnswer());
        }
    }
}
