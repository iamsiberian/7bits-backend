package it.sevenbits.formatter.statemachine.formatter;

/**
 *
 * @author Minyukhin Ilya
 */
public interface ICreateCommand {
    /**
     *
     *
     * @param className
     * @return ICommand command
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    static ICommand createCommand(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (ICommand) Class.forName("it.sevenbits.formatter.statemachine.formatter.commands." + className).newInstance();
    }
}
