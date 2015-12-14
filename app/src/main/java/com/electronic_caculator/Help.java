package com.electronic_caculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Help extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Button buttonRet = (Button) findViewById(R.id.btn_ret_help);	
        
        OnClickListener ListenerRet = new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
        	
        };
        
        buttonRet.setOnClickListener(ListenerRet);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_help, menu);
        return true;
    }
}
