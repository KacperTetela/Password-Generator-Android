package com.example.passwordgeneratorview;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.passwordgeneratorview.api.RetrofitClient;
import com.google.android.material.slider.Slider;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private int selectedSliderValue = 8;
    private TextView passwordTextView;
    private CheckBox bigLetterCheckBox;
    private CheckBox digitalCheckBox;
    private CheckBox specialSignsCheckBox;
    private Button generateButton;
    private Slider slider;

    private void findButtons() {
        passwordTextView = findViewById(R.id.resultField);
        bigLetterCheckBox = findViewById(R.id.bigLetterCheckBox);
        generateButton = findViewById(R.id.generateButton);
        digitalCheckBox = findViewById(R.id.digitalCheckBox);
        specialSignsCheckBox = findViewById(R.id.specialSignsCheckBox);

        slider = findViewById(R.id.passwordLengthSlider);
        slider.addOnChangeListener((slider, value, fromUser) -> {
            selectedSliderValue = (Math.round(value));
            System.out.println(selectedSliderValue + " - wartosc slidera");
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findButtons();

        Log.w("main", generateButton + "");
        EdgeToEdge.enable(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Obsługa kliknięcia przycisku
        generateButton.setOnClickListener(v -> {
            String generatedPassword = generatePassword(12, true, true, true);
            passwordTextView.setText(generatedPassword);
        });

        RetrofitClient retrofitClient = new RetrofitClient();


/*        // Przygotowanie danych do wysłania
        PasswordRequest passwordRequest = new PasswordRequest("examplePassword");

        // Wykonanie zapytania POST
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<Void> call = apiService.createPassword(passwordRequest);

        // Wykonanie asynchronicznego zapytania
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Sukces - możesz zrobić coś z odpowiedzią
                    Log.d("Retrofit", "Password created successfully!");
                } else {
                    // Błąd w odpowiedzi
                    Log.e("Retrofit", "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Błąd połączenia
                Log.e("Retrofit", "Failure: " + t.getMessage());
            }
        });
 */

    }

    private String generatePassword(int length, boolean includeUppercase, boolean includeNumbers, boolean includeSymbols) {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        boolean bigLetterValue = bigLetterCheckBox.isChecked();
        boolean digitalValue = digitalCheckBox.isChecked();
        boolean specialSignsValue = specialSignsCheckBox.isChecked();


        for (int i = 0; i < 1; i++) {
            System.out.println("Big letter Value: " + bigLetterValue);
            System.out.println("Big letter Value: " + digitalValue);
            System.out.println("Big letter Value: " + specialSignsValue);
            System.out.println(selectedSliderValue + " - wartosc slidera");
        }

        String charPool = lowerCase; // Domyślnie tylko małe litery
        if (includeUppercase) charPool += upperCase;
        if (includeNumbers) charPool += numbers;
        if (includeSymbols) charPool += symbols;

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * charPool.length());
            password.append(charPool.charAt(index));
        }
        return password.toString();
    }
}