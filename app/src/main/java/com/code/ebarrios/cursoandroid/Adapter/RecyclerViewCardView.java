package com.code.ebarrios.cursoandroid.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.code.ebarrios.cursoandroid.Models.Picture;
import com.code.ebarrios.cursoandroid.R;
import com.code.ebarrios.cursoandroid.View.PictureDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ebarrios on 12/05/2017.
 */

public class RecyclerViewCardView extends RecyclerView.Adapter<RecyclerViewCardView.CardViewHolder>{

    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public RecyclerViewCardView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Picture picture = pictures.get(position);
        holder.userNameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.numeroLikes.setText(picture.getNumeroLikes());

        // uso de la libreria picasso par alas imagenes en internet
        Picasso.with(activity).load(picture.getPicture()).into(holder.cardView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailsActivity.class);

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity,view,activity.getString(R.string.transitionNamePicture)).toBundle());
                }
                else {
                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        private ImageView cardView;
        private TextView userNameCard;
        private TextView timeCard;
        private TextView numeroLikes;

        public CardViewHolder(View itemView) {
            super(itemView);

            cardView = (ImageView)itemView.findViewById(R.id.fotoCard);
            userNameCard = (TextView)itemView.findViewById(R.id.userNameCard);
            timeCard = (TextView)itemView.findViewById(R.id.timeCard);
            numeroLikes = (TextView)itemView.findViewById(R.id.numeroLikesCard);

        }
    }
}
