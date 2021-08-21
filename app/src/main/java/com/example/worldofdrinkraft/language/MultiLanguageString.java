package com.example.worldofdrinkraft.language;

import android.util.Log;

import java.util.Map;

public class MultiLanguageString
{
    Map<Language, String> _stringList;

    public MultiLanguageString(Map<Language, String> stringList)
    {
        setStringList(stringList);
    }

    private void setString(String string)
    {
        setString(LanguageManager.getInstance().getLanguage(), string);
    }

    public String getString()
    {
        return getString(LanguageManager.getInstance().getLanguage());
    }

    private void setString(Language language, String string)
    {
        getStringList().put(language, string);
    }

    public String getString(Language language)
    {
        return getStringList().get(language);
    }

    @Override
    public String toString()
    {
        return getString();
    }

    private void setStringList(Map<Language, String> stringList)
    {
        for(Language language: Language.values())
            if(!stringList.containsKey(language))
                Log.e("MLS.setStringList(Map)", LanguageManager.UNSET_LANGUAGE_ERROR_MESSAGE);

        _stringList = stringList;
    }

    private Map<Language, String> getStringList()
    {
        return _stringList;
    }
}