package ch.jobtrek;

public class Basics {

    /**
     * This function gets two integers and must compute them as follows :
     * IF all numbers are even or number 1 superior to 10, return true
     * in all other cases, return false
     */
    public static boolean someConditionals(int number1, int number2) {
        if (number1 > 10) {
            return true;

        } else if ((number1 % 2) == 0 && (number2 % 2) == 0) {
            return true;

        } else
            return false;
    }

    /**
     * @param text A string containing words separated by spaces
     * @return A string containing only words of maximum 4 characters and starting
     * with letter T. All words should be uppercase and separated by spaces
     */
    public static String strings(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() <= 4 && word.startsWith("T")) {
                if (!result.isEmpty()) {
                    result.append(" ");
                }
                result.append(word.toUpperCase());
            }
        }
        return result.toString();
    }





    /**
     * @param needle The word you need to replace
     * @param haystack A string in which you need to replace the needle by the new word
     * @param newWord The replacement word
     * @return A new string where the needle is replaced by newWord
     */
    public static String findAndReplace(String needle, String haystack, String newWord) {
        return haystack.replace(needle, newWord);
    }
}
