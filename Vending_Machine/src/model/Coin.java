package model;

public enum Coin {
    ONE(1.0),
    TWO(2.0),
    FIVE(5.0),
    TWENTY(20.0);

    private final double value;
    Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
