package racingcar;

import java.util.Scanner;

public class RacingCar {

  public static String readCarNames() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public static String[] splitCarNames(String carNames) {
    return carNames.split(",");
  }
}