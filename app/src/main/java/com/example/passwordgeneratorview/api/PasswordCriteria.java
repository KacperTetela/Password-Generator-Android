package com.example.passwordgeneratorview.api;

public class PasswordCriteria {

    private boolean includeSymbols;
    private boolean includeUppercase;
    private boolean includeNumbers;
    private int length;

    private PasswordCriteria(int length, boolean includeNumbers, boolean includeUppercase, boolean includeSymbols) {
        this.length = length;
        this.includeNumbers = includeNumbers;
        this.includeUppercase = includeUppercase;
        this.includeSymbols = includeSymbols;
    }

    public int getLength() {
        return length;
    }

    public boolean isIncludeNumbers() {
        return includeNumbers;
    }

    public boolean isIncludeUppercase() {
        return includeUppercase;
    }

    public boolean isIncludeSymbols() {
        return includeSymbols;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private boolean includeSymbols;
        private boolean includeUppercase;
        private boolean includeNumbers;
        private int length;
        public Builder length(int length) {
            this.length = length;
            return this;
        }
        public Builder uppercase(boolean includeUppercase) {
            this.includeUppercase = includeUppercase;
            return this;
        }
        public Builder digits(boolean includeNumbers) {
            this.includeNumbers = includeNumbers;
            return this;
        }
        public Builder special(boolean includeSymbols) {
            this.includeSymbols = includeSymbols;
            return this;
        }
        public PasswordCriteria build() {
            return new PasswordCriteria(length, includeNumbers, includeUppercase, includeSymbols);
        }
    }
}
