package com.gmail.dpierron.tools.i18n;

import com.gmail.dpierron.tools.Helper;

import java.util.Locale;
import java.util.Vector;

public class LocalizationHelper {;

  private final static Object2StringConverter CONVERTER = new MethodCallerConverter("getHumanName");

/*
  public Vector<Locale> getAvailableLocalizations() {
    return Localization.Main.getAvailableLocalizations();
  }
*/
  public static String getEnumConstantHumanName(Enum enumConstant) {
    return getEnumConstantHumanName(enumConstant, false);
  }

  public static String getEnumConstantHumanName(Enum enumConstant, boolean secondary) {
    String label = uncheckedGetEnumConstantHumanName(enumConstant, secondary);
    // nothing worked, use the toString method
    if (label == null)
      label = enumConstant.toString();
    return label;
  }

  public static String uncheckedGetEnumConstantHumanName(Enum enumConstant) {
    return uncheckedGetEnumConstantHumanName(enumConstant, false);
  }

  public static String uncheckedGetEnumConstantHumanName(Enum enumConstant, boolean secondary) {
    if (enumConstant == null)
      return null;
    String label = null;

    if (!secondary) {
      // try calling a getHumanName method on the enum
      label = CONVERTER.getStringValueOrNull(enumConstant);
    }
    if (Helper.isNullOrEmpty(label)) {
      // try looking for a corresponding key in the Localization.Enum map
      String name =
          "enum." + enumConstant.getDeclaringClass().getCanonicalName() + "." + (secondary ? "secondary." : "") + enumConstant.name();
      label = Localization.Enum.getText(name);
      if (label.equals(name))
        label = null;
    }
    return label;
  }

  public static String getYesOrNo(Boolean b) {
    if (b == null)
      return "";
    if (b.booleanValue())
      return Localization.Main.getText("boolean.yes");
    else
      return Localization.Main.getText("boolean.no");
  }
}
