package com.nefodov.TextAlignJustify;

public class Kata {
    public static String justify(String text, int width) {

        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            int wordCount = 0;
            int totalLength = 0;
            if (width == words[i].length()) {
                sb.append(words[i]);
                if (i < words.length - 1) {
                    sb.append("\n");
                }
                i++;
                continue;
            }

            while (i < words.length && totalLength + words[i].length() < width) {
                totalLength += words[i].length();
                i++;
                wordCount++;
            }

            int minSpaces = wordCount - 1;
            int symbolsLeft = width - totalLength;

            while (symbolsLeft < minSpaces) {
                i--;
                wordCount--;
                minSpaces--;
                totalLength -= words[i].length();
                symbolsLeft = width - totalLength;
            }

            if (wordCount > 1) {
                if (i < words.length) {
                    int spaces = (width - totalLength) / (wordCount - 1);
                    symbolsLeft = (width - totalLength) % (wordCount - 1);
                    for (int j = i - wordCount; j < i - 1; j++) {
                        sb.append(words[j]);
                        for (int k = 0; k < spaces; k++) {
                            sb.append(' ');
                        }
                        if (symbolsLeft > 0) {
                            sb.append(' ');
                            symbolsLeft--;
                        }
                    }

                    sb.append(words[i - 1]);
                    sb.append("\n");
                } else {
                    for (int j = i - wordCount; j < i - 1; j++) {
                        sb.append(words[j]).append(' ');
                    }
                    sb.append(words[i - 1]);
                }


            } else {
                sb.append(words[i - 1]);
                if (i < words.length - 1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
        return sb.toString();
    }
}