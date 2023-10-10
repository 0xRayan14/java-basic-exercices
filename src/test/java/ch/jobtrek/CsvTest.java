package ch.jobtrek;

import ch.jobtrek.sbb.Tunnel;
import ch.jobtrek.sbb.Tunnelable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CsvTest {

    List<Tunnelable> tunnels;

    Tunnel gotthard = new Tunnel("Gotthard-Basistunnel", 57.363, 2016, "Ticino");
    Tunnel simplon = new Tunnel("Simplontunnel", 19.82, 1900, "Valais");

    Tunnel adlertunnel = new Tunnel("Adlertunnel", 5.303, 2000, "Basel-Landschaft");

    @BeforeEach
    void setUp() throws URISyntaxException {
        tunnels = Csv.importCSVfile(Objects.requireNonNull(getClass().getClassLoader().getResource("tunnel.csv")).toURI());
    }

    @Test
    void importCSVfile() throws URISyntaxException {
        assertFalse(tunnels.isEmpty());
        assertTrue(tunnels.contains(gotthard));
    }

    @Test
    void tenLongestTunnels() {
        var result = Csv.tenLongestTunnels(tunnels);
        assertEquals(10, result.size());
        assertEquals(result.get(0), gotthard);
        assertEquals(result.get(1), simplon);
        assertEquals(result.get(9), adlertunnel);
    }

    @Test
    void computeAverageLength() {
        assertEquals(1.1362906574394462, Csv.computeAverageLength(tunnels));
    }

    @Test
    void tunnelsByYears() {
        var histogram = Csv.tunnelsByYears(tunnels);
        assertEquals(3, histogram.get(1927));
        assertEquals(2, histogram.get(1888));
        assertEquals(13, histogram.get(2019));
        assertEquals(3, histogram.get(1993));
    }

    @Test
    void yearWithBiggestTunnelBuilds() {
        assertEquals(1882, Csv.yearWithBiggestTunnelBuilds(tunnels));
    }
}