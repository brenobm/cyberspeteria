package org.brenomachado.cyberspeteria;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by breno on 19/09/2016.
 */
public class IdentificacaoDialog extends Dialog implements
        View.OnClickListener {
    private Activity activity;
    private Button btnCancelar, btnSalvar;

    public IdentificacaoDialog(Activity activity) {
        super(activity);

        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_identificacao);
        btnSalvar = (Button) findViewById(R.id.botao_salvar);
        btnCancelar = (Button) findViewById(R.id.botao_cancelar);
        btnSalvar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botao_salvar:
                Toast.makeText(getContext(), "Identificação salva!", Toast.LENGTH_SHORT);
                dismiss();
                break;
            case R.id.botao_cancelar:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
