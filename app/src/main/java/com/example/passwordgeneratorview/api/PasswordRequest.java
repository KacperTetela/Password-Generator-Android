package com.example.passwordgeneratorview.api;

public class PasswordRequest {
    private String strategy;
    private boolean special;
    private boolean uppercase;
    private boolean digits;
    private int length;

    // Konstruktor
    public PasswordRequest(String strategy, boolean special, boolean uppercase, boolean digits, int length) {
        this.strategy = strategy;
        this.special = special;
        this.uppercase = uppercase;
        this.digits = digits;
        this.length = length;
    }

    // Gettery i settery (opcjonalne, jeśli potrzebne)
}

