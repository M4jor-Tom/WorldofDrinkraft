package com.example.worldofdrinkraft.architecture.presentation;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldofdrinkraft.R;
import com.example.worldofdrinkraft.role.AbstractRole;
import com.example.worldofdrinkraft.role.RoleFactory;

public class RoleListActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_list);

        ListView roleListView = (ListView)findViewById(R.id.role_list_view);

        roleListView.setAdapter(
                new ArrayAdapter<AbstractRole>(
                        RoleListActivity.this,
                        R.layout.adapter_role,
                        RoleFactory.getAllRoles()
                )
        );
    }
}