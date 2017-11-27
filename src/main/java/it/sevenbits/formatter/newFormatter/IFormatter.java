package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.io.interfaces.IReader;
import it.sevenbits.formatter.io.interfaces.IWriter;

public interface IFormatter {
    void format(IReader iReader, IWriter iWriter);
}
