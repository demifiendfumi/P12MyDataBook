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


/**
 * A simple {@link Fragment} subclass.
 */
public class AnniversaryFragment extends Fragment {

    SharedPreferences sharedpreferences;
    String anniversary;
    TextView txtAnni;

    public AnniversaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_anniversary, container, false);
        txtAnni = v.findViewById(R.id.txtAnni);
        final LinearLayout editAnni =
                (LinearLayout) inflater.inflate(R.layout.edit_anniversary, null);
        final EditText etAnni = (EditText) editAnni
                .findViewById(R.id.etBio);
        Button btnEditAnni = v.findViewById(R.id. btnFragAnni);
        btnEditAnni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Enter Anniversary")
                        .setView(editAnni)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                txtAnni.setText(etAnni.getText().toString());
                                anniversary = etAnni.getText().toString();
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
        return v;
    }

    @Override
    public void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("anniversary", anniversary);
        editor.commit();
    }

    @Override
    public void onResume(){
        super.onResume();
        sharedpreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        anniversary = sharedpreferences.getString("anniversary", "");
        txtAnni.setText(anniversary);
    }
}
