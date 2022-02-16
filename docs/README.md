# 문자열 덧셈 계산기

## 구현할 기능

- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환하는 기능
- [x] 문자열을 나누는 기능
- [x] 문자열을 숫자로 바꾸는 기능
- [x] 숫자를 모두 더하는 기능
- [x] 구분자를 커스텀 할 수 있다.
    - [x] 구분자는 "//(구분자)\n"로 설정한다.
- [x] 입력이 하나인 경우 그대로 반환하는 기능

## 예외 상황

- [x] 입력이 숫자가 아닌 경우 `RuntimeException`을 throw 한다.
- [x] 입력이 음수인 경우 `RuntimeException`을 throw 한다.

# 자동차 경주

## 구현할 기능

- [x] 자동차 이름을 설정하는 기능
- [x] 자동차 이름을 나누는 기능
- [x] 시도할 회수를 설정하는 기능
- [x] 자동차가 전진하는 기능
- [x] 실행 결과 반환하는 기능
- [x] 자동차를 시도할 회수만큼 경주하는 기능
- [x] 우승자를 판단하는 기능
- [x] UI 출력 기능

## 예외 상황

- [x] 자동차 이름이 잘못된 경우 `RuntimeException`을 throw 한다.
    - [x] 이름을 입력하지 않는 경우
    - [x] 입력한 이름 중 공백이 있는 경우
    - [x] 이름이 5자를 넘을 경우
    - [x] 중복된 이름을 입력한 경우

- [x] 시도할 회수가 잘못된 경우 `RuntimeException`을 throw 한다.
    - [x] 회수가 입력하지 않는 경우
    - [x] 회수가 숫자가 아닌 경우
    - [x] 회수가 음수인 경우

## 요구사항

- 코드 컨벤션을 지킨다.
    - https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
- 한 메서드에 오직 한 단계의 들여쓰기만 한다.
- else 를 쓰지 않는다.
- 함수의 길이는 15라인을 넘어가지 않도록 구현한다.
- 핵심 비지니스 로직을 가지는 객체는 domain, UI 관련 객체는 view 패키지에 구현한다.
- view 패키지의 객체가 domain 패키지의 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지의 객체에 의존하지 않도록 구현한다.
- 테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.

---

## 피드백 수정 기록 및 궁금한 점

- [x] google java style 메소드 명은 동사로 시작해야 한다.(5.2.3)
    - valid -> validate
    - judge -> find
    - toString(), of() 처럼 전치사로 시작하는 경우는 예외인가?
    - google Java 컨벤션 -> 메소드 명은 동사, 동사구로 시작한다.
    - oracle Java 컨벤션 -> 메소드 명은 동사로 시작한다.
    - 네이버 Java 컨벤션 -> 메소드 명은 동사/전치사로 시작한다.

- [x] 파라미터가 없는 메소드에서 `IllegalArgumentException`이 사용되는 것이 적절한가?
    - RandomUtil.generateRandomNumber()에는 파라미터가 없지만 그 내부에서 `IllegalArgumentException`이 사용됨.
    - `IllegalStateException`를 사용하여 예외를 처리하도록 수정
    - `IllegalStateException`는 메소드 처리를 하려할 때 잘못된 상태가 된 경우 발생하는 예외이다.

- [x] Cars를 생성하는 책임을 Cars에게 줄 수 있다면?
    - RacingCar
    - RacingCar는 입력된 자동차 이름을 String 배열로 만들어서 Cars에게 주고 Cars가 자동차 객체들을 생성하여 List로 만들게 함.
    - Cars를 RacingCar가 아닌 Cars가 생성하도록 하여 Cars에 대한 책임은 Cars에 모아두도록 수정함.

- [x] 출력 형식이 바뀌어야 한다면 View와 Cars중 어느곳이 수정되어야 하는가?
    - Cars.repeatRaceBy()
    - 출력 형식이나 결과가 바뀐다면 View가 수정되어야 할 것이다.
    - Cars는 결과를 반환하고 View에서 결과를 이용하여 출력 값을 만드는 방법으로 수정했다.
    - Cars는 매 라운드 별 자동차들의 이름과 이동 거리를 vo(RoundResult)로 만들어 반환한다.
    - View는 RoundResult에서 반환된 결과값으로 출력을 함.

- [x] VO가 View의 세부사항을 알고 있는것이 바람직한가?
    - Position
    - 출력과 관련된 부분은 VO가 아닌 View가 처리하도록 수정
    - 실행 결과의 형식이 달라지면 VO가 아닌 OutputView를 수정하게 됨.

- [x] 메소드 명이 적절한가?
    - Cars.isSize()
    - isXXX는 객체가 XXX인지 확인한다는 의미로 단순하게 크기만을 비교하고 싶다면 matchSize등이 더 적합할 것 같음.

