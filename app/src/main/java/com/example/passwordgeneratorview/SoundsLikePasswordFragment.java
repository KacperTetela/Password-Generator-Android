package com.example.passwordgeneratorview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.slider.Slider;


public class SoundsLikePasswordFragment extends Fragment {

    private int selectedSliderValue = 8;
    private TextView passwordTextView;
    private CheckBox bigLetterCheckBox;
    private CheckBox digitalCheckBox;
    private CheckBox specialSignsCheckBox;
    private Button generateButton;
    private Slider slider;

    public SoundsLikePasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sounds_like_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Znajdź elementy widoku
        passwordTextView = view.findViewById(R.id.resultField);
        bigLetterCheckBox = view.findViewById(R.id.bigLetterCheckBox);
        generateButton = view.findViewById(R.id.generateButton);
        digitalCheckBox = view.findViewById(R.id.digitalCheckBox);
        specialSignsCheckBox = view.findViewById(R.id.specialSignsCheckBox);
        slider = view.findViewById(R.id.passwordLengthSlider);

        // Logika dla slidera
        slider.addOnChangeListener((slider, value, fromUser) -> {
            selectedSliderValue = Math.round(value); // Możesz usunąć Math.round, jeśli nie chcesz zaokrąglania
            System.out.println(selectedSliderValue + " - wartość slidera");
        });

        // Obsługa przycisku generowania hasła
        generateButton.setOnClickListener(v -> {
            String generatedPassword = generatePassword(selectedSliderValue, bigLetterCheckBox.isChecked(),
                    digitalCheckBox.isChecked(), specialSignsCheckBox.isChecked());
            passwordTextView.setText(generatedPassword);
        });
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