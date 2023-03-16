package edu.hanu.myfriendswithdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.myfriendswithdb.adapters.FriendAdapter;
import edu.hanu.myfriendswithdb.models.Friend;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dataset
        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Cong Nguyen", "0358877210", "congnv@hanu.edu.vn"));
        friends.add(new Friend("Dennis Nguyen", "0358877210", "congnv@hanu.edu.vn"));
        friends.add(new Friend("Little Bee", "0358877210", "congnv@hanu.edu.vn"));
        friends.add(new Friend("Shinichi_92", "0358877210", "congnv@hanu.edu.vn"));

        // recycler view
        RecyclerView rvFriends = findViewById(R.id.rvFriends);
        // how recycler view layout items inside
        rvFriends.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // bridge dataset -> textview = adapter
        FriendAdapter friendAdapter = new FriendAdapter(friends);
        rvFriends.setAdapter(friendAdapter);

        // new friend
        ImageButton imbAddFriend = findViewById(R.id.imbAddFriend);
        imbAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddFriendActivity.class);
                startActivity(intent);
            }
        });

    }
}