package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    static final int INITIAL_POSITION = 3;
    static final int DEFAULT_MOVE_VALUE = 2;

    Car defaultCar;
    CarState defaultCarState;
    CarDisplacement defaultCarDisplacement;

    @BeforeEach
    void setUp() {
        defaultCarState = CarState.create(INITIAL_POSITION);
        defaultCarDisplacement = DefaultCarDisplacement.create(DEFAULT_MOVE_VALUE);
        defaultCar = Car.createCar(defaultCarState, defaultCarDisplacement);
    }

    @Test
    @DisplayName("Car 생성이 되는지 확인")
    void createCar() {
        assertDoesNotThrow(() -> Car.createCar(defaultCarState, defaultCarDisplacement));
    }

    @Test
    @DisplayName("Car 움직임 테스트")
    void move() {
        defaultCar.move();
        assertEquals(INITIAL_POSITION + DEFAULT_MOVE_VALUE, defaultCar.getPosition());
    }

    @Test
    @DisplayName("Car 위치 테스트")
    void getLocation() {
        assertEquals(INITIAL_POSITION, defaultCar.getPosition());
    }

    @Test
    @DisplayName("객체의 주소가 다르지만 값이 같을 경우 equals 테스트")
    void testEquals() {
        assertEquals(Car.createCar(defaultCarState, defaultCarDisplacement), defaultCar);
    }

    @Test
    @DisplayName("toString 테스트")
    void testToString() {
        assertEquals("{position : 3}", defaultCar.toString());
    }
}
