package com.example.worldofdrinkraft.player;

import com.example.worldofdrinkraft.language.Language;
import com.example.worldofdrinkraft.language.MultiLanguageString;

import java.util.HashMap;
import java.util.Map;

public class RoleForDrinkerException extends Exception
{
    @Override
    public String getMessage()
    {
        Map<Language, String> message = new HashMap<>();

        message.put(Language.ENGLISH, "This role is for drinkers only.");
        message.put(Language.FRENCH, "Ce rôle est pour les buveurs uniquement.");

        return (new MultiLanguageString(message)).toString();
    }
}