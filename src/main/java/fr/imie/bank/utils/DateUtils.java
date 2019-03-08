package fr.imie.bank.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

  /** DMY date format. */
  public static final DateTimeFormatter DMY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  /**
   * Parses a date in DMY format and returns a LocalDate object.
   * 
   * @param text a date as a string in DMY format
   * @return a LocalDate object
   */
  public static LocalDate toDate(String text) {
    return LocalDate.parse(text, DMY);
  }

  /**
   * Formats a date object and returns a string in DMY format.
   * 
   * @param date a LocalDate object
   * @return a date as a string in DMY format
   */
  public static String toString(LocalDate date) {
    return date.format(DMY);
  }

}
