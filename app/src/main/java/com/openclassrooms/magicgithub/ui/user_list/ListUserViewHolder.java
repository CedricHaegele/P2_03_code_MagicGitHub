package com.openclassrooms.magicgithub.ui.user_list;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.openclassrooms.magicgithub.R;
import com.openclassrooms.magicgithub.model.User;

public class ListUserViewHolder extends RecyclerView.ViewHolder {

    // Déclaration des vues
    public ImageView avatar;
    private TextView username;
    private ImageButton deleteButton;

    public ListUserViewHolder(@NonNull View itemView) {
        super(itemView);
        // Initialisation des vues avec findViewById
        avatar = itemView.findViewById(R.id.item_list_user_avatar);
        username = itemView.findViewById(R.id.item_list_user_username);
        deleteButton = itemView.findViewById(R.id.item_list_user_delete_button);
    }

    public void bind(User user, UserListAdapter.Listener callback) {
        // Log pour déboguer
        Log.d("ListUserViewHolder", "Binding user: " + user.getLogin());
        Log.d("ListUserViewHolder", "Avatar URL: " + user.getAvatarUrl());

        // Chargement de l'image avec Glide et logs
        Glide.with(itemView.getContext())
                .load(user.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, 
                            Target<Drawable> target, boolean isFirstResource) {
                        Log.e("ListUserViewHolder", "Failed to load image for " + user.getLogin());
                        if (e != null) {
                            Log.e("ListUserViewHolder", "Error: " + e.getMessage());
                            for (Throwable t : e.getRootCauses()) {
                                Log.e("ListUserViewHolder", "Cause: " + t.getMessage());
                            }
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model,
                            Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Log.d("ListUserViewHolder", "Image loaded successfully for " + user.getLogin());
                        return false;
                    }
                })
                .into(avatar);
                
        username.setText(user.getLogin());
        deleteButton.setOnClickListener(view -> callback.onClickDelete(user));
    }
}
