package com.example.genui_sqlite.ui.posteo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genui_sqlite.DB.MyDbHelper;
import com.example.genui_sqlite.R;
import com.example.genui_sqlite.databinding.FragmentPosteoBinding;

public class PosteoFragment extends Fragment {

    private FragmentPosteoBinding binding;
    private RecyclerView posteo;
    TextView count;

    private MyDbHelper dbHelper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PosteoViewModel posteoViewModel =
                new ViewModelProvider(this).get(PosteoViewModel.class);

        binding = FragmentPosteoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
