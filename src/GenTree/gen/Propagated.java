package GenTree.gen;

public abstract class Propagated {
    private SexualPatterns geneticSex;

    public void addGeneticSex(Sex sex) {
        if (sex == Sex.MALE) {
            this.geneticSex = SexualPatterns.INSEMINATE;
        } else if (sex == Sex.FEMALE) {
            this.geneticSex = SexualPatterns.INCUBATE;
        } else {
            this.geneticSex = SexualPatterns.STERILE;   // Default
        }
    }

    public SexualPatterns getGeneticSex() {
        return geneticSex;
    }
}