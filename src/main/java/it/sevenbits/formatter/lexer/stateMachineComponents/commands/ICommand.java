package it.sevenbits.formatter.lexer.stateMachineComponents.commands;

import it.sevenbits.formatter.lexer.IContext;

public interface ICommand {
    public void execute(char c, IContext iContext);
}
