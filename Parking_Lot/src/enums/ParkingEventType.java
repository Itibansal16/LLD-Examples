package enums;

public enum ParkingEventType {
    ENTRY(-1),
    EXIT(1);

    private int change;
    ParkingEventType(int change) {
        this.change = change;
    }
    public int getChange() {
        return this.change;
    }
}
