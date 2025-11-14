package nl.blitz.cleancode.cleancode;

class QualityPreservingItem extends Item {
    QualityPreservingItem(String name, int quality) {
        this.name = name;
        this.quality = quality;
    }

    @Override
    public boolean qualityCanChance() {
        return false;
    }

    @Override
    public String updateQuality() {
        return "A Legendary Item always maintains the same quality and " + name + "'s quality is "
                + quality;
    }
}

