package com.gmail.dpierron.calibre.datamodel;

import java.lang.String;

/**
 * Created with IntelliJ IDEA.
 * User: WalkerDJ
 * Class that is used to hold the type details of a custom column
 */
public class CustomColumnType {

  private long    id;
  private String  label;
  private String  name;
  private String  datatype;
  private boolean  is_multiple;
  private boolean  normalized;
  // TODO Decide if we should use the display format field from Calibre
  // private String   display;

  //  CONSTRUCTORS

  public CustomColumnType(long id, String label, String name, String datatype, boolean is_multiple, boolean normalized){
    this.id = id;
    this.label = label;
    this.name = name;
    this.datatype = datatype;
    this.is_multiple = is_multiple;
    this.normalized = normalized;
  }

  //  METHODS and PROPERTIES

  /**
   * Get Calibre internal Id for this custom column
   * @return
   */
  public Long getId() {
    return id;
  }

  /**
   * Get Calibre custom column label
   * (this is the column name used internally within Calibre)
   * @return
   */
  public String getLabel() {
    return label;
  }

  /**
   * Get Custom Column display name
   * (This is the name displayed in the Calibre GUI)
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Get custom column type
   *
   * @return
   */
  public String getDatatype() {
    return datatype;
  }

  /**
   * Get custom column formatting string for displaying values in Calibre
   *
   * @return
   */
  public boolean isNormalized () {
    return normalized;
  }

  /**
   * Get whether curom column is multi-value
   * @return
   */
  public boolean isMultiple () {
    return is_multiple;
  }

  /**
   * check if a custom column with the given name actually exists!
   * @param name
   * @return
   */
  public boolean isCustomColumn (String name) {
    return false;
  }

}
