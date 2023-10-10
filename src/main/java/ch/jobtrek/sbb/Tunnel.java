package ch.jobtrek.sbb;

import java.util.Objects;

public class Tunnel implements Tunnelable {

    String name;

    double kilometerLength;

    int buildYear;

    String canton;

    public Tunnel(String name, double kilometerLength, int buildYear, String canton) {
        this.name = name;
        this.kilometerLength = kilometerLength;
        this.buildYear = buildYear;
        this.canton = canton;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getKilometerLength() {
        return kilometerLength;
    }

    @Override
    public int getBuildYear() {
        return buildYear;
    }

    @Override
    public String getCanton() {
        return canton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tunnel tunnel = (Tunnel) o;
        return getKilometerLength() == tunnel.getKilometerLength() && getBuildYear() == tunnel.getBuildYear() && Objects.equals(getName(), tunnel.getName()) && Objects.equals(getCanton(), tunnel.getCanton());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getKilometerLength(), getBuildYear(), getCanton());
    }

    @Override
    public String toString() {
        return "Tunnel{" +
                "name='" + name + '\'' +
                ", kilometerLength=" + kilometerLength +
                ", buildYear=" + buildYear +
                ", canton='" + canton + '\'' +
                '}';
    }
}
