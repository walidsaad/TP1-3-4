package com.example.walid.tp1_3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    ListView list;
   // @Override
    //Question 1
   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] contacts = new String[]{
                "Etudiant 1", "Etudiant 2", "Etudiant 3", "Etudiant 4", "Etudiant 5", "Etudiant 6",
                "Etudiant 7"};
        list = (ListView) findViewById(R.id.mylist);
        ArrayAdapter<String> tableau = new ArrayAdapter<String>(list.getContext(),
                android.R.layout.simple_list_item_1, contacts);
        list.setAdapter(tableau);
    }*/
    //Question 2
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.mylist);
        ArrayAdapter<String> tableau = new ArrayAdapter<String>(list.getContext(),
                android.R.layout.simple_list_item_1);
        for (int i=1; i<=20; i++) {
            tableau.add("Etudiant " + i); }
        list.setAdapter(tableau);
    }*/
    //Question 3
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView)findViewById(R.id.mylist);
        ArrayAdapter<String> tableau = new ArrayAdapter<String>(list.getContext(),
                R.layout.etudiantinfo,R.id.nom);
        for (int i=1; i<=50; i++) {
            tableau.add("Etudiant " + i); }
        list.setAdapter(tableau);
        list.setOnItemClickListener(this);
    }*/
    //Question 4
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView)findViewById(R.id.mylist);
        ArrayAdapter<String> tableau = new ArrayAdapter<String>(list.getContext(),
                R.layout.etudiantinfo,R.id.nom);
        for (int i=1; i<=50; i++) {
            tableau.add("Etudiant " + i); }
        list.setAdapter(tableau);
        list.setOnItemClickListener(this);
    }*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String element = (String)parent.getItemAtPosition(position);
        Toast.makeText(this,element, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.mylist);
       // List<Etudiant> etudiants = genererEtudiants();
        List<Etudiant> etudiants =new ArrayList<Etudiant>();
        EtudiantAdapter adapter = new EtudiantAdapter(MainActivity.this, etudiants);
        list.setAdapter(adapter);
        adapter.add(new Etudiant("GLID","Etudiant 1", "nom.prenom@gmail.com",1));
        adapter.add(new Etudiant("SRS", "Etudiant 2", "nom.prenom@gmail.com",2));
        adapter.add(new Etudiant("SRS", "Etudiant 3", "nom.prenom@gmail.com",0));
        adapter.add(new Etudiant("GLID", "Etudiant 4", "nom.prenom@gmail.com",4));
        adapter.add(new Etudiant("SRS", "Etudiant 5", "nom.prenom@gmail.com",0));
    }

   /* private List<Etudiant> genererEtudiants(){
        List<Etudiant> etudiants = new ArrayList<Etudiant>();
        etudiants.add(new Etudiant("GLID","Etudiant 1", "nom.prenom@gmail.com",1));
        etudiants.add(new Etudiant("SRS", "Etudiant 2", "nom.prenom@gmail.com",2));
        etudiants.add(new Etudiant("SRS", "Etudiant 3", "nom.prenom@gmail.com",0));
        etudiants.add(new Etudiant("GLID", "Etudiant 4", "nom.prenom@gmail.com",4));
        etudiants.add(new Etudiant("SRS", "Etudiant 5", "nom.prenom@gmail.com",0));
        return etudiants;
    }*/
}
