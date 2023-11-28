package com.example.flashnini;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class FlashcardDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "flashcard.db";
    private static final int DATABASE_VERSION = 1;

    // Table and columns
    private static final String TABLE_NAME = "flashcards";
    private static final String COLUMN_ID = "_id";
    public static final String COLUMN_FRONT = "front";
    public static final String COLUMN_BACK = "back";

    public FlashcardDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_FLASHCARDS_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FRONT + " TEXT NOT NULL, " +
                COLUMN_BACK + " TEXT NOT NULL" +
                ");";

        db.execSQL(SQL_CREATE_FLASHCARDS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to add a new flashcard
    public long addFlashcard(Flashcard flashcard) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FRONT, flashcard.getFrontText());
        values.put(COLUMN_BACK, flashcard.getBackText());

        return db.insert(TABLE_NAME, null, values);
    }

    // Method to fetch all flashcards
    public Cursor getAllFlashcards() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }

    // Method to update a flashcard
    public int updateFlashcard(long id, Flashcard flashcard) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FRONT, flashcard.getFrontText());
        values.put(COLUMN_BACK, flashcard.getBackText());

        // Updating row
        return db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
    }

    // Method to delete a flashcard
    public void deleteFlashcard(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
    }
}

