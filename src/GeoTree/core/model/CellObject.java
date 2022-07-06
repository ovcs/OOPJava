package GeoTree.core.model;


import GeoTree.geo.Sex;

public abstract class CellObject {
    SexualPatterns geneticSex;

    public CellObject(Sex sex) {
        if (sex == Sex.MALE) {
            this.geneticSex = SexualPatterns.INSEMINATE;
        } else if (sex == Sex.FEMALE) {
            this.geneticSex = SexualPatterns.INCUBATE;
        } else {
            this.geneticSex = SexualPatterns.STERILE;   // Default
        }
    }
}
