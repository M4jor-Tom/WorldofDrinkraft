package com.example.worldofdrinkraft.event;

public class DidOrDidntEvent extends AbstractEvent
{
    @Override
    public EventType getType()
    {
        return EventType.DID_OR_DIDNT_TYPE;
    }

    @Override
    protected String getEnglishText()
    {
        return "I did or I didn't !";
    }

    @Override
    protected String getFrenchText()
    {
        return "J'ai ou je n'ai jamais !";
    }
}