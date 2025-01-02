package com.example.mybook;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsActivity extends AppCompatActivity {

    Spinner spinnerLanguage;
    TextView tvSelectedLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        spinnerLanguage = findViewById(R.id.spinnerLanguage);
        tvSelectedLanguage = findViewById(R.id.tvSelectedLanguage);

        // ArrayAdapter untuk spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.language_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(adapter);

        // Event listener untuk spinner
        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = parent.getItemAtPosition(position).toString();
                tvSelectedLanguage.setText("Bahasa Dipilih: " + selectedLanguage);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Tidak ada aksi jika tidak ada yang dipilih
            }
        });

        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ImageView favorite = findViewById(R.id.favorit);
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });
        ImageView last = findViewById(R.id.terakhirdilihat);
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, TerakhirdilihatActivity.class);
                startActivity(intent);
            }
        });
    }
}