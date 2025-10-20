package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    private static final String DEFAULT_DELIMITERS_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEWLINE_TOKEN = "\\n";
    private static final int INDEX_NOT_FOUND = -1;

    public static void main(String[] args) {
        System.out.print("입력하세요: ");
        String input = Console.readLine();

        int sum = calculateSum(input);
        System.out.println("결과 : " + sum);
    }

    public static int calculateSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String delimiterRegex = resolveDelimiter(input);
        String numberSection = extractNumberSection(input);
        return computeSum(numberSection, delimiterRegex);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static String resolveDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            return parseCustomDelimiter(input);
        }
        return DEFAULT_DELIMITERS_REGEX;
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private static String parseCustomDelimiter(String input) {
        int delimiterEndIndex = findDelimiterEndIndex(input);
        String rawDelimiter = input.substring(
                CUSTOM_DELIMITER_PREFIX.length(),
                delimiterEndIndex
        );
        return Pattern.quote(rawDelimiter);
    }

    private static int findDelimiterEndIndex(String input) {
        int index = input.indexOf(NEWLINE_TOKEN);
        if (index == INDEX_NOT_FOUND) {
            throw new IllegalArgumentException("입력에서 " + NEWLINE_TOKEN + "을 찾을 수 없습니다.");
        }
        return index;
    }

    private static String extractNumberSection(String input) {
        if (hasCustomDelimiter(input)) {
            return removeDelimiterDeclaration(input);
        }
        return input;
    }

    private static String removeDelimiterDeclaration(String input) {
        int delimiterEndIndex = findDelimiterEndIndex(input);
        return input.substring(delimiterEndIndex + NEWLINE_TOKEN.length());
    }

    private static int computeSum(String numbers, String delimiterRegex) {
        String[] numberTexts = splitNumbers(numbers, delimiterRegex);
        int sum = 0;

        for (String numberText : numberTexts) {
            if (isEmpty(numberText)) {
                continue;
            }
            String trimmedNumber = numberText.trim();
            validatePositiveNumber(trimmedNumber);
            sum += parseToInt(trimmedNumber);
        }

        return sum;
    }

    private static String[] splitNumbers(String numbers, String delimiterRegex) {
        return numbers.split(delimiterRegex);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    private static void validatePositiveNumber(String numberText) {
        if (!numberText.matches("^-?\\d+$")) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + numberText);
        }

        int number = Integer.parseInt(numberText);

        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + numberText);
        }
    }

    private static int parseToInt(String numberText) {
        return Integer.parseInt(numberText);
    }
}