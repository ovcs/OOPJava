package Vocabulary.io;

import java.util.Scanner;

public class Input {
    private Scanner sc;

    public Input() {
        this.sc = new Scanner(System.in);
    }

    public String enterString() {
        return sc.next();
    }
}
