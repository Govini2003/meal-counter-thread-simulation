public class Student extends Thread {
    private final MealCounter counter;
    private static final int TOTAL_MEALS = 5;

    public Student(MealCounter counter) {
        super("Student");
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= TOTAL_MEALS; i++) {
                int meal = counter.collectMeal();
                System.out.println("Student is eating Meal #" + meal + "...");
                Thread.sleep(1500);              // time taken to consume a meal
            }
            System.out.println("Student has finished eating all " + TOTAL_MEALS + " meals.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Student was interrupted.");
        }
    }
}