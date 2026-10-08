public class Chef extends Thread {
    private final MealCounter counter;
    private static final int TOTAL_MEALS = 5;

    public Chef(MealCounter counter) {
        super("Chef");
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= TOTAL_MEALS; i++) {
                System.out.println("Chef started preparing Meal #" + i + "...");
                Thread.sleep(1000);              // time taken to prepare a meal
                counter.placeMeal(i);
            }
            System.out.println("Chef has finished preparing all " + TOTAL_MEALS + " meals.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Chef was interrupted.");
        }
    }
}