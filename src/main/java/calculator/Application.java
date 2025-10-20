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
}