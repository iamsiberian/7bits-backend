package it.sevenbits.formatter.statemachine;

/**
 * Generic class
 *
 * @param <T> the first argument
 * @param <U> the second argument
 *
 * @author Minyukhin Ilya
 */
public class Pair<T, U> {
    private final T first;
    private final U second;

    /**
     * A basic constructor initializing the fields of an instance of the class
     *
     * @param first the first argument
     * @param second the second argument
     */
    public Pair(final T first, final U second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;

        return (first != null ? first.equals(pair.first) : pair.first == null) && (second != null ? second.equals(pair.second) : pair.second == null);
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
