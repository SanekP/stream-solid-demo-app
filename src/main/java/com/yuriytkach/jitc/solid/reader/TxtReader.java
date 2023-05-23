package com.yuriytkach.jitc.solid.reader;

import com.yuriytkach.jitc.solid.util.MimeType;

public class TxtReader implements Reader {
    @Override
    public boolean canRead(MimeType mimeType) {
        return mimeType == MimeType.TEXT;
    }

    @Override
    public String readContentAsString(byte[] byteContent) {
        return new String(byteContent);
    }
}
