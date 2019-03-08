package fr.imie.bank.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fr.imie.bank.exceptions.UtilsException;

public class FileUtils {

  private static final Logger LOG = Logger.getLogger(FileUtils.class.getName());

  /**
   * Append a content to a file
   * 
   * @param fileName the relative path to the file
   * @param content a content to append
   * @throws UtilsException
   */
  public static void appendToFile(final String fileName, final String content)
      throws UtilsException {
    LOG.log(Level.INFO, "I'm appending " + content + " to file : " + fileName);
    FileWriter fw = null;
    try {
      fw = new FileWriter(new File(fileName), true);
      PrintWriter pw = new PrintWriter(fw);
      pw.append(content);
      pw.append("\n");
      pw.close();
    } catch (Exception e) {
      LOG.log(Level.SEVERE, "Error while writing to file " + fileName, e);
      throw new UtilsException();
    }
  }

  public static List<String> readFile(final String fileName) {
    final List<String> content = new ArrayList<>();
    try {
      final FileReader fr = new FileReader(fileName);
      try (BufferedReader br = new BufferedReader(fr)) {
        String line;

        while ((line = br.readLine()) != null) {
          content.add(line);
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    return content;

  }
}
