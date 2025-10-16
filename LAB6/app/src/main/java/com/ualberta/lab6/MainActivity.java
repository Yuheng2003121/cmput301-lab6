package com.ualberta.lab6;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


/**
 * The main activity for the application.
 * This class is the entry point of the app and handles the main user interface.
 * It is responsible for setting the layout and initializing components.
 *
 * @author Your Name
 * @version 1.0
 * @since 2025-10-15
 */
public class MainActivity extends AppCompatActivity {

/**
 * Called when the activity is first created.
 * This method initializes the activity, sets the content view, and
 * wires up UI components.
 *
 * @param savedInstanceState If the activity is being re-initialized after
 *                           previously being shut down then this Bundle contains the data it most
 *                           recently supplied in onSaveInstanceState(Bundle).
 */
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}