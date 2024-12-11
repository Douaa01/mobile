package com.example.hellotoast;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Récupérer la valeur passée depuis MainActivity
        int countValue = getIntent().getIntExtra("count", 0);

        // Mettre à jour le TextView avec "Hello!" et la valeur du compteur
        TextView helloTextView = findViewById(R.id.textView_hello);
        helloTextView.setText("Hello!\n" + countValue);
    }
}