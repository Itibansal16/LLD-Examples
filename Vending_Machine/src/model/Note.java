package model;

public enum Note {
    TEN(10.0),
    TWENTY(20.0),
    HUNDRED(100.0),
    FIVE_HUNDRED(500.0),
    TWO_THOUSAND(2000.0);
    private final double value;
    Note(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
