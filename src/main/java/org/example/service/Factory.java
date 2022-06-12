package org.example.service;

import org.example.service.reader.CsvReader;
import org.example.service.reader.PnrReader;
import org.example.service.reader.Reader;
import org.example.service.writer.HtmlWriter;
import org.example.service.writer.JsonWriter;
import org.example.service.writer.Writer;

public class Factory {
    private final InputArg inputArg;
    private final OutputArg outputArg;

    public Factory(InputArg inputArg, OutputArg outputArg) {
        this.inputArg = inputArg;
        this.outputArg = outputArg;
    }

    public Reader reader() {
        switch (inputArg) {
            case CSV:
                return new CsvReader();
            case PRN:
                return new PnrReader();
        }
        throw new RuntimeException("Bad input arg.");
    }

    public Writer writer() {
        switch (outputArg) {
            case HTML:
                return new HtmlWriter();
            case JSON:
                return new JsonWriter();
        }
        throw new RuntimeException("Bad output arg.");
    }

    public enum InputArg {
        CSV, PRN
    }

    public enum OutputArg {
        HTML, JSON
    }
}
