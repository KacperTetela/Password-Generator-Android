package com.example.passwordgeneratorview.api;

public class SoundLikePasswordRequest {

    private String strategy;
    private boolean special;
    private boolean uppercase;
    private boolean digits;
    private int length;
    private String relatedWord;

    public SoundLikePasswordRequest(String strategy, boolean special, boolean uppercase, boolean digits, int length, String relatedWord) {
        this.strategy = strategy;
        this.special = special;
        this.uppercase = uppercase;
        this.digits = digits;
        this.length = length;
        this.relatedWord = relatedWord;
    }

    public SoundLikePasswordRequest() {
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isDigits() {
        return digits;
    }

    public void setDigits(boolean digits) {
        this.digits = digits;
    }

    public boolean isUppercase() {
        return uppercase;
    }

    public void setUppercase(boolean uppercase) {
        this.uppercase = uppercase;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public String getRelatedWord() {
        return relatedWord;
    }

    public void setRelatedWord(String relatedWord) {
        this.relatedWord = relatedWord;
    }
}
