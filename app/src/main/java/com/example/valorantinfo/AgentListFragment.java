package com.example.valorantinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class AgentListFragment extends Fragment {
    private TextView textView_favoriteAgent;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_agentlist, container, false);

        v.findViewById(R.id.textView_pheonix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getResources().getString(R.string.char1);
                String role = getResources().getString(R.string.class_duelist);
                String desc = getResources().getString(R.string.char1desc);
                int imageID = R.drawable.pheonix_card;

                AgentFragment agentFragment = AgentFragment.newInstance(name, role, desc, imageID);
                getFragmentManager().beginTransaction().replace
                        (R.id.fragment_container, agentFragment).addToBackStack(null).commit();

            }
        });

        v.findViewById(R.id.textView_jett).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getResources().getString(R.string.char2);
                String role = getResources().getString(R.string.class_duelist);
                String desc = getResources().getString(R.string.char2desc);
                int imageID = R.drawable.jett_card;

                AgentFragment agentFragment = AgentFragment.newInstance(name, role, desc, imageID);
                getFragmentManager().beginTransaction().replace
                        (R.id.fragment_container, agentFragment).addToBackStack(null).commit();

            }
        });

        v.findViewById(R.id.textView_sage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getResources().getString(R.string.char3);
                String role = getResources().getString(R.string.class_support);
                String desc = getResources().getString(R.string.char3desc);
                int imageID = R.drawable.sage_card;

                AgentFragment agentFragment = AgentFragment.newInstance(name, role, desc, imageID);
                getFragmentManager().beginTransaction().replace
                        (R.id.fragment_container, agentFragment).addToBackStack(null).commit();

            }
        });

        final SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        int agentIndex = sharedPreferences.getInt(getString(R.string.saved_fav_agent_key), -1);

        textView_favoriteAgent = (TextView) v.findViewById(R.id.textView_favoriteAgent);
        final RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup_agents);

        if (agentIndex == -1 ) {
            textView_favoriteAgent.setText("None");
            radioGroup.clearCheck();

        } else {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(agentIndex);
            radioButton.setChecked(true);
            textView_favoriteAgent.setText(radioButton.getText());
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) v.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                // Save to Shared Preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(getString(R.string.saved_fav_agent_key), index);
                editor.commit();

                textView_favoriteAgent.setText(radioButton.getText());
            }
        });

        return v;
    }
}
