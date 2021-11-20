package diversificationCriterion;

public enum Country {
    Australia(0), Belgium(1), Canada(2), China(3), Denmark(4), Finland(5),
    France(6), Germany(7), Great_Britain(8), Hong_Kong(9), Ireland(10), Italy(11),
    Japan(12), Kazakhstan(13), Luxembourg(14), Netherlands(15), Poland(16),
    Russia(17), Singapore(18), South_Korea(19), Spain(20), Sweden(21),
    Switzerland(22), Taiwan(23), USA(24);

    int index;

    Country(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
