# Meal Counter Thread Simulation

A Java multithreading simulation of the **producer-consumer problem**.

A **Chef** prepares meals and places them on a single-slot counter. A **Student** collects and eats them. The counter holds only one meal at a time:

- If the counter is full, the Chef waits.
- If the counter is empty, the Student waits.

## Files

| File | Description |
|------|-------------|
| `MealCounter.java` | Shared counter with `synchronized` place/collect methods using `wait()` and `notify()` |
| `Chef.java` | Producer thread, makes 5 meals |
| `Student.java` | Consumer thread, eats 5 meals |
| `Main.java` | Starts both threads and waits for them with `join()` |

## Run

```bash
cd src
javac *.java
java Main
```

## Sample Output

```
Chef started preparing Meal #1...
Student is waiting: counter is empty.
Chef placed Meal #1 on the counter.
Student collected Meal #1 from the counter.
Student is eating Meal #1...
...
Chef has finished preparing all 5 meals.
Student has finished eating all 5 meals.
```
