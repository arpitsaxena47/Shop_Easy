package com.arpit.shopeasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder> {

    private ArrayList<ContactsInfo> contactsInfoList;
    private Context context;
    private LayoutInflater mLayoutInflater;

    public MyCustomAdapter(@NonNull Context context, @NonNull ArrayList<ContactsInfo> objects) {
        super();
        this.contactsInfoList = objects;
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.activity_contact_item_view , parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String imgUrl = contactsInfoList.get(position).getImgUrl();
        String displayName = contactsInfoList.get(position).getDisplayName();
        String status = contactsInfoList.get(position).getStatus();
        String date = contactsInfoList.get(position).getDate();

        Picasso.get().load(imgUrl).into(holder.imgDisplayProfile);
        holder.displayName.setText(displayName);
        holder.status.setText(status);
        holder.date.setText(date);

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView displayName;
        TextView status;
        TextView date;
        CircleImageView imgDisplayProfile;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            displayName = (TextView) itemView.findViewById(R.id.personName);
            status = (TextView) itemView.findViewById(R.id.status);
            date = (TextView) itemView.findViewById(R.id.date);
            imgDisplayProfile = itemView.findViewById(R.id.photo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
