package nl.blitz.exercisename;

class ExerciseName {
    Item[] items;

    public ExerciseName(Item[] items) {
        this.items = items;
    }

    public String DaySimulator(int days) {
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
}
