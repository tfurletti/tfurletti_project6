package com.example.valorantinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AgentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_agent_list);

        // Check that the activity is using the layout version with the fragment_container FrameLayout
        if(findViewById(R.id.fragment_container) != null)
        {
            // if we are being restored from a previous state, then we dont need to do anything and should
            // return or else we could end up with overlapping fragments.
            if(savedInstanceState != null)
                return;

            AgentListFragment agentListFragment = new AgentListFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // add fragment to the fragment container layout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, agentListFragment).commit();
        }
    }
}
