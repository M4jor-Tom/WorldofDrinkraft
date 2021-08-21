package com.example.worldofdrinkraft.language;

public class LanguageManager
{
    private LanguageType _languageType;

    private static LanguageManager _languageManager = null;

    public static final String UNSET_LANGUAGE_ERROR_MESSAGE = "Unset language";

    public LanguageManager(LanguageType languageType)
    {
        setLanguageType(languageType);
    }

    public static LanguageManager getInstance()
    {
        if(_languageManager == null)
            _languageManager = new LanguageManager(LanguageType.ENGLISH);

        return _languageManager;
    }

    public void setLanguageType(LanguageType languageType)
    {
        _languageType = languageType;
    }

    public LanguageType getLanguageType()
    {
        return _languageType;
    }
}