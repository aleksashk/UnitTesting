import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DogTest {

    static Dog dog;

    Dog newDog;

    @BeforeAll
    static void prepareData(){
        dog = new Dog("Bob", 2);
    }

    @BeforeEach
    void createDog() {
        newDog = new Dog("Bob", 2);
    }

    @Test
    void testGetDogNameMethod() {
        assertNotEquals("Alex", dog.getName());
    }

    @Test
    void setDogNameMethod() {
        newDog.setName("Albert");
        assertEquals("Bob", dog.getName());
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