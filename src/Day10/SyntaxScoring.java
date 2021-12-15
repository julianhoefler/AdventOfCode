package Day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SyntaxScoring {
    static StringBuilder corruptedSigns = new StringBuilder();


    public static long getSum() throws IOException {

        ArrayList<String> inputFile = new ArrayList<>(Files
                .readAllLines(Paths.get("src/Day10/input.txt")));

        for (String line : inputFile) {
            List<String> chunks = Arrays.stream(line.split("")).collect(Collectors.toList());
            Stack stack = new Stack();

            loop: for (String chunk : chunks) {

                switch (chunk) {
                    case "{" -> stack.push("}");
                    case "(" -> stack.push(")");
                    case "<" -> stack.push(">");
                    case "[" -> stack.push("]");
                    case "}" -> {
                        if (isLastClosingBracket("}", stack)) {
                            break loop;
                        }
                    }
                    case ")" -> {
                        if (isLastClosingBracket(")", stack)) {
                            break loop;
                        }
                    }
                    case ">" -> {
                        if (isLastClosingBracket(">", stack)) {
                            break loop;
                        }
                    }
                    case "]" -> {
                        if (isLastClosingBracket("]", stack)){
                            break loop;
                        }
                    }
                }
            }
        }

        long sumNormalBrackets = 3 * countSigns(')');
        long sumCornerBrackets = 57 * countSigns(']');
        long sumCurlyBrackets = 1197 * countSigns('}');
        long sumSpikeBrackets = 25137 * countSigns('>');

        return sumCurlyBrackets + sumCornerBrackets + sumNormalBrackets + sumSpikeBrackets;
    }

    private static boolean isLastClosingBracket(String chunk, Stack stack) {
        if (stack.peek() == chunk) {
            stack.pop();
            return false;
        } else {
            corruptedSigns.append(chunk);
            return true;
        }
    }

    private static long countSigns(char sign){
        return corruptedSigns.toString().chars().filter(ch -> ch == sign).count();
    }
}
