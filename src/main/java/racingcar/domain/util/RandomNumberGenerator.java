package racingcar.domain.util;

import java.util.Random;
import racingcar.domain.enums.DomainErrorMessage;

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

    private static void validateRange(int number) {
        if (number > MAXIMUM || number < MINIMUM) {
            throw new IllegalStateException(DomainErrorMessage.RANDOM_NUMBER_RANGE_OVER_ERROR_MESSAGE.get());
        }
    }
}
