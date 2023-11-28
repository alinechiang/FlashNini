package com.example.flashnini;

import android.provider.BaseColumns;

public final class FlashcardContract {

    private FlashcardContract() {}

    public static class FlashcardEntry implements BaseColumns {
        public static final String TABLE_NAME = "flashcards";
        public static final String COLUMN_FRONT_TEXT = "front";
        public static final String COLUMN_BACK_TEXT = "back";
    }
}
