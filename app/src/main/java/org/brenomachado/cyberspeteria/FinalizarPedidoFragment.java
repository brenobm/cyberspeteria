package org.brenomachado.cyberspeteria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FinalizarPedidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FinalizarPedidoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FinalizarPedidoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FinalizarPedidoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FinalizarPedidoFragment newInstance(String param1, String param2) {
        FinalizarPedidoFragment fragment = new FinalizarPedidoFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_finalizar_pedido, container, false);

        TextView textConta = (TextView)v.findViewById(R.id.descritivo_conta);

        textConta.setText("Qtd\t\t\tDescritivo\t\t\t\t\t\t\tValor\n" +
                "  1\t\t\t\tOriginal\t\t\t\t\t\t\tR$ 10,00\n" +
                "  3\t\t\t\tÁgua com Gás\t\t\tR$ 12,00\n" +
                "  1\t\t\t\tAlcatra\t\t\t\t\t\t\tR$  6,00\n" +
                "  1\t\t\t\tPicanha\t\t\t\t\t\t\tR$  8,00\n" +
                "  1\t\t\t\tMed. Boi\t\t\t\t\t\tR$ 6,00\n" +
                "\n\n" +
                "Total\t\t\t\t\t\t\t\t\t\t\t\t\tR$ 42,00");

        Button btnCancelar = (Button) v.findViewById(R.id.botao_cancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new MainFragment());
                ft.commit();

                if (((AppCompatActivity)getActivity()).getSupportActionBar() != null) {
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.app_name));
                }
            }
        });

        Button btnFechar = (Button) v.findViewById(R.id.botao_fechar_conta);

        btnFechar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new MainFragment());
                ft.commit();

                if (((AppCompatActivity)getActivity()).getSupportActionBar() != null) {
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.app_name));
                }

                Toast toast = Toast.makeText(getContext(), "Pagamento Realizado!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });



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
