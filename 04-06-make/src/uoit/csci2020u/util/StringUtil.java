package uoit.csci2020u.util;

/**
 * This is an utility class containing useful methods
 * for 
 * <ul>
 *  <li>manipulating and </li>
 *  <li>testing conditions of strings.</li>
 * </ul>
 *
 * We also <b>plan</b> to include more methods in the
 * next few weeks.
 *
 * @author <b>everybody</b> in CSCI 2020U
 */
public class StringUtil {
    /**
     * Reverses the input string and builds a brand new string
     *
     * @param x     The input string to be reversed
     * @return      The brand new string
     */
    public static String reverse(String x) {
        StringBuilder y = new StringBuilder();
        for(int i=0; i < x.length(); i++) {
            int j = x.length() - i - 1;
            y.append(x.charAt(j));
        }
        return y.toString();
    }
}
