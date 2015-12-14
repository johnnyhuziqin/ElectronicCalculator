package com.electronic_caculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {

	//先声明好listener，再配置给各个按键	
	OnClickListener Listener1 = null;
	OnClickListener Listener2 = null;
	OnClickListener Listener3 = null;
	OnClickListener Listener4 = null;
	OnClickListener Listener5 = null;
	OnClickListener Listener6 = null;
	
	Button button1;
	Button button2;
	Button button3;
	Button button4;  //resistor divider
	Button button5;
	Button button6;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.v("main", "enter main");
        
        Listener1 = new OnClickListener(){
        	public void onClick(View v){
        	Intent intent1 = new Intent(Main.this,Resistor_divider.class); 	
        	setTitle("Resistor divider");
        	startActivity(intent1);
        	Log.v("main", "Resistor divider");
        	}
        	
        };
        
        Listener2 = new OnClickListener(){
        	public void onClick(View v){
        	Intent intent2 = new Intent(Main.this,Power.class); 	
        	setTitle("Power calculator");
        	startActivity(intent2);
        	Log.v("main", "Power calculator");
        	}
        	
        };
        Listener3 = new OnClickListener(){
        	public void onClick(View v){
        	Intent intent3 = new Intent(Main.this,Dc2dc.class); 	
        	setTitle("Dc to Dc");
        	startActivity(intent3);
        	Log.v("main", "dc dc");
        	}
        	
        };
        Listener4 = new OnClickListener(){
        	public void onClick(View v){
        	Intent intent4 = new Intent(Main.this,Parallel_resistor.class); 	
        	setTitle("Parallel_resistor");
        	startActivity(intent4);
        	Log.v("main", "R2");
        	}
        	
        };
        Listener5 = new OnClickListener(){
        	public void onClick(View v){
        	Intent intent5 = new Intent(Main.this,Help.class); 	
        	setTitle("help");
        	startActivity(intent5);
        	Log.v("main", "help");
        	}
        	
        };
        Listener6 = new OnClickListener(){
        	public void onClick(View v){
        	//退出键要做神马？	
        	finish();
        	Log.v("main", "finish");
        	}
        	
        };
        
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(Listener1);
        
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(Listener2);
        
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(Listener3);
        
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(Listener4);
        
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(Listener5);
        
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(Listener6);
        
        
    }

}
