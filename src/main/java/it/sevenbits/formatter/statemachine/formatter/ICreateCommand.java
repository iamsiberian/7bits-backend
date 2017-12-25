package it.sevenbits.formatter.statemachine.formatter;

/**
 * Interface for creating commands
 *
 * @author Minyukhin Ilya
 */
public interface ICreateCommand {

    /**
     * A static method that creates an instance of a class-command
     *
     * @param className name of a class-command
     * @return ICommand instance of a class-command
     * @throws ClassNotFoundException if an error occurred
     * @throws IllegalAccessException if an error occurred
     * @throws InstantiationException if an error occurred
     */
    static ICommand createCommand(final String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (ICommand) Class.forName("it.sevenbits.formatter.statemachine.formatter.commands." + className).newInstance();
    }
}
