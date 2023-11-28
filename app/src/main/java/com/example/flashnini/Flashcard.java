package com.example.flashnini;

public class Flashcard {
    private String frontText;
    private String backText;

    // Constructor
    public Flashcard(String frontText, String backText) {
        this.frontText = frontText;
        this.backText = backText;
    }

    // Getter and setter for frontText
    public String getFrontText() {
        return frontText;
    }

    public void setFrontText(String frontText) {
        this.frontText = frontText;
    }

    // Getter and setter for backText
    public String getBackText() {
        return backText;
    }

    public void setBackText(String backText) {
        this.backText = backText;
    }

    // Optional: Override toString() for easy debugging
    @Override
    public String toString() {
        return "Flashcard{" +
                "frontText='" + frontText + '\'' +
                ", backText='" + backText + '\'' +
                '}';
    }
}

