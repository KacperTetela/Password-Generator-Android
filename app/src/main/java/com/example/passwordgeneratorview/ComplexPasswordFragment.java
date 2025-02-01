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

import com.example.passwordgeneratorview.api.ApiService;
import com.example.passwordgeneratorview.api.PasswordRequest;
import com.example.passwordgeneratorview.api.RetrofitClient;
import com.google.android.material.slider.Slider;

import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ComplexPasswordFragment extends Fragment {

    private int selectedSliderValue = 8;
    private TextView passwordTextView;
    private CheckBox bigLetterCheckBox;
    private CheckBox digitalCheckBox;
    private CheckBox specialSignsCheckBox;
    private Button generateButton;
    private Slider slider;

    public ComplexPasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_complex_password, container, false);
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
            // Zbieramy dane z checkboxów
            boolean includeUppercase = bigLetterCheckBox.isChecked();
            boolean includeNumbers = digitalCheckBox.isChecked();
            boolean includeSymbols = specialSignsCheckBox.isChecked();

            downloadData().thenAccept(data -> {
                // Przetwarzanie danych po otrzymaniu odpowiedzi
                passwordTextView.setText(data);
                System.out.println("Dane: " + data);
            }).exceptionally(throwable -> {
                // Obsługa błędów
                System.out.println("Błąd: " + throwable.getMessage());
                return null;
            });

        });
    }

    public CompletableFuture<String> downloadData() {
        PasswordRequest passwordRequest = new PasswordRequest("COMPLEX", true, true, true, 8);

        CompletableFuture<String> futureData = new CompletableFuture<>();

        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<String> call = apiService.createPassword(passwordRequest);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String data = response.body();
                    futureData.complete(data);  // Zakończenie i przekazanie danych do CompletableFuture
                } else {
                    futureData.completeExceptionally(new Exception("Error: " + response.code()));  // Zakończenie z błędem
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                futureData.completeExceptionally(t);  // Zakończenie z błędem
            }
        });

        return futureData;
    }

/*    private String generatePassword(int length, boolean includeUppercase, boolean includeNumbers, boolean includeSymbols) {
        StringBuilder password = new StringBuilder();


        boolean bigLetterValue = bigLetterCheckBox.isChecked();
        boolean digitalValue = digitalCheckBox.isChecked();
        boolean specialSignsValue = specialSignsCheckBox.isChecked();


        for (int i = 0; i < 1; i++) {
            System.out.println("Big letter Value: " + bigLetterValue);
            System.out.println("Big letter Value: " + digitalValue);
            System.out.println("Big letter Value: " + specialSignsValue);
            System.out.println(selectedSliderValue + " - wartosc slidera");
        }

        // Tworzymy instancję APIBuilder i przekazujemy callback
        APIBuilder apiBuilder = new APIBuilder(getContext());
        apiBuilder.build(selectedSliderValue, includeUppercase, includeNumbers, includeSymbols, this);

        return password.toString();
    }*/

}