package it.sevenbits.formatter.statemachine;

/**
 * Generic interface for writing parameters to the maps
 *
 * @param <T> the first argument
 * @param <U> the second argument
 *
 * @author Minyukhin Ilya
 */
public interface IPut<T, U> {

    /**
     * A method that places parameters in a map
     *
     * @param state state
     * @param t the first argument
     * @param u the second argument
     */
    void put (final State state, final T t, final U u);
}
