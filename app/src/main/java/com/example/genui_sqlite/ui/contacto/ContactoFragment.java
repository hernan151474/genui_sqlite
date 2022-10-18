package com.example.genui_sqlite.ui.contacto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.genui_sqlite.databinding.FragmentContactoBinding;
import com.example.genui_sqlite.ui.contacto.ContactoViewModel;


public class ContactoFragment extends Fragment {

    private FragmentContactoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContactoViewModel contactoViewModel =
                new ViewModelProvider(this).get(ContactoViewModel.class);

        binding = FragmentContactoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}