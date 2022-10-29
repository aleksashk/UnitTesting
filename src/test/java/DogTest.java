import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DogTest {

    @Test
    void testGetDogNameMethod() {
        Dog newDog = new Dog("Bob", 2);
        assertNotEquals("Alex", newDog.getName());
    }

    @Test
    void setName() {
    }

    @Test
    void getAge() {
    }

    @Test
    void setAge() {
    }
}