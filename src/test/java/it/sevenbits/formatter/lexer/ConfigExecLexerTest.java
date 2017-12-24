package it.sevenbits.formatter.lexer;
import it.sevenbits.formatter.statemachine.State;
import it.sevenbits.formatter.statemachine.lexer.CommandRepository;
import it.sevenbits.formatter.statemachine.lexer.ConfigExecLexer;
import it.sevenbits.formatter.statemachine.lexer.ICommand;
import it.sevenbits.formatter.statemachine.lexer.StateTransitions;
import it.sevenbits.formatter.statemachine.lexer.commands.Char;
import it.sevenbits.formatter.statemachine.lexer.commands.Space;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConfigExecLexerTest {

    @Test
    public void testReadConfig() {
        ConfigExecLexer exec = new ConfigExecLexer();
        assertNotNull(exec);
    }

    @Test
    public void testDefault() {
        State initState = new State("default");
        char initChar = 'a';
        ConfigExecLexer exec = new ConfigExecLexer();
        CommandRepository commands = exec.getRepository();
        StateTransitions transitions = exec.getTransitions();

        ICommand trueCommand = new Char();
        ICommand command = commands.getCommand(initState, initChar);
        assertEquals(trueCommand.getClass().getName(), command.getClass().getName());

        State trueState = null;
        State state = transitions.nextState(initState, initChar);

        assertEquals(trueState, state);
    }

    @Test
    public void testCfg() {
        ConfigExecLexer exec = new ConfigExecLexer();
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

