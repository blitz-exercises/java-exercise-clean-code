package nl.blitz.cleancode.cleancode;

class CleanCode {
    Item[] items;

    public CleanCode(Item[] items) {
        this.items = items;
    }

    public String daySimulator(int days) {
        while (days > 0) {
            for (Item item : items) {
                if (item.qualityCanChance()) {
                    days--;
                    return item.updateQuality();
                }
            }
        }
        return "The simulation has ended";
    }
}

