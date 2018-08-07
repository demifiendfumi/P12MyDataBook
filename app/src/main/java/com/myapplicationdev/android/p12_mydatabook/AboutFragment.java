package com.myapplicationdev.android.p12_mydatabook;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    String photo_url = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        final TextView txtAbout = view.findViewById(R.id.tvAbout);
        ImageView img = view.findViewById(R.id.imageView);
        TextView txtCreated = view.findViewById(R.id.tvCreated);

//        final ProgressDialog progressDialog = new ProgressDialog(getContext());
//        progressDialog.setIcon(R.drawable.ajax_loader);
//        progressDialog.show();
        Log.d("url", photo_url);
        Picasso.with(getActivity()).load(photo_url).placeholder(R.drawable.ajax_loader).error(R.drawable.error).into(img);
        //progressDialog.dismiss();
        return view;
    }

}