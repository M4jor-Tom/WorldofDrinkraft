package com.example.worldofdrinkraft.architecture.presentation;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldofdrinkraft.R;
import com.example.worldofdrinkraft.role.AbstractRole;
import com.example.worldofdrinkraft.role.RoleFactory;

public class RoleWatchActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_role);

        TextView roleLabelTextView = (TextView)findViewById(R.id.watch_role_label);
        TextView roleRuleTextView = (TextView)findViewById(R.id.watch_role_rule);
        TextView roleIsUniqueTextView = (TextView)findViewById(R.id.watch_role_is_unique);
        TextView roleIsInGroupTextView = (TextView)findViewById(R.id.watch_role_is_in_group);

        if(getIntent().hasExtra("p" /*rolePosition*/))
        {
            try
            {
                AbstractRole role = RoleFactory.getAllRoles().get(getIntent().getIntExtra("p", -1));

                roleLabelTextView.setText(role.getLabel());
                roleRuleTextView.setText(role.getRule());

                if(role.isUnique())
                    roleIsUniqueTextView.setText(R.string.unique_role_text);
                if(role.isInGroup())
                    roleIsInGroupTextView.setText(R.string.in_group_role_text);
            }
            catch(NullPointerException e)
            {
                Log.e("RoleWatchActivity", "Invalid intent");
            }
        }
        else
            Log.e("RoleWatchActivity", "Missing required intent (p aka rolePosition)");
    }
}