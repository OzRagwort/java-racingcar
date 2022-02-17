package racingcar.domain.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int EXCLUSIVE_BOUND_CORRECTION_VALUE = 1;
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 9;
    private static final String RANGE_OVER_ERROR_MESSAGE = "최소, 최대 범위의 입력을 확인해 주세요";

    private static final Random RANDOM = new Random();

    @Override
    public int generate() {
        int randomNumber =
                RANDOM.nextInt(MAXIMUM - MINIMUM + EXCLUSIVE_BOUND_CORRECTION_VALUE) + MINIMUM;
        validateRange(randomNumber);
        return randomNumber;
    }

    private static void validateRange(int randomNumber) {
        if (randomNumber > MAXIMUM || randomNumber < MINIMUM) {
            throw new IllegalStateException(RANGE_OVER_ERROR_MESSAGE);
        }
    }
}