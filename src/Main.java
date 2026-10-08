public class Main {
    public static void main(String[] args) {
        MealCounter counter = new MealCounter();

        Chef chef = new Chef(counter);
        Student student = new Student(counter);

        System.out.println("=== Cafeteria meal counter simulation started ===");
        chef.start();
        student.start();

        try {
            chef.join();
            student.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("=== Simulation complete: all meals prepared and consumed ===");
    }
}