package com.example.worldofdrinkraft.language;

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
            _languageManager = new LanguageManager(Language.ENGLISH);

        return _languageManager;
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