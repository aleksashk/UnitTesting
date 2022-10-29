import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DogTest {

    Dog newDog;

    @BeforeEach
    void createDog() {
        newDog = new Dog("Bob", 2);
    }

    @Test
    void testGetDogNameMethod() {
        assertNotEquals("Alex", newDog.getName());
    }

    @Test
    void setDogNameMethod() {
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