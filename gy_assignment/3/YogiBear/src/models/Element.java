package models;

public enum Element {
    YOGI('Y'), HILL('M'), TREE('T'), BASKET('B'), RANGER('R'), FENCE('#'), EMPTY(' ');

    public final char representation;

    Element(char rep){ representation = rep; }
}
