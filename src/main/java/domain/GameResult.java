package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private final List<Car> cars;

    private GameResult(List<Car> cars) {
        this.cars = cars;
    }

    public static GameResult createInitialGameResult(NumberOfCars numberOfCars, Car defaultCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars.getValue(); i++) {
            cars.add(Car.createCopy(defaultCar));
        }
        return new GameResult(cars);
    }

    public static GameResult createCopy(GameResult gameResult) {
        List<Car> cars = new ArrayList<>();
        for (Car car : gameResult.cars) {
            cars.add(Car.createCopy(car));
        }
        return new GameResult(cars);
    }

    public static GameResult create(List<Car> cars) {
        List<Car> newCars = new ArrayList<>();
        for (Car car : cars) {
            newCars.add(Car.createCopy(car));
        }
        return new GameResult(newCars);
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GameResult)) {
            return false;
        }
        return Objects.equals(this.cars, ((GameResult) obj).cars);
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
