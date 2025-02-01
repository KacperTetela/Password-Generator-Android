package com.example.passwordgeneratorview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PasswordHistory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PasswordHistory extends Fragment {

    public PasswordHistory() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Znajdź elementy widoku
        TextView textView = view.findViewById(R.id.textViewPasswordHistory);
        textView.setText("Welcome to PasswordViewHisotry");

        // Obsłuż inne elementy widoku (np. przyciski)*/
    }

}