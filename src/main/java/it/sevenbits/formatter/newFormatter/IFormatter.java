package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IReader;
import it.sevenbits.formatter.io.interfaces.IStringWriter;
import it.sevenbits.formatter.io.interfaces.IWriter;
import it.sevenbits.formatter.lexer.Lexer;

public interface IFormatter {
    void format(Lexer lexer, IStringWriter iWriter) throws ReaderException;
}
