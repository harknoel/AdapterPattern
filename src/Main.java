/**
 *  +---------+      +------------+      +--------------+
 *  |  Sparrow|----->|    Bird    |      |   ToyDuck    |
 *  +---------+      +------------+      +--------------+
 *                   |            |      |              |
 *                   +------------+      +--------------+
 *                           ^                       ^
 *                           |                       |
 *                           |                       |
 *                  +--------------+                 |
 *                  | BirdAdapter  |                 |
 *                  +--------------+                 |
 *                  |              |                 |
 *                  +--------------+                 |
 *                  |              |------------------+
 *                  +--------------+
 */
// Client Interface
interface Bird {
    // birds implement Bird interface that allows
    // them to fly and make sounds adaptee interface
    void fly();
    void makeSound();
}

// Client ----------------------------------------
class Sparrow implements Bird {
    // a concrete implementation of bird
    public void fly() {
        System.out.println("Flying");
    }

    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}

// Service ---------------------------------------
interface ToyDuck {
    // target interface
    // toyducks don't fly they just make
    // squeaking sound
    void squeak();
}

class PlasticToyDuck implements ToyDuck {
    public void squeak() {
        System.out.println("Squeak");
    }
}

// ADAPTER ------------------------------------------
class BirdAdapter implements ToyDuck {
    // You need to implement the interface your
    // client expects to use.
    Bird bird;
    public BirdAdapter(Bird bird) {
        // we need reference to the object we
        // are adapting
        this.bird = bird;
    }

    public void squeak() {
        // translate the methods appropriately
        bird.makeSound();
    }
}

class Main {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        // Wrap a bird in a birdAdapter so that it
        // behaves like toy duck
        ToyDuck birdAdapter = new BirdAdapter(sparrow);

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println();

        System.out.println("ToyDuck...");
        toyDuck.squeak();

        System.out.println();

        // toy duck behaving like a bird
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();
    }
}