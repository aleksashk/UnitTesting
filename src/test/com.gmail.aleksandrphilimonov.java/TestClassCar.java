import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassCar {

    @Test
    public void getCarManufacturer() {
        Car car = new Car("Audi", "7898-RTY", 2012, "Aleksandr Philimonov");
        assertEquals("Audi", car.getManufacturer());
    }

    @Test
    public void getCarNumber() {
        Car car = new Car("Audi", "7898-RTY", 2012, "Aleksandr Philimonov");
        assertEquals("7898-RTY", car.getNumber());
    }

    @Test
    public void getCarYear() {
        Car car = new Car("Audi", "7898-RTY", 2012, "Aleksandr Philimonov");
        assertEquals(2012, car.getYear());
    }

    @Test
    public void getCarOwner() {
        Car car = new Car("Audi", "7898-RTY", 2012, "Aleksandr Philimonov");
        assertEquals("Aleksandr Philimonov", car.getOwner());
    }
}
