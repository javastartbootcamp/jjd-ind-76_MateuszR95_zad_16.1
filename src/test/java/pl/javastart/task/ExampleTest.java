package pl.javastart.task;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Timeout(5)
public class ExampleTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final SeasonManager seasonManager = new SeasonManager();

    @DisplayName("wiosna")
    @Test
    public void shouldDisplayLowercaseSpring() {
        // given
        Scanner scanner = provideInput("wiosna");

        // when
        seasonManager.run(scanner);

        // then
        assertThat(outContent.toString()).containsIgnoringCase("marzec, kwiecień, maj");
    }

    @DisplayName("Wiosna")
    @Test
    void shouldDisplayUppercaseSpring() {
        // given
        Scanner scanner = provideInput("Wiosna");

        // when
        seasonManager.run(scanner);

        // then
        assertThat(outContent.toString()).containsIgnoringCase("marzec, kwiecień, maj");
    }

    @DisplayName("lato")
    @Test
    void shouldDisplayLowercaseSummer() {
        // given
        Scanner scanner = provideInput("lato");

        // when
        seasonManager.run(scanner);

        // then
        assertThat(outContent.toString()).containsIgnoringCase("czerwiec, lipiec, sierpień");
    }

    @DisplayName("Lato")
    @Test
    void shouldDisplayUppercaseSummer() {
        // given
        Scanner scanner = provideInput("Lato");

        // when
        seasonManager.run(scanner);

        // then
        assertThat(outContent.toString()).containsIgnoringCase("czerwiec, lipiec, sierpień");
    }

    @DisplayName("zima")
    @Test
    void shouldDisplayLowercaseWinter() {
        // given
        Scanner scanner = provideInput("zima");

        // when
        seasonManager.run(scanner);

        // then
        assertThat(outContent.toString()).containsIgnoringCase("grudzień, styczeń, luty");
    }

    @DisplayName("Zima")
    @Test
    void shouldDisplayUppercaseWinter() {
        // given
        Scanner scanner = provideInput("Zima");

        // when
        seasonManager.run(scanner);

        // then
        assertThat(outContent.toString()).containsIgnoringCase("grudzień, styczeń, luty");
    }

    @DisplayName("jesień")
    @Test
    void shouldDisplayLowercaseAutumn() {
        // given
        Scanner scanner = provideInput("jesień");

        // when
        seasonManager.run(scanner);

        // then
        assertThat(outContent.toString()).containsIgnoringCase("wrzesień, październik, listopad");
    }

    @DisplayName("Jesień")
    @Test
    void shouldDisplayUppercaseAutumn() {
        // given
        Scanner scanner = provideInput("Jesień");

        // when
        seasonManager.run(scanner);

        // then
        assertThat(outContent.toString()).containsIgnoringCase("wrzesień, październik, listopad");
    }

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void cleanup() {
        System.setOut(originalOut);
    }

    private Scanner provideInput(String... lines) {
        String input = String.join("\r\n", lines);
        input += "\r\n";

        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        return new Scanner(testIn);
    }

}
