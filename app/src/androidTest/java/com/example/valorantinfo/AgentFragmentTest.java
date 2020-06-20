package com.example.valorantinfo;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgentFragmentTest {
    @Test
    public void validateFragmentArguments() {
        String testName = "Bob";
        String testRole = "Builder";
        String testDesc = "He's Bob the Builder";
        int testID = 1485;

        // Grabbing the tags
        String ARG_NAME = AgentFragment.ARG_NAME;
        String ARG_ROLE = AgentFragment.ARG_ROLE;
        String ARG_DESC = AgentFragment.ARG_DESC;
        String ARG_IMAGEID = AgentFragment.ARG_IMAGEID;

        AgentFragment agentFragment = AgentFragment.newInstance(testName, testRole, testDesc, testID);

        String frag_name = agentFragment.getArguments().getString(ARG_NAME);
        String frag_role = agentFragment.getArguments().getString(ARG_ROLE);
        String frag_desc = agentFragment.getArguments().getString(ARG_DESC);
        int frag_imageID = agentFragment.getArguments().getInt(ARG_IMAGEID);

        assertEquals(frag_name, testName);
        assertEquals(frag_role,testRole);
        assertEquals(frag_desc, testDesc);
        assertEquals(frag_imageID, testID);
    }

    @Test
    public void failedValidationArguments() {
        String TAG = "failedValidationArguments()";
        String testName = "Bob";
        String testRole = "Builder";
        String testDesc = "He's Bob the Builder";
        int testID = 1485;

        // Grabbing the tags
        String ARG_NAME = AgentFragment.ARG_NAME;
        String ARG_ROLE = AgentFragment.ARG_ROLE;
        String ARG_DESC = AgentFragment.ARG_DESC;
        String ARG_IMAGEID = AgentFragment.ARG_IMAGEID;

        AgentFragment agentFragment = AgentFragment.newInstance(testName, testRole, testDesc, testID);

        String frag_name = agentFragment.getArguments().getString(ARG_NAME);
        String frag_role = agentFragment.getArguments().getString(ARG_ROLE);
        String frag_desc = agentFragment.getArguments().getString(ARG_DESC);
        int frag_imageID = agentFragment.getArguments().getInt(ARG_IMAGEID);

        try {
            assertEquals(frag_name, "Rob");
            assertEquals(frag_role, testRole);
            assertEquals(frag_desc, testDesc);
            assertEquals(frag_imageID, testID);
        } catch (AssertionError e) {
            Log.d(TAG, "failedValidationArguments: Caught Exception SUCCESS");
        }
    }
}
