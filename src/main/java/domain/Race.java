package domain;

import dto.RaceInfo;

import java.util.Random;

public class Race {
    private static final int RANDOM_RANGE = 10;
    private static final int RANDOM_DIVIDING_POINT = 4;

    private final CarNumber carNumber;
    private final RaceNumber raceNumber;

    public Race(RaceInfo raceInfo) {
        this.carNumber = raceInfo.getCarNumber();
        this.raceNumber = raceInfo.getRaceNumber();
    }

    public RaceResult calculate() {
        RaceResult raceResult = new RaceResult();
        GameResult gameResult = GameResult.createInitialGameResult(carNumber);

        raceResult.add(gameResult);
        for (int i = 0; i < raceNumber.getRaceNumber(); i++) {
            GameResult nextGameResult = calculateNextGameResult(gameResult);
            raceResult.add(nextGameResult);
            gameResult = nextGameResult;
        }

        return raceResult;
    }

    private GameResult calculateNextGameResult(GameResult gameResult) {
        GameResult nextGameResult = GameResult.createCopy(gameResult);
        for (int j = 0; j < carNumber.getCarNumber(); j++) {
            nextGameResult.getCar(j).move(calculateMove() ? Position.ONE.getPosition() : Position.ZERO.getPosition());
        }

        return nextGameResult;
    }

    private boolean calculateMove() {
        Random ran = new Random();
        return ran.nextInt(RANDOM_RANGE) >= RANDOM_DIVIDING_POINT;
    }
}
