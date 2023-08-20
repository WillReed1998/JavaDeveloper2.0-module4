package org.example;

public class StringChanger {

    public String convector(String line) {
        char[] chars = line.toCharArray();
        char[] transformedChars = new char[chars.length];
        int transformedCharsCount = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                if (i % 2 == 0) {
                    transformedChars[transformedCharsCount] = Character.toLowerCase(c);
                } else {
                    transformedChars[transformedCharsCount] = Character.toUpperCase(c);
                }
                transformedCharsCount++;
            }
        }

        char[] finalTransformedChars = new char[transformedCharsCount];
        System.arraycopy(transformedChars, 0, finalTransformedChars, 0, transformedCharsCount);
        return finalTransformedChars.toString();
    }
}

