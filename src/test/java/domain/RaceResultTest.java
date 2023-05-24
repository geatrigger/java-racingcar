package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceResultTest {
    static final int DEFAULT_MOVE_VALUE = 2;
    static final int DEFAULT_NUMBER_OF_CARS_VALUE = 3;
    static final int INITIAL_CAR_POSITION = 1;

    CarState defaultCarState;
    CarDisplacement defaultCarDisplacement;
    Car defaultCar;
    RaceResult defaultRaceResult;

    @BeforeEach
    void setUp() {
        defaultCarState = CarState.create(INITIAL_CAR_POSITION);
        defaultCarDisplacement = DefaultCarDisplacement.create(DEFAULT_MOVE_VALUE);
        defaultCar = Car.createCar(defaultCarState, defaultCarDisplacement);

        defaultRaceResult = new RaceResult();
        defaultRaceResult.add(GameResult.createInitialGameResult(new NumberOfCars(DEFAULT_NUMBER_OF_CARS_VALUE), defaultCar));
    }

    @Test
    @DisplayName("GameResult들 가져오기 테스트")
    void getGames() {
        ArrayList<GameResult> gameResults = new ArrayList<>(Collections.singletonList(
            GameResult.create(new ArrayList<>(Arrays.asList(defaultCar, defaultCar, defaultCar)))
        ));
        assertEquals(new RaceResult(gameResults), defaultRaceResult);
    }

    @Test
    @DisplayName("GameResult 넣기 테스트")
    void add() {
        defaultRaceResult.add(GameResult.createInitialGameResult(new NumberOfCars(DEFAULT_NUMBER_OF_CARS_VALUE), defaultCar));

        ArrayList<GameResult> gameResults = new ArrayList<>(Arrays.asList(
            GameResult.create(new ArrayList<>(Arrays.asList(defaultCar, defaultCar, defaultCar))),
            GameResult.create(new ArrayList<>(Arrays.asList(defaultCar, defaultCar, defaultCar)))
        ));
        assertEquals(new RaceResult(gameResults), defaultRaceResult);
    }

    @Test
    @DisplayName("RaceResult equals 테스트")
    void testEquals() {
        RaceResult raceResult = new RaceResult();
        raceResult.add(GameResult.createInitialGameResult(new NumberOfCars(DEFAULT_NUMBER_OF_CARS_VALUE), defaultCar));

        assertEquals(raceResult, defaultRaceResult);
    }

    @Test
    @DisplayName("RaceResult toString 테스트")
    void testToString() {
        assertEquals("[[{position : 1}, {position : 1}, {position : 1}]]", defaultRaceResult.toString());
    }
}
