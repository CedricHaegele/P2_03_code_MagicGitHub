package com.openclassrooms.magicgithub.ui.user_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.openclassrooms.magicgithub.R;
import com.openclassrooms.magicgithub.model.User;
import com.openclassrooms.magicgithub.utils.UserDiffCallback;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<ListUserViewHolder> {

    // FOR DATA ---
    private List<User> users = new ArrayList<>();

    // FOR CALLBACK ---
    private final Listener callback;
    public interface Listener {
        void onClickDelete(User user);
    }

    public UserListAdapter(Listener callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public ListUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list_user, parent, false);
        return new ListUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserViewHolder holder, int position) {
        User user = users.get(position);
        
        // Ajout de logs pour déboguer
        Log.d("UserListAdapter", "Loading image for user: " + user.getLogin());
        Log.d("UserListAdapter", "Avatar URL: " + user.getAvatarUrl());
        
        RequestOptions requestOptions = new RequestOptions()
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background);

        Glide.with(holder.itemView.getContext())
            .load(user.getAvatarUrl())
            .apply(requestOptions)
            .listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    Log.e("UserListAdapter", "Error loading image: " + e.getMessage());
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    Log.d("UserListAdapter", "Image loaded successfully");
                    return false;
                }
            })
            .into(holder.avatar);
        
        holder.bind(user, callback);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    // PUBLIC API ---

    public void updateList(List<User> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new UserDiffCallback(newList, this.users));
        this.users = new ArrayList<>(newList);
        diffResult.dispatchUpdatesTo(this);
    }
}
