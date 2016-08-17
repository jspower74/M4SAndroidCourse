package com.example.js.firebasestudent;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button butVal1;
    private EditText etID,etname;
    private DatabaseReference rootRef;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        rootRef = FirebaseDatabase.getInstance().getReference();
        etname =(EditText) rootView.findViewById(R.id.editext);
        etID = (EditText) rootView.findViewById(R.id.etID);
        butVal1 = (Button) rootView.findViewById(R.id.butVal);

        butVal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id= etID.getText().toString().trim();
                String firstname = etname.getText().toString().trim();
                Student student = new Student(id, firstname);
                rootRef.push().setValue(student);
                Toast.makeText(getContext(), "Votre enregistrement a été effectué !", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}
