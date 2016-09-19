package org.brenomachado.cyberspeteria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProdutosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProdutosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ArrayList<Produto> listaBebidas;

    private ArrayList<Produto> listaProdutos;

    public ProdutosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProdutosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProdutosFragment newInstance(String param1, String param2) {
        ProdutosFragment fragment = new ProdutosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        listaBebidas = new ArrayList<Produto>() {{
            add(new Produto("Água com Gás", 4.0));
            add(new Produto("Água", 3.5));
            add(new Produto("Brahma", 8.0));
            add(new Produto("Skol", 8.0));
            add(new Produto("Original", 10.0));
            add(new Produto("Budweiser", 9.0));
            add(new Produto("Heineken", 9.0));
        }};

        listaProdutos = new ArrayList<Produto>() {{
            add(new Produto("Alcatra", 6));
            add(new Produto("Contra-File", 6));
            add(new Produto("Picanha", 8));
            add(new Produto("Filé-Mignon", 8));
            add(new Produto("Medalhão de Porco", 6));
            add(new Produto("Medalhão de Boi", 6));
            add(new Produto("Medalhão de Frango", 6));
            add(new Produto("Frango", 6));
            add(new Produto("Cafta", 6));
        }};

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_produtos, container, false);

        ProdutoAdapter bebidasAdapter = new ProdutoAdapter(getActivity(),
                R.layout.produto_checkbox,
                listaBebidas);

        ListView bebidasView = (ListView) v.findViewById(R.id.list_bebidas);

        bebidasView.setAdapter(bebidasAdapter);

        ProdutoAdapter produtoAdapter = new ProdutoAdapter(
            getActivity(),
            R.layout.produto_checkbox,
            listaProdutos);

        ListView produtoView = (ListView) v.findViewById(R.id.list_produtos);

        produtoView.setAdapter(produtoAdapter);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
