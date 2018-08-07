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
public class VaccinationFragment extends Fragment {

    SharedPreferences sharedPreferences;
    String vaccination;
    TextView txtVacc;


    public VaccinationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_vaccination, container, false);
        txtVacc = rootView.findViewById(R.id.txtFragVacc);
        final LinearLayout editVacc =
                (LinearLayout) inflater.inflate(R.layout.edit_vacc, null);
        final EditText etVacc = (EditText) editVacc
                .findViewById(R.id.etVacc);
        Button btnEditVacc = rootView.findViewById(R.id. btnFragVacc);

        btnEditVacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Enter Vaccination")
                        .setView(editVacc)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                txtVacc.setText(etVacc.getText().toString());
                                vaccination = etVacc.getText().toString();
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
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("vaccination", vaccination);
        editor.commit();
    }

    @Override
    public void onResume(){
        super.onResume();
        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        vaccination = sharedPreferences.getString("vaccination", "");
        txtVacc.setText(vaccination);
    }
}
