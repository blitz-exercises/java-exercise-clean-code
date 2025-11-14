package nl.blitz.cleancode.cleancode;

class QualityChangingItem extends Item {

    public QualityChangingItem(String name, int quality) {
        this.name = name;
        this.quality = quality;
    }

    public String updateQuality() {
        quality--;
        return "Quality updated to " + quality;
    }

    @Override
    public boolean qualityCanChance() {
        return true;
    }
}

