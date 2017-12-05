package it.sevenbits.formatter.lexer.stateMachineComponents.commands;

public class Default implements ICommand {

    @Override
    public void execute(char c, StringBuilder stringBuilder) {
        stringBuilder.append(c);
    }
}

