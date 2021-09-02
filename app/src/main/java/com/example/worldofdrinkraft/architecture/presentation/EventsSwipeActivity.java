package com.example.worldofdrinkraft.architecture.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldofdrinkraft.R;
import com.example.worldofdrinkraft.architecture.business.IBusinessContainer;

public class EventsSwipeActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_swipe);

        TextView textView = (TextView)findViewById(R.id.event_swipe_text_view);

        textView.setText(IBusinessContainer.getInstance().getNextEvent().getText());

        textView.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        textView.setText(
                                IBusinessContainer.getInstance().getNextEvent().getText()
                        );
                    }
                }
        );
    }
}