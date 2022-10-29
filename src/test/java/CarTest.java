import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    public void createCar() {
        car = new Car("Skoda", "ABC123", 2019, "Aleksandr Philimonov");
    }

    @Test
    void getManufacturer() {
        assertEquals("Skoda", car.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("ABC123", car.getNumber());
    }

    @Test
    void setNumber() {
        car.setNumber("ABCD-1234");
        assertEquals("ABCD-1234", car.getNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ASDFG-1003", "REQWE-4889", "", "-"})
    @NullSource
    @EmptySource
    void testSetNumberMultipleValues(String number){
        car.setNumber(number);
        assertEquals(number, car.getNumber());
    }

    @Test
    void getYear() {
        assertEquals(2019, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Aleksandr Philimonov", car.getOwner());
    }

    @Test
    void setOwner() {
        car.setOwner("Dmitry Pavlov");
        assertEquals("Dmitry Pavlov", car.getOwner());
    }

    @Test
    void getListOfOwners() {
        assertArrayEquals(new String[]{"Aleksandr Philimonov"}, car.getOwners().toArray());

    }

    @Test
    void getListOfTwoOwners() {
        car.setOwner("Dmitry Pavlov");
        assertArrayEquals(new String[]{"Aleksandr Philimonov", "Dmitry Pavlov"}, car.getOwners().toArray());
    }

    @Test
    public void testPrivateMethod() {

        try {
            Method method = Car.class.getDeclaredMethod("testMethod", null);

            method.setAccessible(true);
            assertEquals(method.invoke(car).toString(), "abc");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testPrivateMethodWithParameter() {

        try {
            Method method = Car.class.getDeclaredMethod("testMethod", String.class);

            method.setAccessible(true);
            assertEquals(method.invoke(car, "asdf").toString(), "asdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}