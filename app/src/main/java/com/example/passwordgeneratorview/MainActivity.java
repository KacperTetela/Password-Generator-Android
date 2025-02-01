package com.example.passwordgeneratorview;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the default fragment (HomeFragment)
        loadFragment(new ComplexPasswordFragment());

        // Set up buttons for fragment switching
        Button complexPassword = findViewById(R.id.complexPassword);
        Button simplePassword = findViewById(R.id.simplePassword);
        Button soundsLikePassword = findViewById(R.id.soundsLikePassword);
        Button passwordHistory = findViewById(R.id.passwordHistory);

        complexPassword.setOnClickListener(v -> loadFragment(new ComplexPasswordFragment()));
        simplePassword.setOnClickListener(v -> loadFragment(new SimplePasswordFragment()));
        soundsLikePassword.setOnClickListener(v -> loadFragment(new SoundsLikePasswordFragment()));
        passwordHistory.setOnClickListener(v -> loadFragment(new PasswordHistory()));
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

}
