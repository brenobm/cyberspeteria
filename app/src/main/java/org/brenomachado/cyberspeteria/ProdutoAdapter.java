package org.brenomachado.cyberspeteria;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by breno on 19/09/2016.
 */
public class ProdutoAdapter extends ArrayAdapter<Produto> {
    private ArrayList<Produto> produtoList;

    public ProdutoAdapter(Context context, int textViewResourceId,
                           ArrayList<Produto> produtoList) {
        super(context, textViewResourceId, produtoList);
        this.produtoList = new ArrayList<Produto>();
        this.produtoList.addAll(produtoList);
    }

    private class ViewHolder {
        TextView descricao;
        CheckBox nome;
        TextView preco;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.produto_checkbox, null);

            holder = new ViewHolder();
            holder.descricao = (TextView) convertView.findViewById(R.id.produto);
            holder.nome = (CheckBox) convertView.findViewById(R.id.checkBox1);
            holder.preco = (TextView) convertView.findViewById(R.id.valor);
            convertView.setTag(holder);

            holder.descricao.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    TextView tv = (TextView) v ;
                    CheckBox cb = (CheckBox) tv.getTag();
                    cb.setChecked(!cb.isChecked());
                }
            });

            holder.preco.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    TextView tv = (TextView) v ;
                    CheckBox cb = (CheckBox) tv.getTag();
                    cb.setChecked(!cb.isChecked());
                }
            });
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Produto produto = produtoList.get(position);

        holder.nome.setText(produto.getNome());
        holder.nome.setTag(produto);

        holder.descricao.setText(" (" +  produto.getNome() + ")");
        holder.descricao.setTag(holder.nome);

        holder.preco.setText(String.format("R$ %1$,.2f", produto.getValor()));
        holder.preco.setTag(holder.nome);

        return convertView;

    }
}
