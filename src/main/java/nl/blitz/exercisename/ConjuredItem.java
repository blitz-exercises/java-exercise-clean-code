package nl.blitz.exercisename;

public class ConjuredItem extends DegradableItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateSpoilage() {
        if (quality > 0 && sellIn > 0) {
            quality -= 2;
        } else if (quality > 0 && sellIn == 0) {
            quality -= 4;
        }
        sellIn--;
    };

    public String updateQuality() {
        int old_quality = quality;

        if (this.spoiledCheck()) {
            return "The item: " + name + " has spoiled";
        }
        this.updateSpoilage();

        return "The quality of " + name + " has degraded by " + (old_quality - quality);
    }

}
