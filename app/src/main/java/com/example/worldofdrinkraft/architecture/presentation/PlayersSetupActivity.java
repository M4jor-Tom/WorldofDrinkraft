package com.example.worldofdrinkraft.architecture.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.worldofdrinkraft.R;
import com.example.worldofdrinkraft.architecture.business.IBusinessContainer;
import com.example.worldofdrinkraft.player.ExistentPlayerException;
import com.example.worldofdrinkraft.player.Player;
import com.example.worldofdrinkraft.role.AbstractRole;
import com.example.worldofdrinkraft.role.RoleFactory;
import com.google.android.material.button.MaterialButton;

public class PlayersSetupActivity extends AppCompatActivity
{
    private EditText _playerNameEditText;
    private Spinner _playerRoleSpinner;
    private ListView _playerListView;
    private CheckBox _playerDrinksCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_setup);

        setPlayerNameEditText((EditText)findViewById(R.id.player_setup_name));
        MaterialButton addPlayerButton = (MaterialButton)findViewById(R.id.player_setup_add_player);
        setPlayerRoleSpinner((Spinner)findViewById(R.id.player_setup_role_spinner));
        setPlayerListView((ListView)findViewById(R.id.player_setup_player_list_view));
        MaterialButton randomizePlayersRolesButton = (MaterialButton)findViewById(R.id.player_setup_randomize_roles);
        setPlayerDrinksCheckbox((CheckBox)findViewById(R.id.player_setup_drinker_checkbox));

        getPlayerRoleSpinner().setAdapter(
                new ArrayAdapter<AbstractRole>(
                        PlayersSetupActivity.this,
                        R.layout.adapter_role,
                        RoleFactory.getAllRoles()
                )
        );

        actualizePlayerListView();

        addPlayerButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {

                        try
                        {
                            IBusinessContainer.getInstance().addPlayer(
                                    new Player(
                                            getPlayerNameEditText().getText().toString(),
                                            (AbstractRole)getPlayerRoleSpinner().getSelectedItem(),
                                            getPlayerDrinksCheckbox().isChecked()
                                    )
                            );

                            getPlayerNameEditText().setText("");
                            actualizePlayerListView();
                        }
                        catch(ExistentPlayerException e)
                        {
                            Toast.makeText(
                                    PlayersSetupActivity.this,
                                    e.getMessage(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
        );

        randomizePlayersRolesButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        IBusinessContainer.getInstance().randomizePlayerRoles();
                        actualizePlayerListView();
                    }
                }
        );
    }

    private void actualizePlayerListView()
    {
        getPlayerListView().setAdapter(
                new ArrayAdapter<Player>(
                        PlayersSetupActivity.this,
                        R.layout.adapter_player,
                        IBusinessContainer.getInstance().getPlayerList()
                )
        );
    }

    private void setPlayerNameEditText(EditText playerNameEditText)
    {
        _playerNameEditText = playerNameEditText;
    }

    private EditText getPlayerNameEditText()
    {
        return _playerNameEditText;
    }

    private void setPlayerRoleSpinner(Spinner playerRoleSpinner)
    {
        _playerRoleSpinner = playerRoleSpinner;
    }

    private Spinner getPlayerRoleSpinner()
    {
        return _playerRoleSpinner;
    }

    private void setPlayerListView(ListView playerListView)
    {
        _playerListView = playerListView;
    }

    private ListView getPlayerListView()
    {
        return _playerListView;
    }

    private void setPlayerDrinksCheckbox(CheckBox playerDrinksCheckbox)
    {
        _playerDrinksCheckbox = playerDrinksCheckbox;
    }

    private CheckBox getPlayerDrinksCheckbox()
    {
        return _playerDrinksCheckbox;
    }
}