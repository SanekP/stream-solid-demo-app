package com.yuriytkach.jitc.solid;

import com.yuriytkach.jitc.solid.reader.PdfReader;
import com.yuriytkach.jitc.solid.reader.TxtReader;
import com.yuriytkach.jitc.solid.reader.WordReader;

import java.nio.file.Path;

public class FileProcessorApp {

  public static void main(final String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: file-processor <folder> <word to search>");
      System.exit(1);
    }
    final String folder = args[0];
    final String word = args[1];

    new FileProcessorApp().count(folder, word);
  }

  private void count(final String folder, final String word) {
    FileReader fileReader = configureReader();
    final FileFinder fileFinder = new FileFinder(Path.of(folder), fileReader);

    final FileProcessor fileProcessor = new FileProcessor(
      fileFinder,
      new FileDownloader(),
      fileReader,
      new TextFileAnalyzer()
    );

    final long count = fileProcessor.processLatestTextFile(word);
    System.out.printf("Occurrences of word '%s': %d%n", word, count);
  }

  private FileReader configureReader() {
    FileReader fileReader = new FileReader();
    fileReader.register(new TxtReader());
    fileReader.register(new PdfReader());
    fileReader.register(new WordReader());
    return fileReader;
  }
}
