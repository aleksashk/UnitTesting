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
    void setDogNameMethod() {
        Dog newDog = new Dog("Bob", 2);
        newDog.setName("Albert");
        assertEquals("Bob", newDog.getName());
    }

    @Test
    void setDogNameMethodIfEmpty() {
        Dog newDog = new Dog("", 2);
        newDog.setName("Albert");
        assertEquals("Albert", newDog.getName());
    }

    @Test
    void getAge() {
    }

    @Test
    void setAge() {
    }
}