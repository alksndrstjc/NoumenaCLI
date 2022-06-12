package org.example.service.reader;

import com.opencsv.bean.AbstractBeanField;

public class CsvCreditLimitConverter extends AbstractBeanField<String, String> {

    @Override
    protected String convert(String s) {
        return String.valueOf(Math.round(Double.parseDouble(s) * 100));
    }
}
