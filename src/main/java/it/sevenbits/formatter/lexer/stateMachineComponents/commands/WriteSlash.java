package it.sevenbits.formatter.lexer.stateMachineComponents.commands;

public class WriteSlash implements ICommand {
    @Override
    public void execute(char c, StringBuilder stringBuilder) {
        stringBuilder.append(c);
    }
}
