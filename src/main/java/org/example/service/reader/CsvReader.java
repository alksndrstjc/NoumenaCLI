package org.example.service.reader;

import com.opencsv.bean.CsvToBeanBuilder;
import org.example.model.Model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvReader implements Reader {
    @Override
    public List<Model> read(InputStream inputStream) {
        return new CsvToBeanBuilder<Model>(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1))
                .withType(Model.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();
    }
}
