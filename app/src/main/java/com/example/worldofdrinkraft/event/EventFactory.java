package com.example.worldofdrinkraft.event;

import android.util.Log;

public class EventFactory
{
    public static AbstractEvent getEventByType(EventType eventType)
    {
        switch(eventType)
        {
            case DID_OR_DIDNT_TYPE:
                return new DidOrDidntEvent();

            case TRUTH_OR_DARE_TYPE:
                return new TruthOrDareEvent();
        }

        Log.e("EventFactory::ByType", "Unset Event");
        return null;
    }

    public static AbstractEvent getRandomEvent()
    {
        return getEventByType(EventType.randomEventType());
    }
}