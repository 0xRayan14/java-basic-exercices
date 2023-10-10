package ch.jobtrek;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsTest {

    @Test
    void chunkArrayByStringSize() {
        var data = List.of("bonjour", "toto", "tutu", "BN", "jobtrek", "bastien", "Max", "Java", "Rust", "JavaScript");
        var result = Collections.chunkArrayByStringSize(data, 5);
        var shortest = List.of("toto", "tutu", "BN", "Max", "Java", "Rust");
        var longest = List.of("bonjour", "jobtrek", "bastien", "JavaScript");

        assertTrue(result.get(0).size() == shortest.size() && result.get(1).size() == longest.size());
        assertTrue(result.get(0).containsAll(shortest) && result.get(1).containsAll(longest));
    }

    @Test
    void frequencyOfApparition() {
        var result = List.of(1, 7, 6, 8, 2, 5, 4, 3);
        var mostFrequents = Collections.frequencyOfApparition(List.of(4,3,3,2,5,6,8,5,4,3,2,5,6,7,4,3,4,3,2,1,8));
        assertTrue(mostFrequents.containsAll(result));
        assertEquals(1, (int) mostFrequents.get(0));
        assertEquals(5, (int) mostFrequents.get(5));
        assertEquals(3, (int) mostFrequents.get(7));
    }

    @Test
    void sumArrays() {
        var numbers = List.of(
                List.of(1,6,3,9,3,2),
                List.of(5,7,3,2),
                List.of(9,1,4,3,5)
        );
        assertEquals(112, Collections.sumArrays(numbers));
    }

    @Test
    void bestStudent() {
        var students = Map.of("Toto", 3, "Tutu", 6, "Tata", 4, "Titi", 5);
        assertEquals("Tutu", Collections.bestStudent(students));
    }
}