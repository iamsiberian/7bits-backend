package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.io.IReader;
import it.sevenbits.formatter.io.ReaderException;
import it.sevenbits.formatter.statemachine.State;
import it.sevenbits.formatter.statemachine.lexer.*;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class LexerMachineTest {
    @Test
    public void testStateMachineLoop() throws ReaderException {
        IReader reader = mock(IReader.class);
        when(reader.hasNext()).thenReturn(true, false);
        when(reader.readNext()).thenReturn('a');

        ICommand command = mock(ICommand.class);
        ICommandRepository commands = mock(ICommandRepository.class);
        when(commands.getCommand(any(State.class), anyChar())).thenReturn(command);

        IStateTransitions transitions = mock(IStateTransitions.class);

        ILexer lexer = new Lexer(reader, commands, transitions);
        lexer.readToken();

        verify(reader, times(2)).hasNext();
        verify(reader).readNext();
        verify(commands).getCommand(new State("default"), 'a');
        verify(command).execute(eq('a'), any(IContext.class));
        verify(transitions).nextState(new State("default"), 'a');
    }
}
