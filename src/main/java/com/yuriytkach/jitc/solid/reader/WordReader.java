package com.yuriytkach.jitc.solid.reader;

import com.yuriytkach.jitc.solid.util.MimeType;

public class WordReader implements Reader {
    @Override
    public boolean canRead(MimeType mimeType) {
        return mimeType == MimeType.MICROSOFT_WORD || mimeType == MimeType.MICROSOFT_WORD_OPEN_XML;
    }

    @Override
    public String readContentAsString(byte[] byteContent) {
        return "Content of Word document.";
    }
}
