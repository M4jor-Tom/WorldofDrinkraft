package com.example.worldofdrinkraft.language;

public class Language
{
    private LanguageType _languageType;

    private static Language _language = null;

    public static final String UNSET_LANGUAGE_ERROR_MESSAGE = "Unset language";

    public Language(LanguageType languageType)
    {
        setLanguageType(languageType);
    }

    public static Language getInstance()
    {
        if(_language == null)
            _language = new Language(LanguageType.ENGLISH);

        return _language;
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