- [x] 이 메서드는 테스트에서만 사용되는데 이 메서드를 꼭 사용해서 테스트해야할까?
    - Cars
    - 테스트만을 위한 메소드를 만드는 방법도 있다고 들었지만 이상황에서는 잘 안맞는 것 같음.
    - isSize() 또는 matchSize() 등의 메소드는 테스트가 아닌 상황에서 사용이 될 수도 있을 것 같았기 때문이다.
    - toString()와 assertThat().contains()를 이용하여 테스트를 할 수 있을 것 같다.

- [x] Winners가 CarName을 가지는 것과 Car를 가지는 것 중 어느것이 더 좋을까?
    - Winners
    - Winners는 Cars에서 우승자(Car)를 찾는 것이기 때문에 Car를 가지고 있는것이 더 자연스러운것 같다.
    - 이후 이름을 얻기위해 getName()으로 CarName을 얻고 CarName.get()으로 String형 이름을 얻는다.

- [x] checkedException/uncheckedException의 차이에 대해 고민해보기
    - Calculator.toInteger()
    - Integer.parseInt()는 잘못된 값을 파라미터로 보낼 경우 알아서 `NumberFormatException`을 throw한다.
    - `NumberFormatException`도 `RuntimeException`의 한 종류이다.
    - 따라서 try/catch문을 쓰지 않아도 되지만 내가 원하는 에러를 발생시키고 싶다면 예외를 catch하여 원하는 에러 메시지를 추가하여 다시 throw를 해야하지 않을까?

- [x] move의 테스트를 generateRandomNumber() 때문에 하지 못하고 있는데 해결방법은 없는가?
    - Car
    - https://tecoble.techcourse.co.kr/post/2020-05-17-appropriate_method_for_test_by_interface
    - 문제점
        - move() 내에서 랜덤값을 만드는 메소드를 호출하면 테스트하기 어렵다.
    - 해결 방법
        - move(int randomNumber)와 같이 파라미터로 랜덤값을 주면 move() 메소드를 테스트하기 쉽다.
        - move()메소드를 테스트 할 때 파라미터 값으로 이동이 가능한 값을 주면 이동이 성공하고, 이동이 불가능 한 값을 주면 이동이 실패한다.
        - 전략 패턴을 사용한 인터페이스 분리를 하면 테스트하기 더 쉽고 코드의 응집도가 더 높아진다고 한다.
        - [ ] 전략 패턴과 인터페이스 분리가 완전히 이해되면 체크

- [x] 테스트의 메소드 명을 모두 영어로 수정한다.
    - @DisplayName()을 이용하여 메소드명 + 설명 형식으로 한국어로 설명했다.

- [x] 테스트에서 중복되는 것들을 Parameterized Test를 이용하여 리팩토링할 수 있지 않을까?
    - @ParameterizedTest(name = "{index} : {0}")
        - name으로 @DisplayName처럼 사용할 수 있다.
        - {index} : 반복 테스트 인덱스
        - {0} : 첫번째 파라미터 값
    - @ValueSource(strings = {"a", "b"})
    - @NullSource
    - @EmptySource
    - @NullAndEmptySource
    - @EnumSource(value = MyEnums.class, names = {"NAME1", "NAME2"})
    - @MethodSource
    - https://www.baeldung.com/parameterized-tests-junit-5

### step2 MVC 패턴으로 리팩터링 해보기

- [x] Winners에서 처리하던 출력 세부사항을 OutputView로 이동
- [x] DTO를 이용하여 데이터를 이동
    - [x] View -> Controller : RequestXXXDto
    - [x] View <- Controller : ResponseXXXDto
- 자동차 이름 입력을 나누는 RacingCar.splitCarNames를 InputView에서 하도록 수정(View에서 Cars까지 만들어서 Controller에게 반환)
- 전체 통합 테스트가 제대로 되지 않음
    - 문제점 : 첫번째 입력인 이름은 입력을 잘 받지만 두번째 입력인 시도 횟수를 제대로 입력받지 못함(null 입력이 됨)
    - 원인 분석 : InputView에서 Scanner를 상수로 처리했는데 이렇게 되면 문제가 발생하는것으로 예상됨
    - 해결 방법 : Controller에서 Scanner를 만들어 파라미터로 주거나 InputView에서 Scanner를 static으로 쓰지 않으면 문제가 해결됨
    - 나는 static을 없애고 InputView의 인스턴스 변수로 Scanner를 만들어 사용하는 방식으로 문제를 해결함
    - Scanner를 Controller에서 만들어서 주지 않은 이유는 InputView에서만 사용되는 Scanner를 꼭 Controller에서 생성하고 가지고 있어야하나? 라는 생각이 들었기 때문임
- RacingCar의 로직을 main으로 이동(Controller의 역할을 RacingCar가 아닌 main이 하도록 수정함)
- ApplicationTest.empty_input_exception_test에서 가장 마지막에 공백이 오는 경우(`a,b,`) 예외 처리하지 않는 오류 수정
