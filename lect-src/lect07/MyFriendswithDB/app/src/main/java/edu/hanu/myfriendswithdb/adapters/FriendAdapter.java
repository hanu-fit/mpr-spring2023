package edu.hanu.myfriendswithdb.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.myfriendswithdb.R;
import edu.hanu.myfriendswithdb.models.Friend;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendHolder> {
    private List<Friend> friends;

    public FriendAdapter(List<Friend> friends) {
        this.friends = friends;
    }

    @Override
    public int getItemCount() {
        return this.friends.size();
    }


    @NonNull
    @Override
    public FriendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_friend, parent, false);

        return new FriendHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendHolder holder, int position) {
        Friend friend = this.friends.get(position);

        holder.bind(friend);
    }

    public class FriendHolder extends RecyclerView.ViewHolder {

        public FriendHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Friend friend) {
            TextView tvName = itemView.findViewById(R.id.tvName);
            tvName.setText(friend.getName());

            // send email
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:"+Uri.encode(friend.getEmail())));

            // send sms
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            smsIntent.setData(Uri.parse("smsto:"+Uri.encode(friend.getEmail())));

            // call
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:"+Uri.parse(friend.getPhoneNo())));

            // delete
            ImageButton imbDelete = itemView.findViewById(R.id.imbDelete);
            imbDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    friends.remove(friend);
//                    notifyDataSetChanged();

                    int index = friends.indexOf(friend);
                    friends.remove(index);
                    notifyItemRemoved(index);
                }
            });
        }
    }
}
