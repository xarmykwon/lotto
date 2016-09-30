package com.lionkwon.lottoboksil;

import java.util.HashSet;

import com.lionkwon.kwonutils.log.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

	TextView title, text_result;
	Button btn_submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewInit();
	}

	public void viewInit(){
		title = (TextView)findViewById(R.id.title);
		text_result = (TextView)findViewById(R.id.text_result);
		btn_submit = (Button)findViewById(R.id.btn_submit);
		btn_submit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_submit:
			try {
				String value = "";
				HashSet<Integer> set = new HashSet<Integer>();
				while(set.size()<6){
					set.add((int)(Math.random() * 44)+1);
				}

				for(int a : set){
					value += a+"  ";
				}

				text_result.setText(value);
			} catch (Exception e) {
				Logger.error(e);
			}

			break;

		default:
			break;
		}
	}
}
