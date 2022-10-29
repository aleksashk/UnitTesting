import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testSetNumberMultipleValues(String number) {
        car.setNumber(number);
        assertEquals(number, car.getNumber());
    }

    @ParameterizedTest
    @CsvSource({"'ASDFASD-12', 'ASDFASD-12'", "'243523-SDFA', '243523-SDFA'"})
    void testSetNumberMultipleValues(String number, String x) {
        car.setNumber(number);
        assertEquals(x, car.getNumber());
    }

    @ParameterizedTest
    @CsvSource({"'1', '5'", "'67', '71'", "'32', '36'"})
    void testInt(int input, int output) {
        assertEquals(car.testInt(input), output);
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

    @Test
    public void testCarInfoPrinter() {
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);

            System.setOut(capture);

            Car newCar = new Car("Audi", "789878-CDF", 1999, "Aleksandr Philimonov");
            newCar.carInfoPrinter();

            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Audi\r\n", consoleOutput);
    }
}