package com.example.flashnini;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomListAdapter extends CursorAdapter {

    public CustomListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Extract properties from cursor
        String frontText = cursor.getString(cursor.getColumnIndexOrThrow(FlashcardDbHelper.COLUMN_FRONT));
        // ... get other fields ...

        // Populate fields in the item layout
        TextView textView = view.findViewById(R.id.text_view_title);
        textView.setText(frontText);
        // ... set other fields ...
    }
}

