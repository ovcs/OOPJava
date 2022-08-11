package Vocabulary.srv;

import Vocabulary.ext.IDCreator;
import Vocabulary.ext.Randomizer;
import Vocabulary.mdl.Pair;
import Vocabulary.mdl.Word;
import Vocabulary.repo.Repository;

import java.util.Iterator;

public class SMatchWords {
    private boolean correctAnswer;
    private final Repository<Pair<Word>> repository;
    private final Randomizer randomizer;

    private Pair<Word> temp;

    public SMatchWords(Randomizer randomizer, Repository<Pair<Word>> repository) {
        this.randomizer = randomizer;
        this.repository = repository;
    }

    public Word getRandomWord() {
        return repository.getByID(
                        randomizer.getRandomID(IDCreator.getInstance()))
                  .getFirst();
    }

    public void compareWords(Word word) {
        correctAnswer = temp.getSecond().equals(word);
    }

    public boolean getLastCompare() {
        return correctAnswer;
    }
}
