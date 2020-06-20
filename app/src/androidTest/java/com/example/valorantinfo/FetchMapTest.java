package com.example.valorantinfo;

import android.util.Log;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FetchMapTest {
    @Test
    public void getMapValidator() {
        String TAG = "getMapValidator()";
        String url = "https://blitz.gg/valorant/maps/haven";
        String ImageURL = "https://blitz-cdn.blitz.gg/blitz/val/maps/haven/haven-hero-new.jpeg";

        assertEquals(ImageURL, MapActivity.getImageURL(url));
        Log.d(TAG, "getMapValidator: return SUCCESS");
    }

    @Test
    public void getMapFailedValidator() {
        String TAG = "getMapFailedValidator()";
        String url = "google.com";
        String ImageURL = "https://blitz-cdn.blitz.gg/blitz/val/maps/haven/haven-hero-new.jpeg";

        try {
            assertEquals(ImageURL, MapActivity.getImageURL(url));
        } catch (Exception e) {
            Log.d(TAG, "getMapFailedValidator: Caught Exception SUCCESS");
        }
    }
}
