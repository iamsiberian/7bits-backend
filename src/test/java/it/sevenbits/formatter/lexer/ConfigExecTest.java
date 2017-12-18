package it.sevenbits.formatter.lexer;
import it.sevenbits.formatter.statemachine.State;
import it.sevenbits.formatter.statemachine.lexer.CommandRepository;
import it.sevenbits.formatter.statemachine.lexer.ConfigExec;
import it.sevenbits.formatter.statemachine.lexer.ICommand;
import it.sevenbits.formatter.statemachine.lexer.StateTransitions;
import it.sevenbits.formatter.statemachine.lexer.commands.Char;
import it.sevenbits.formatter.statemachine.lexer.commands.Space;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class ConfigExecTest {

    @Test
    public void testReadConfig() {
        ConfigExec exec = new ConfigExec();
        assertNotNull(exec);
    }

    @Test
    public void testDefault() {
        State initState = new State("default");
        char initChar = 'a';
        ConfigExec exec = new ConfigExec();
        CommandRepository commands = exec.getRepository();
        StateTransitions transitions = exec.getTransitions();

        ICommand trueCommand = new Char();
        ICommand command = commands.getCommand(initState, initChar);
        assertEquals(trueCommand.getClass().getName(), command.getClass().getName());

        State trueState = new State("default");
        State state = transitions.nextState(initState, initChar);
        assertEquals(trueState, state);
    }

    @Test
    public void testCfg() {
        ConfigExec exec = new ConfigExec();
        CommandRepository commands = exec.getRepository();
        StateTransitions transitions = exec.getTransitions();

        State initState = new State("default");
        char initChar = ' ';

        ICommand trueCommand = new Space();
        ICommand command = commands.getCommand(initState, initChar);
        assertEquals(trueCommand.getClass().getName(), command.getClass().getName());

        State trueState = new State("spacing");
        State state = transitions.nextState(initState, initChar);
        assertEquals(trueState, state);
    }


}

