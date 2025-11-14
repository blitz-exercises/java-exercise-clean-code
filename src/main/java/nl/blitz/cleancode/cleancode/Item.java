package nl.blitz.cleancode.cleancode;

abstract class Item {
    String name;
    int quality;

    public abstract String updateQuality();
    public abstract boolean qualityCanChance();
}

