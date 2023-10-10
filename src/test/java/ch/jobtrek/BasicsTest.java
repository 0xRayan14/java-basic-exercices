package ch.jobtrek;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BasicsTest {

    @Test
    void someConditionals() {
        assertTrue(Basics.someConditionals(4, 8));
        assertTrue(Basics.someConditionals(11, 7));
        assertFalse(Basics.someConditionals(3, 9));
    }

    @Test
    void strings() {
        assertEquals(
                "TOTO TUTU TATA TITI",
                Basics.strings("Timothée Toto Rayan Nils Bastien Tutu Tata Alex Bilal Noe Thierry Titi Elliot")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "Le java c'est génial,Le PHP c'est génial,java, PHP",
            "JavaScript is cool,Rust is cool,JavaScript,Rust",
            "Toto Titi Tata Toto,Tata Titi Tata Tata,Toto,Tata"
    })
    void findAndReplace(String haystack, String result, String needle, String newWord) {
        assertEquals(
                result,
                Basics.findAndReplace(needle, haystack, newWord)
        );
    }
}