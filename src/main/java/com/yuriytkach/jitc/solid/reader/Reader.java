package com.yuriytkach.jitc.solid.reader;

import com.yuriytkach.jitc.solid.util.MimeType;

public interface Reader {
    boolean canRead(MimeType mimeType);

    String readContentAsString(byte[] byteContent);
}
