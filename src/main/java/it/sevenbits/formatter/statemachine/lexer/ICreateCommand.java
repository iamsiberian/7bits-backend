package it.sevenbits.formatter.statemachine.lexer;

/**
 *
 *
 * @author Minyukhin Ilya
 */
public interface ICreateCommand {

    /**
     *
     *
     * @return ICommand
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    static ICommand createCommand(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (ICommand) Class.forName("it.sevenbits.formatter.statemachine.lexer.commands." + className).newInstance();
    }
}
