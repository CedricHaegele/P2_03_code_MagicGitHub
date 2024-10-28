package com.openclassrooms.magicgithub.ui.user_list;

import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.openclassrooms.magicgithub.base.BaseActivity;
import com.openclassrooms.magicgithub.R;
import com.openclassrooms.magicgithub.model.User;
import com.openclassrooms.magicgithub.databinding.ActivityListUserBinding;

public class ListUserActivity extends BaseActivity implements UserListAdapter.Listener {

    // ViewBinding au lieu de Butterknife
    private ActivityListUserBinding binding;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    private UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialisation du ViewBinding
        binding = ActivityListUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        // Récupération des vues
        recyclerView = binding.activityListUserRv;
        fab = binding.activityListUserFab;
        
        configureFab();
        configureRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void configureRecyclerView() {
        adapter = new UserListAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    private void configureFab() {
        fab.setOnClickListener(view -> {
            getUserRepository().generateRandomUser();
            loadData();
        });
    }

    private void loadData() {
        adapter.updateList(getUserRepository().getUsers());
    }

    @Override
    public void onClickDelete(User user) {
        Log.d(ListUserActivity.class.getName(), "User tries to delete an item.");
        getUserRepository().deleteUser(user);
        loadData();
    }
}
