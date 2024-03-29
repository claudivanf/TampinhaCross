package com.me.mygdxgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.badlogic.gdx.Gdx;
import com.me.mygdxgame.R;

public class EscolherPistaActivity extends Activity {
	Intent intentPista;
	private Button butaoPista1;
	private Button butaoPista2;
	private Button butaoPista3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escolherpista);

		// butoes para escolher pista
		butaoPista1();
		butaoPista2();
		butaoPista3();
		setSizes();
		butaoVoltar();
		butaoAvancar();
	}

	private void setSizes() {
		Display display = getWindowManager().getDefaultDisplay();

		int width = display.getWidth(); // deprecated
		int height = display.getHeight();
		width = (int) (width * 0.70);
		height = (int) (height * 0.70);

		MarginLayoutParams marginLayoutParams = new MarginLayoutParams(width,
				height);
		marginLayoutParams.rightMargin = 15;
		butaoPista3.setLayoutParams(new LinearLayout.LayoutParams(
				marginLayoutParams));
		butaoPista2.setLayoutParams(new LinearLayout.LayoutParams(
				marginLayoutParams));
		marginLayoutParams.leftMargin = 15;

		butaoPista1.setLayoutParams(new LinearLayout.LayoutParams(
				marginLayoutParams));

	}

	private void butaoVoltar() {
		ImageButton butaoVoltar = (ImageButton) findViewById(R.id.butao_voltar);
		butaoVoltar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

	private void butaoAvancar() {
		ImageButton butaoAvancar = (ImageButton) findViewById(R.id.butao_avancar);
		butaoAvancar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				avancarParaJogo();
			}
		});
	}

	private void butaoPista3() {
		butaoPista3 = (Button) findViewById(R.id.butaopista3);
		butaoPista3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// Jogar na pista 3
				atualizaSelecao(butaoPista3);

			}

		});
	}

	private void butaoPista2() {
		butaoPista2 = (Button) findViewById(R.id.butaopista2);

		butaoPista2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				atualizaSelecao(butaoPista2);
			}
		});
	}

	private void butaoPista1() {
		butaoPista1 = (Button) findViewById(R.id.butaopista1);
		butaoPista1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				atualizaSelecao(butaoPista1);

			}
		});
	}

	public void avancarParaJogo() {
		
		  
        Bundle extras = getIntent().getExtras();
        String tipodejogo = extras.getString("tipodejogo");
	
        intentPista = new Intent(EscolherPistaActivity.this,
				EscolherTampaActivity.class);
		if (butaoPista1.isSelected()) {
			intentPista.putExtra("pista", "pista1");
		} else if (butaoPista2.isSelected()) {
			intentPista.putExtra("pista", "pista2");
		} else if (butaoPista3.isSelected()) {
			intentPista.putExtra("pista", "pista3");
		}
		intentPista.putExtra("tipodejogo",tipodejogo );
		startActivity(intentPista);


	}

	

	public void setTodosButaoFalse() {
		butaoPista1.setSelected(false);
		butaoPista2.setSelected(false);
		butaoPista3.setSelected(false);
	}

	private void atualizaSelecao(Button butao) {
		setTodosButaoFalse();
		butao.setSelected(true);
	}

}
