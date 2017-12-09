package it.sevenbits.formatter.newLexer;

/**
 * Interface for executing commands
 *
 * @author Minyukhin Ilya
 */
public interface ICommand {

    /**
     * The method passes a character to an instance of the IContext class
     *
     * @param c the character that was read
     * @param context an instance of a class that implements an IContext interface
     */
    void execute(char c, IContext context);
}
