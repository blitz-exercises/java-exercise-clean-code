package nl.blitz.exercisename;

public abstract class DegradableItem extends QualityChangingItem {

    public DegradableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract String updateQuality();
    public abstract void updateSpoilage();

    public Boolean spoiledCheck() {
        if (quality == 0) {
            return true;
        }
        return false;
    }
}
