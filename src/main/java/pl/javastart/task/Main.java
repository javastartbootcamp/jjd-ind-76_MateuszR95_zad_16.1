package pl.javastart.task;

import java.util.Scanner;

public class Main {

    // nie zmieniaj zawartości tej metody - swoją implementację dodaj do pl.javastart.task.SeasonManager
    public static void main(String[] args) {
        SeasonManager seasonManager = new SeasonManager();
        seasonManager.run(new Scanner(System.in));
    }
}
