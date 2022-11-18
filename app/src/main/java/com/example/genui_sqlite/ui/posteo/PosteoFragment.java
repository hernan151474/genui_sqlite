package com.example.genui_sqlite.ui.posteo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genui_sqlite.AdapterPosteo;
import com.example.genui_sqlite.AdapterRecord;
import com.example.genui_sqlite.ComercioActivity;
import com.example.genui_sqlite.Constants;
import com.example.genui_sqlite.DB.MyDbHelper;
import com.example.genui_sqlite.Home;
import com.example.genui_sqlite.R;
import com.example.genui_sqlite.databinding.FragmentPosteoBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PosteoFragment extends Fragment {

    private FragmentPosteoBinding binding;
    private RecyclerView posteo;

    TextView count;
    int consulta;





    private MyDbHelper dbHelper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView( inflater, container, savedInstanceState);
<<<<<<< HEAD

        View view =  inflater.inflate(R.layout.fragment_posteo, container, false);
        posteo = (RecyclerView) view.findViewById(R.id.posteo);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        posteo.setLayoutManager(gridLayoutManager);
        //Inicializamos db helper Clase
        dbHelper = new MyDbHelper(getActivity());

        loadRecords();
=======
        posteo = (RecyclerView) getActivity().findViewById(R.id.posteo);
        int numberOfColumns = 2;

         //posteo.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        //Inicializamos db helper Clase
        dbHelper = new MyDbHelper(getActivity());

>>>>>>> da8920a217db549f146a0de8119e32d0dd79be38

        PosteoViewModel posteoViewModel =
                new ViewModelProvider(this).get(PosteoViewModel.class);

        binding = FragmentPosteoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

<<<<<<< HEAD
    private void loadRecords(){
        dbHelper = new MyDbHelper(getActivity());
        int consulta = dbHelper.ConsultaUser();
        int id_user = consulta;
        String estado= String.valueOf(1);
        AdapterPosteo adapterPosteo = new AdapterPosteo(getActivity(), dbHelper.getAllPosteo(String.valueOf(id_user),estado));
        posteo.setAdapter(adapterPosteo);
    }

=======
>>>>>>> da8920a217db549f146a0de8119e32d0dd79be38
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
