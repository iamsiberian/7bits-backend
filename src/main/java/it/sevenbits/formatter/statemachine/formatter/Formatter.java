package it.sevenbits.formatter.statemachine.formatter;

import it.sevenbits.formatter.statemachine.State;
import it.sevenbits.formatter.io.ReaderException;
import it.sevenbits.formatter.io.IWriter;
import it.sevenbits.formatter.statemachine.lexer.ILexer;
import it.sevenbits.formatter.statemachine.token.IToken;

/**
 * Class with a single method for formatting text
 *
 * @author Minyukhin Ilya
 */
public class Formatter implements IFormatter {
    private ICommandRepository commands;
    private IStateTransitions transitions;

    /**
     * The basic constructor that initializes the instance of a class
     */
    public Formatter() {
        commands = new CommandRepository();
        transitions = new StateTransitions();
    }

    @Override
    public void format(final ILexer lexer, final IWriter writer) throws ReaderException, ContextException {
        IContext context = new Context(writer);
        State state = new State("start");
        while (lexer.hasNextToken() && state != null) {
            IToken token = lexer.readToken();
            ICommand command = commands.getCommand(state, token);
            command.execute(token, context);
            state = transitions.getNextState(state, token);
        }
    }
}
