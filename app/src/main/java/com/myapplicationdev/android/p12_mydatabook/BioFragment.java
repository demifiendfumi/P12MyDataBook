package com.myapplicationdev.android.p12_mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    SharedPreferences sharedpreferences;
    String info = "";
    TextView txBio;

    public BioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_bio, container, false);
       txBio = rootView.findViewById(R.id.tvBioAns);
       final LinearLayout editBio =
                (LinearLayout) inflater.inflate(R.layout.edit_bio, null);
        final EditText etBio = (EditText) editBio
                .findViewById(R.id.etBio);
        Button btnEditBio = rootView.findViewById(R.id. btnBioEdit);

        btnEditBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Enter Bio")
                        .setView(editBio)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                txBio.setText(etBio.getText().toString());
                                info = etBio.getText().toString();
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return rootView;
    }

    @Override
    public void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("info", info);
        editor.commit();
    }

    @Override
    public void onResume(){
        super.onResume();
        sharedpreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        info = sharedpreferences.getString("info", "");
        txBio.setText(info);
    }

}
