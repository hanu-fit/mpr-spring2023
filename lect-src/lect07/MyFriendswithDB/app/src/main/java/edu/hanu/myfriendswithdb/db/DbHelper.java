package edu.hanu.myfriendswithdb.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// if db not exist
    // create tables for 1st run
// else
    // check db version if != app db version
        // update databases (create new tables, alter existing tables)
public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "friends.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create tables for 1st run
        db.execSQL("CREATE TABLE friends (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "email TEXT, " +
                "phoneNo TEXT)");

        // add some demo data
        db.execSQL("INSERT INTO friends (name, email, phoneNo) " +
                "VALUES ('Cong Nguyen', 'congnv@hanu.edu.vn', '0358877210')");
        db.execSQL("INSERT INTO friends (name, email, phoneNo) " +
                "VALUES ('Dennis Nguyen', 'congnv@hanu.edu.vn', '0358877210')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // update databases (create new tables, alter existing tables)

        // drop old table
        db.execSQL("DROP TABLE IF EXISTS friends");

        // create tables again
        onCreate(db);
    }
}
