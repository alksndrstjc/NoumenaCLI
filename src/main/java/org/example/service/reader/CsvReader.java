package org.example.service.reader;

import com.opencsv.bean.CsvToBeanBuilder;
import org.example.model.Model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class CsvReader implements Reader {
    @Override
    public List<Model> read(InputStream inputStream) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1)) {
            if (inputStreamReader.ready()) {
                return new CsvToBeanBuilder<Model>(inputStreamReader)
                        .withType(Model.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build()
                        .parse();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }
}
