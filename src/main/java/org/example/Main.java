package org.example;

import org.example.service.Factory;
import org.example.service.reader.Reader;
import org.example.service.writer.Writer;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Bad arguments");
            return;
        }
        Factory.InputArg input = Factory.InputArg.valueOf(args[0].toUpperCase());
        Factory.OutputArg output = Factory.OutputArg.valueOf(args[1].toUpperCase());
        Factory factory = new Factory(input, output);
        Reader reader = factory.reader();
        Writer writer = factory.writer();

        writer.write(reader.read(System.in));
    }
}
