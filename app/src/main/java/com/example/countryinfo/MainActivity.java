package com.example.countryinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] countries = {"Turkey","Iran","Pakistan","Malaysia","Ireland","UK","Germany","Japan","Spain","Russia","Italy","Brazil","Kenya", "Saudi Arabia", "South Africa", "Lesotho", "Namibia", "Iraq", "Lebanon"};
    private String webpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // For custom actionBar:
        // https://stackoverflow.com/questions/47032059/how-to-change-actionbar-title-and-subtitle-font-size-in-android/47032506
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                webpage = "https://en.wikipedia.org/wiki/";
                String forToast = "Opening " + countries[i] + "'s info";
                Toast.makeText(MainActivity.this,forToast,Toast.LENGTH_LONG).show();
                webpage += countries[i];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
                startActivity(intent);

            }
        });

    }

}