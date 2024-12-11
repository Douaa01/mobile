package com.example.android.droidcafeoptions;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class OrderActivity extends AppCompatActivity {

    /**
     * Sets the content view to activity_order, and gets the intent and its
     * data.
     *
     * @param savedInstanceState Saved instance state bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Get the intent and its data.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);

        // Récupération des vues
        Button btnSelectedDate = findViewById(R.id.btnSelectedDate);
        // Initialisation d'un calendrier pour récupérer la date actuelle
        Calendar calendar = Calendar.getInstance();

        // Gestionnaire de clic pour le bouton
        btnSelectedDate.setOnClickListener(v -> {
            // Obtenir les valeurs actuelles de l'année, du mois et du jour
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH); // Les mois commencent à 0
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Créer et afficher le DatePickerDialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    OrderActivity.this, // Contexte
                    (DatePicker view, int selectedYear, int selectedMonth, int selectedDay) -> {
                        // Utiliser un nom différent pour la variable
                        String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        String selectedDateMessage = "Date : " + selectedDate;

                        // Afficher un Toast avec la date choisie
                        Toast.makeText(OrderActivity.this, selectedDateMessage, Toast.LENGTH_SHORT).show();
                    },
                    year, month, day // Date initiale affichée
            );

            datePickerDialog.show(); // Afficher le calendrier
        });
    }

    /**
     * Checks which radio button was clicked and displays a toast message to
     * show the choice.
     *
     * @param view The radio button view.
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    /**
     * Displays the actual message in a toast message.
     *
     * @param message Message to display.
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}
