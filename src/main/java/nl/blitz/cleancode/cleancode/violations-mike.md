# violations found in this module

## Both qualitychaiging and preserving item have no constructors en kunnen geen instanties krijgen dus.

## daysimulator does not use polymorphisme
    public String daySimulator(int days) {
        while (days > 0) {
            for (Item item : items) {
                if (item instanceof QualityChangingItem) {
                    days--;
                    return ((QualityChangingItem) item).updateQuality();
                } else if (item instanceof QualityPreservingItem) {
                    days--;
                    return "A Legendary Item always maintains the same quality and " + item.name
                            + "'s quality is " + item.quality;
                }
                days--;
                return "This is a unindentified item so their behavious is unknown, research required";
            }
        }
        return "The simulation has ended";

    }