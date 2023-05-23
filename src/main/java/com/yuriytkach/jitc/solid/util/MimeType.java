package com.yuriytkach.jitc.solid.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum MimeType {
    TEXT("text/plain", ".txt"),
    ADOBE_PORTABLE_DOCUMENT_FORMAT("application/pdf", ".pdf"),
    MICROSOFT_WORD("application/msword", ".doc"),
    MICROSOFT_WORD_OPEN_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.document", ".docx"),
    ANY("application/octet-stream", ".bin");

    private String contentType;
    private String extension;

    public static MimeType fromFileName(String fileName) {
        return Arrays.stream(values())
                .filter(mimeType -> fileName.endsWith(mimeType.extension))
                .findAny()
                .orElse(ANY);
    }
}
