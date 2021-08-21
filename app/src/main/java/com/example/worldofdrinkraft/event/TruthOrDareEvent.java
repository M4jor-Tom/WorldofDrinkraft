package com.example.worldofdrinkraft.event;

public class TruthOrDareEvent extends AbstractEvent
{
    @Override
    public EventType getType()
    {
        return EventType.TRUTH_OR_DARE_TYPE;
    }

    @Override
    protected String getEnglishText()
    {
        return "Truth or dare !";
    }

    @Override
    protected String getFrenchText()
    {
        return "Action ou vérité !";
    }
}