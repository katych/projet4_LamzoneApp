package com.example.mareu.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mareu.R;
import com.example.mareu.model.Room;
import java.util.List;

public class AdapterSpinner extends ArrayAdapter <Room> {


    public AdapterSpinner(@NonNull Context context, @NonNull List<Room> mRoomsList) {
        super(context, 0, mRoomsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }


    public View initView (int position , View convertView , ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_row, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.image_room);
        TextView textView = convertView.findViewById(R.id.name_room);
        Room mRoomList = getItem(position);

        if(mRoomList != null) {
            imageView.setImageResource(mRoomList.getmRoomColor());
            textView.setText(mRoomList.getmNameRoom());
        }
        return convertView;

    }
}

