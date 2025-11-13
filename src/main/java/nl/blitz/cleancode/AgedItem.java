package nl.blitz.cleancode;

public class AgedItem extends QualityChangingItem {

    public AgedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public boolean canStillAge() {
        if (quality < 50) {
            return true;
        } else {
            return false;
        }
    };

    public String updateQuality() {
        int old_quality = quality;

        if (canStillAge()) {
            return "The quality of " + name + " has increased by " + (old_quality - quality);
        }
        return "The quality of " + name + " has reached it's max potential and stayed the same";
    }

    // THERES SEEMS TO BE NO POINT IN MANAGING THE sellIn value since the item
    // only gets better
    // or do we asume that when i reaches sellin 0 its to ripe/spoiled?

}
