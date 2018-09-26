package com.example.exploringroomandroid;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class GetDataAsyc {

    private static final String TAG = GetDataAsyc.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Person addUser(final AppDatabase db, Person user) {
        db.personDao().insertAll(user);
        return user;
    }

    private static void populateWithTestData(AppDatabase db) {
        Person user = new Person();
        user.setName("Jekson");
        user.setEmail("jek@test.com");
        user.setAge(28);
        addUser(db, user);

        List<Person> userList = db.personDao().getAll();
        Log.d(GetDataAsyc.TAG, "Rows Count: " +db.personDao().countUsers());

        for(int i=0;i<userList.size();i++)
        {
            Log.d(GetDataAsyc.TAG, "Rows Name: " + userList.get(i).getName());

        }
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}