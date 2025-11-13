package nl.blitz.exercisename;

public abstract class QualityChangingItem extends Item {

    public QualityChangingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    
    public abstract String updateQuality();
}
