package com.example.valorantinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AgentFragment extends Fragment {
    static final String ARG_NAME = "argName";
    static final String ARG_ROLE = "argRole";
    static final String ARG_DESC = "argDesc";
    static final String ARG_IMAGEID = "argImageID";

    private String name, role, desc;
    private int imageID;

    public static final AgentFragment newInstance(String name, String role, String desc, int imageID) {
        AgentFragment agentFragment = new AgentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME,name);
        args.putString(ARG_ROLE, role);
        args.putString(ARG_DESC, desc);
        args.putInt(ARG_IMAGEID, imageID);
        agentFragment.setArguments(args);

        return agentFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_agent, container, false);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            role = getArguments().getString(ARG_ROLE);
            desc = getArguments().getString(ARG_DESC);
            imageID = getArguments().getInt(ARG_IMAGEID);
        }

        TextView textView_name = v.findViewById(R.id.textView_agentName);
        TextView textView_role = v.findViewById(R.id.textView_agentRole);
        TextView textView_desc = v.findViewById(R.id.textView_agentDesc);
        ImageView imageView_agent = v.findViewById(R.id.imageView_agent);

        textView_name.setText(name);
        textView_role.setText(role);
        textView_desc.setText(desc);
        imageView_agent.setImageResource(imageID);

        return v;
    }
}
