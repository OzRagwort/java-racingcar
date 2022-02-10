package racingcar.vo;

import static racingcar.util.RandomUtil.createNumber;
import static racingcar.util.MovementUtil.isMoveForward;

public class Car implements Comparable<Car> {

  private CarName name;
  private Position position;

  public Car(CarName carName) {
    this.name = carName;
    this.position = new Position();
  }

  public boolean isSameName(Car car) {
    return car.name.equals(this.name);
  }

  public boolean isSamePosition(Car car) {
    return position.compareTo(car.position) == 0;
  }

  public boolean move() {
    if (isMoveForward(createNumber())) {
      position.increase();
      return true;
    }
    return false;
  }

  @Override
  public int compareTo(Car o) {
    return position.compareTo(o.position);
  }

  @Override
  public String toString() {
    return name.get() + " : " + position.toString();
  }
}
