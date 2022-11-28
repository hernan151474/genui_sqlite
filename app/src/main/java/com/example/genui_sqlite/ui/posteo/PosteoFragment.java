package com.example.genui_sqlite.ui.posteo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genui_sqlite.AdapterPosteo;
import com.example.genui_sqlite.AdapterRecord;
import com.example.genui_sqlite.ComercioActivity;
import com.example.genui_sqlite.Constants;
import com.example.genui_sqlite.DB.MyDbHelper;
import com.example.genui_sqlite.Home;
import com.example.genui_sqlite.OficioActivity;
import com.example.genui_sqlite.R;
import com.example.genui_sqlite.databinding.FragmentPosteoBinding;
import android.os.Bundle;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PosteoFragment extends Fragment  {

    private FragmentPosteoBinding binding;
    private RecyclerView posteo;
    private ImageButton borrar;

    TextView count;
    int consulta;
    int cantidad=0;


    private MyDbHelper dbHelper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Home activity = (Home) getActivity();
        consulta = activity.getDataFragment();

        binding = FragmentPosteoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        root= inflater.inflate(R.layout.fragment_posteo, container, false);
        posteo = (RecyclerView) root.findViewById(R.id.posteo);
        posteo.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        posteo.setLayoutManager(manager);


        dbHelper = new MyDbHelper(getActivity());
        loadRecords();

        PosteoViewModel posteoViewModel =
                new ViewModelProvider(this).get(PosteoViewModel.class);
        return root;
    }

    private void loadRecords() {
        dbHelper = new MyDbHelper(getActivity());

        AdapterPosteo adapterRecord = new AdapterPosteo(getActivity(),
                dbHelper.getAllPosteo(consulta));

        posteo.setAdapter(adapterRecord);

        //Establecer el numero de Registros
        cantidad=dbHelper.getRecordsCountPosteo(consulta);
        //count.setText(String.valueOf(cantidad));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

        //view =  inflater.inflate(R.layout.fragment_posteo, container, false);
        //posteo = (RecyclerView) getActivity().findViewById(R.id.posteo);
        //GridLayoutManager columna = new GridLayoutManager(getActivity(), 2,0,false);
        //posteo.setLayoutManager(columna);
        //if (posteo != null){
        //int numberOfColumns = 2;
        //posteo.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        //}

//super.onCreateView( inflater, container, savedInstanceState);
  //      view =  inflater.inflate(R.layout.fragment_posteo, container, false);
    //    RecyclerView posteo = (RecyclerView) getActivity().findViewById(R.id.posteo);
      //  posteo.setHasFixedSize(true);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());

  //      llm.setOrientation(LinearLayoutManager.VERTICAL);
//        posteo.setLayoutManager(llm);


    //    //Inicializamos db helper Clase
      //  dbHelper = new MyDbHelper(getActivity());

        //loadRecords();

