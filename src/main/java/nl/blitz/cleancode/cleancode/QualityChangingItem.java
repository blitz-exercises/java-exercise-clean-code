package nl.blitz.cleancode.cleancode;

class QualityChangingItem extends Item {
    public String updateQuality() {
        quality--;
        return "Quality updated to " + quality;
    }
}

