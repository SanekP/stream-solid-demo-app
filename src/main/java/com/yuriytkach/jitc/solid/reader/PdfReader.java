package com.yuriytkach.jitc.solid.reader;

import com.yuriytkach.jitc.solid.util.MimeType;

public class PdfReader implements Reader {
    @Override
    public boolean canRead(MimeType mimeType) {
        return mimeType == MimeType.ADOBE_PORTABLE_DOCUMENT_FORMAT;
    }

    @Override
    public String readContentAsString(byte[] byteContent) {
        return "Content of PDF file.";
    }
}
