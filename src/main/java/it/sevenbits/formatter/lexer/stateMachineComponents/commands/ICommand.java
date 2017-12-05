package it.sevenbits.formatter.lexer.stateMachineComponents.commands;

public interface ICommand {
    public void execute(char c, StringBuilder stringBuilder);
}
