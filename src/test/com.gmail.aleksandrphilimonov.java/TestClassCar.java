import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassCar {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @EnabledOnJre(JRE.JAVA_11)
    @DisabledOnJre(JRE.JAVA_8)
    public void getCarYear() {
        Car car = new Car("Audi", "7898-RTY", 2012, "Aleksandr Philimonov");
        assertEquals(2012, car.getYear());
    }
}
