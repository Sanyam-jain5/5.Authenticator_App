package com.example.authenticatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewImages extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Image> images;
    private  static  String JSON_URL = "https://jsonplaceholder.typicode.com/photos";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_images);

        recyclerView = findViewById(R.id.imagesList);
        images = new ArrayList<>();
        extractImages();
    }

    private void extractImages() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject imageObject = response.getJSONObject(i);
                        Image image = new Image();
                        image.setTitle(imageObject.getString("title").toString());
                        image.setAlbumId(imageObject.getString("albumId").toString());
                        image.setI_d(imageObject.getString("id").toString());
                        image.setImageURL(imageObject.getString("url"));
                        image.setThumbnailUrl(imageObject.getString("thumbnailUrl"));

                        images.add(image);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(),images);
                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag","onErrorResponse:" + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }
}