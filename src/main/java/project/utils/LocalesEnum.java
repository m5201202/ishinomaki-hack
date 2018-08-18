package project.utils;

import java.util.Locale;

public enum LocalesEnum {
    JA((short)1, "label_locale_ja", Locale.JAPANESE),
    EN((short)2, "label_locale_en", Locale.ENGLISH);

    private Short id;
    private String labelKey;
    private Locale locale;

    LocalesEnum(Short id, String labelKey, Locale locale) {
        this.id = id;
        this.labelKey = labelKey;
        this.locale = locale;
    }

    public Short getId() {
        return id;
    }

    public String getLabelKey() {
        return labelKey;
    }

    public Locale getLocale() {
        return locale;
    }

    public static LocalesEnum get(Locale locale) {
        if (locale.equals(JA.getLocale())) return JA;
        else if (locale.equals(EN.getLocale())) return EN;
        return EN;
    }
}
