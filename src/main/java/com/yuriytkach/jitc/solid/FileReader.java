package com.yuriytkach.jitc.solid;

import com.yuriytkach.jitc.solid.reader.Reader;
import com.yuriytkach.jitc.solid.util.MimeType;

import java.util.ArrayList;

public class FileReader {
    private final ArrayList<Reader> readers = new ArrayList<>();

    public String readContentAsString(String fileName, byte[] byteContent) {
        MimeType type = MimeType.fromFileName(fileName);
        return readers.stream()
                .filter(reader -> reader.canRead(type))
                .findFirst()
                .map(reader -> reader.readContentAsString(byteContent))
                .orElseThrow();
    }

    public void register(Reader reader) {
        readers.add(reader);
    }

    public boolean canRead(String fileName) {
        MimeType type = MimeType.fromFileName(fileName);
        return readers.stream()
                .anyMatch(reader -> reader.canRead(type));
    }
}
