package com.example.valorantinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;

public class MapActivity extends AppCompatActivity {
    private ImageView imageView_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        imageView_map = (ImageView) findViewById(R.id.imageView_map);

        Content content = new Content();
        content.execute();
    }


    private class Content extends AsyncTask<Void, Void, Void> {
        Bitmap bitmap;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String url = "https://blitz.gg/valorant/maps/haven";

            try {
                String imgSrc = getImageURL(url);

                // Download image from URL
                InputStream input = new java.net.URL(imgSrc).openStream();

                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            imageView_map.setImageBitmap(bitmap);
        }
    }

    public static String getImageURL(String url) {
        Document document = null;

        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element img = document.getElementsByClass("map-hero").first().select("img").first();
        return img.absUrl("src");
    }

}


