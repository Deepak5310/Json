package com.deedeveloper.json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {

    Datum[] data;
    Context context;

    public MyAdapter(Datum[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row, parent, false);
        return new myViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, int position) {

        final Datum datum = data[position];
        holder.textView.setText(datum.getName());
        Glide.with(holder.imageView.getContext()).load(datum.getImage()).into(holder.imageView);

        //RecyclerView onClick listener
        switch (position){
            case 0:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Image one is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
            case 1:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Image two is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
            break;
        }


//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,MainActivity2.class);
//                intent.putExtra("Name",datum.getName());
//                intent.putExtra("Image",datum.getImage());
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.single_row_image);
            textView = itemView.findViewById(R.id.single_row_text);
        }
    }
}
