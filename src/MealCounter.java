public class MealCounter {
    private int meal;                   // the meal stored on the counter
    private boolean hasMeal = false;    // true if the counter currently holds a meal

    // Called by the Chef (producer)
    public synchronized void placeMeal(int newMeal) throws InterruptedException {
        while (hasMeal) {
            System.out.println("Chef is waiting: counter is full.");
            wait();
        }
        meal = newMeal;
        hasMeal = true;
        System.out.println("Chef placed Meal #" + meal + " on the counter.");
        notify();   // wake the waiting student
    }

    // Called by the Student (consumer)
    public synchronized int collectMeal() throws InterruptedException {
        while (!hasMeal) {
            System.out.println("Student is waiting: counter is empty.");
            wait();
        }
        int collected = meal;
        hasMeal = false;
        System.out.println("Student collected Meal #" + collected + " from the counter.");
        notify();   // wake the waiting chef
        return collected;
    }
}