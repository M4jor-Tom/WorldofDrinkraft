package com.example.worldofdrinkraft.architecture.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        roleListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        Intent roleIntent = new Intent(
                                RoleListActivity.this,
                                RoleWatchActivity.class
                        );

                        roleIntent.putExtra("p" /*rolePosition*/, position);

                        startActivity(roleIntent);
                    }
                }
        );
    }
}