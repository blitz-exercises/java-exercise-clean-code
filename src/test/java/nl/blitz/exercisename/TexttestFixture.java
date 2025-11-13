package nl.blitz.exercisename;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("ExerciseName Test Fixture");

        // TODO: Replace with your exercise-specific test data
        Item[] items = new Item[] {
                new Item("Item 1", 10, 20),
                new Item("Item 2", 2, 0),
                new Item("Item 3", 5, 7)
        };

        ExerciseName app = new ExerciseName(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            // TODO: Call your exercise-specific update method here
            // app.updateQuality();
        }
    }
}
