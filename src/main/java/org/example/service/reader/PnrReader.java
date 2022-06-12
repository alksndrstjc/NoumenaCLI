package org.example.service.reader;

import org.example.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PnrReader implements Reader {
    @Override
    public List<Model> read(InputStream inputStream) {
        List<Model> models = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1))) {
            if (br.ready()) {
                String line;
                boolean firstLine = true;
                while ((line = br.readLine()) != null) {
                    if (firstLine || line.trim().equals("")) {
                        firstLine = false;
                        continue;
                    }
                    String[] parts = splitStringToChunks(line, 16, 22, 9, 14, 13, 8);
                    Model model = new Model();
                    model.setName(parts[0]);
                    model.setAddress(parts[1]);
                    model.setPostcode(parts[2]);
                    model.setPhone(parts[3]);
                    model.setCreditLimit(parts[4]);
                    model.setBirthday(LocalDate.parse(parts[5], DateTimeFormatter.BASIC_ISO_DATE).toString());
                    models.add(model);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return models;
    }

    public static String[] splitStringToChunks(String inputString, int... chunkSizes) {
        List<String> list = new ArrayList<>();
        int chunkStart, chunkEnd = 0;
        for (int length : chunkSizes) {
            chunkStart = chunkEnd;
            chunkEnd = chunkStart + length;
            String dataChunk = inputString.substring(chunkStart, chunkEnd);
            list.add(dataChunk.trim());
        }
        return list.toArray(new String[0]);
    }
}
