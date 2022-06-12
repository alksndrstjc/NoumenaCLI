package org.example.service.reader;

import org.example.model.Model;

import java.io.InputStream;
import java.util.List;

public interface Reader {

    List<Model> read(InputStream inputStream);
}
