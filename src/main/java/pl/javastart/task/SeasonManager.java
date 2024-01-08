package pl.javastart.task;

import java.util.Arrays;
import java.util.Scanner;

public class SeasonManager {

    // uzupełnij metodę - do wczytywania danych użyj przekazany Scanner
    public void run(Scanner scanner) {
        Season season = null;
        do {
            printSeasons();
            String seasonName = readSeason(scanner);
            try {
                season = getSeason(seasonName);
                printSeasonMonths(season);
                printSeasonByMonth(scanner);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (season == null);
    }

    private static void printSeasonByMonth(Scanner scanner) {
        System.out.println("Wyszukaj porę roku na podstawie miesiąca:");
        String monthName = scanner.nextLine();
        Season seasonByMonth = Season.getSeasonByMonth(monthName);
        System.out.println(seasonByMonth.getPolishDescription());
    }

    public void printSeasons() {
        System.out.println("Podaj porę roku:");
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value.getPolishDescription());
        }
    }

    public String readSeason(Scanner scanner) {
        return scanner.nextLine();
    }

    public Season getSeason(String chosenSeasonName) {
        Season chosenSeason = null;
        Season[] seasons = Season.values();
        for (Season season : seasons) {
            if (season.getPolishDescription().equalsIgnoreCase(chosenSeasonName)) {
                chosenSeason = season;
            }
        }
        if (chosenSeason == null) {
            throw new IllegalArgumentException("Wybrałeś nieprawidłową opcję");
        }
        return chosenSeason;
    }

    public void printSeasonMonths(Season season) {
        String[] months = season.getMonths();
        System.out.println("W tej porze roku są następujące miesiące: ");
        System.out.println(Arrays.toString(months));
    }

}
