package nl.blitz.cleancode;

public class BackstagePass extends QualityChangingItem {

    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateBackstagePassQuality() {
        if (sellIn > 10) {
            quality += 1;
        } else if (sellIn <= 10) {
            quality += 2;
        } else if (sellIn <= 5) {
            quality += 3;
        }
    };

    public String updateQuality() {
        int old_quality = quality;

        if (sellIn == 0) {
            quality = 0;
            return "The concert already happened so the quality dropped to 0";
        }
        updateBackstagePassQuality();

        return "The quality of " + name + " has increased by " + (old_quality - quality);
    }

}
