package Vocabulary.ext;

import java.util.Random;

// TODO Преобразовать под любой формат
public class Randomizer {
    private final Random random;

    // Добавим лог уже выпавших слов, чтобы не повторялись

    public Randomizer() {
        this.random = new Random();
    }

    public int getRandomInteger(int start, int end) {
        return random.nextInt(start, end);
    }

    public ID getRandomID(IDCreator idCreator) {
        return new ID(random.nextInt(1, idCreator.getCurrentID().value()));
    }
}
