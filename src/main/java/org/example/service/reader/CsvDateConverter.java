package org.example.service.reader;

import com.opencsv.bean.AbstractBeanField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvDateConverter extends AbstractBeanField<String, String> {
    @Override
    protected String convert(String s) {
        return LocalDate.parse(s, DateTimeFormatter.ofPattern("dd/MM/uuuu")).toString();
    }
}
