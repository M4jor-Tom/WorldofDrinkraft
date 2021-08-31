package com.example.worldofdrinkraft.language;

import android.util.Log;

import java.util.Locale;

public class LanguageManager
{
    private Language _language;

    private static LanguageManager _languageManager = null;

    public static final String UNSET_LANGUAGE_ERROR_MESSAGE = "Unset language";

    public LanguageManager(Language language)
    {
        setLanguage(language);
    }

    public static LanguageManager getInstance()
    {
        if(_languageManager == null)
            _languageManager = new LanguageManager(getSystemLanguage());

        return _languageManager;
    }

    private static Language getSystemLanguage()
    {
        String locale = Locale.getDefault().getLanguage();

        switch(locale)
        {
            case "en":
                return Language.ENGLISH;

            case "fr":
                return Language.FRENCH;
        }

        Log.e("getSystemLanguage()", "Unknown locale: " + locale);
        return null;
    }

    public void setLanguage(Language language)
    {
        _language = language;
    }

    public Language getLanguage()
    {
        return _language;
    }
}