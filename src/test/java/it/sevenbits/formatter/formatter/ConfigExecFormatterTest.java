package it.sevenbits.formatter.formatter;

import it.sevenbits.formatter.statemachine.State;
import it.sevenbits.formatter.statemachine.formatter.CommandRepository;
import it.sevenbits.formatter.statemachine.formatter.ConfigExecFormatter;

import it.sevenbits.formatter.statemachine.formatter.ICommand;
import it.sevenbits.formatter.statemachine.formatter.StateTransitions;
import it.sevenbits.formatter.statemachine.formatter.commands.WriteFirstSymbol;
import it.sevenbits.formatter.statemachine.formatter.commands.WriteLexeme;
import it.sevenbits.formatter.statemachine.token.IToken;
import it.sevenbits.formatter.statemachine.token.Token;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConfigExecFormatterTest {
    @Test
    public void testReadConfig() {
        ConfigExecFormatter exec = new ConfigExecFormatter();
        assertNotNull(exec);
    }

    @Test
    public void testDefault() {
        State initState = new State("start");
        IToken token = new Token("char", "a");
        ConfigExecFormatter exec = new ConfigExecFormatter();
        CommandRepository commands = exec.getRepository();
        StateTransitions transitions = exec.getTransitions();

        ICommand trueCommand = new WriteFirstSymbol();
        ICommand command = commands.getCommand(initState, token);
        assertEquals(trueCommand.getClass().getName(), command.getClass().getName());

        State trueState = new State("default");
        State state = transitions.getNextState(initState, token);

        assertEquals(trueState, state);
    }
}
