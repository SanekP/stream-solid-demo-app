package com.yuriytkach.jitc.solid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileProcessor {

  private final FileFinder fileFinder;

  private final FileDownloader fileDownloader;

  private final FileReader fileReader;

  private final TextFileAnalyzer textFileAnalyzer;

  public long processLatestTextFile(final String wordToCount) {
    final String latestFileKey = fileFinder.findLatestTextFile();
    final byte[] byteContent = fileDownloader.downloadFileContent(latestFileKey);
    String stringContent = fileReader.readContentAsString(latestFileKey, byteContent);
    return textFileAnalyzer.countWordOccurrences(stringContent, wordToCount);
  }

}
