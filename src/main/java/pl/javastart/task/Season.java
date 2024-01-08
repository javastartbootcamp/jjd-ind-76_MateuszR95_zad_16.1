package pl.javastart.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public enum Season {
    SPRING("wiosna", new String[]{"marzec", "kwiecień", "maj"}),
    SUMMER("lato", new String[]{"czerwiec", "lipiec", "sierpień"}),
    AUTUMN("jesień", new String[]{"wrzesień", "październik", "listopad"}),
    WINTER("zima", new String[]{"grudzień", "styczeń", "luty"});

    private String polishDescription;
    private String[] months;

    Season(String polishDescription, String[] months) {
        this.polishDescription = polishDescription;
        this.months = months;
    }

    public String getPolishDescription() {
        return polishDescription;
    }

    public void setPolishDescription(String polishDescription) {
        this.polishDescription = polishDescription;
    }

    public String[] getMonths() {
        return months;
    }

    public void setMonths(String[] months) {
        this.months = months;
    }

    public static Season getSeasonByMonth(String monthName) {
        Season[] values = Season.values();
        for (Season season : values) {
            if (Arrays.asList(season.getMonths()).contains(monthName)) {
                return season;
            }
        }
        throw new IllegalArgumentException("Nie znaleziono pory roku dla podanego miesiąca");
    }

    @Override
    public String toString() {
        return "Season{" +
                "polishDescription='" + polishDescription + '\'' +
                ", months=" + Arrays.toString(months) +
                '}';
    }
}