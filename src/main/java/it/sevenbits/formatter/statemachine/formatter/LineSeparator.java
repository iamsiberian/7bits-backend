package it.sevenbits.formatter.statemachine.formatter;

/**
 * Static class, specifies the line separator depending on the type oc
 *
 * @author Minyukhin Ilya
 */
public class LineSeparator {
    private static String lineSeparator;

    static {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            lineSeparator = "\r\n";
        } else {
            lineSeparator = "\n";
        }
    }

    /**
     * The basic constructor
     */
    protected LineSeparator() {
    }


    /**
     * The method returns line separator
     *
     * @return String line separator
     */
    public static String get() {
        return lineSeparator;
    }
}
