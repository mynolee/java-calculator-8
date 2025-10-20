# java-calculator-precourse
-----

# 문자열 계산기

-----

## 개요

문자열을 입력받아 구분자(, 또는 : 또는 사용자가 정의한 커스텀 구분자)를 기준으로 숫자를 분리하고, 그 합계를 계산하는 프로그램입니다.
잘못된 입력(음수 또는 숫자가 아닌 값)이 들어올 경우 IllegalArgumentException을 발생시키며, 프로그램은 종료됩니다.
System.exit()은 사용하지 않습니다.

-----

## 실행 흐름

1. 콘솔에서 문자열 입력 (Console.readLine())
2. 입력값 검증 (빈 입력 시 0 반환)
3. 구분자 판별 (기본 , : 또는 커스텀 //<delimiter>\n)
4. 숫자 부분 추출
5. 숫자 유효성 검증 및 합계 계산
6. 결과 출력

-----

## 함수별 기능 정리

main()
- 콘솔 입력을 받아 계산을 수행하고 결과를 출력한다.

calculateSum(String input)
- 전체 계산 흐름을 제어하고 입력값을 처리하여 합계를 반환한다.

isNullOrEmpty(String input)
- 입력값이 null이거나 공백인지 검사한다.

resolveDelimiter(String input)
- 입력으로부터 사용할 구분자를 판별하여 반환한다.

hasCustomDelimiter(String input)
- 입력이 커스텀 구분자 형식(//)인지 확인한다.

parseCustomDelimiter(String input)
- 입력에서 커스텀 구분자 문자열을 추출한다.

findDelimiterEndIndex(String input)
- 커스텀 구분자 선언의 끝(\n) 위치를 찾는다.

extractNumberSection(String input)
- 커스텀 구분자 선언부를 제외한 숫자 부분을 추출한다.

removeDelimiterDeclaration(String input)
- 입력에서 구분자 선언부를 제거한다.

computeSum(String numbers, String delimiterRegex)
- 문자열을 구분자로 분리해 숫자 합계를 계산한다.

splitNumbers(String numbers, String delimiterRegex)
- 숫자 문자열을 구분자 기준으로 분리한다.

isEmpty(String text)
- 문자열이 비었거나 공백만 있는지 확인한다.

validatePositiveNumber(String numberText)
- 문자열이 숫자인지 확인하고 음수 여부를 검증한다.

parseToInt(String numberText)
- 문자열을 정수형으로 변환한다. 

