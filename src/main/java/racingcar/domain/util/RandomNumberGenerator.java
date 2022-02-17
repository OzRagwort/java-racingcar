package racingcar.domain.util;

import java.util.Random;
import racingcar.domain.enums.ErrorMessage;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int EXCLUSIVE_BOUND_CORRECTION_VALUE = 1;
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 9;

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
            throw new IllegalStateException(ErrorMessage.RANDOM_NUMBER_RANGE_OVER_ERROR_MESSAGE.get());
        }
    }
}
