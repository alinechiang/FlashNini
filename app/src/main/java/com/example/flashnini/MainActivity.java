package com.example.flashnini;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.ListView;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity {

    private FlashcardDbHelper dbHelper;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = findViewById(R.id.list_view);
        dbHelper = new FlashcardDbHelper(this);

        // Load flashcards from database
        Cursor cursor = dbHelper.getAllFlashcards();
        adapter = new CustomListAdapter(this, cursor); // Modify adapter to use Cursor
        listView.setAdapter(adapter);

        // Other setup including ListView item click listeners
    }

    // Rest of MainActivity including showAddNewItemDialog and addNewFlashcard methods
}


