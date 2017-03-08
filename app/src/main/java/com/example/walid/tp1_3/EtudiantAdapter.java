package com.example.walid.tp1_3;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by walid on 18/02/2017.
 */

public class EtudiantAdapter extends ArrayAdapter<Etudiant> {
    //etudiants est la liste des models à afficher
    public EtudiantAdapter(Context context, List<Etudiant> etudiants) {
        super(context, 0, etudiants);
    }
    @Override
    //convertView est notre vue recyclée
    public View getView(int position, View convertView, ViewGroup parent) {
/*Android nous fournit un convertView null lorsqu'il nous demande de la créer
dans le cas contraire, cela veux dire qu'il nous fournit une vue recyclée*/
        if(convertView == null){
            /* on récupérons notre gabarit etudiantinfo2 via un LayoutInflater,
            qui va charger un layout xml dans un objet View*/
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.etudiantinfo2,parent, false);
        }
        //comme nos vues sont réutilisées, notre convertView possède déjà un ViewHolder
        EtudiantViewHolder viewHolder = (EtudiantViewHolder) convertView.getTag();
        if(viewHolder == null){
            //si elle n'avait pas encore de ViewHolder
            viewHolder = new EtudiantViewHolder();
            //récupérer nos sous vues
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.email = (TextView) convertView.findViewById(R.id.email);
            viewHolder.option = (TextView) convertView.findViewById(R.id.option);
            viewHolder.abs = (TextView) convertView.findViewById(R.id.nbabs);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            //puis on sauvegarde le mini-controlleur dans la vue
            convertView.setTag(viewHolder);
        }
        //getItem(position) va récupérer l'item [position] de la List<Etudiant> etudiants
        Etudiant etudiant = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nom.setText(etudiant.getNom());
        viewHolder.email.setText(etudiant.getEmail());
        viewHolder.option.setText(etudiant.getOption());
        viewHolder.abs.setText(""+etudiant.getAbs());
        //viewHolder.avatar.setImageDrawable(new ColorDrawable(etudiant.getOption()));
        //viewHolder.avatar.setImageBitmap(ImageManager.getBitmapFromResources(R.drawable.avatar_loading));
        /*nous renvoyons notre vue à l'adapter, afin qu'il l'affiche
        et qu'il puisse la mettre à recycler lorsqu'elle sera sortie de l'écran*/
        return convertView;
    }

    private class EtudiantViewHolder{
        public TextView nom;
        public TextView email;
        public TextView option;
        public TextView abs;
        public ImageView avatar;
    }
}
