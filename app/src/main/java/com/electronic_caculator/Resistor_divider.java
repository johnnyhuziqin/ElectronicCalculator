package com.electronic_caculator;

//import com.example.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import android.content.Intent;

public class Resistor_divider extends Activity {
	OnClickListener Listener1 = null;
	OnClickListener Listener2 = null;
	OnClickListener Listener3 = null;
	
	Button button1;
	Button button2;	
	Button button3;  //clear	
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        Listener1 = new OnClickListener(){
        	public void onClick(View v){
    		EditText r1_value = (EditText) findViewById(R.id.R1_value);	
    		EditText r2_value = (EditText) findViewById(R.id.R2_value);	
    		EditText u1_value = (EditText) findViewById(R.id.Uin_value);	
    		EditText u2_value = (EditText) findViewById(R.id.Uout_value);	
    		 
    		try{
    		/*	
    			int r1,r2,u1,u2;
    		r1 = Integer.parseInt(r1_value.getText().toString());
    		r2 = Integer.parseInt(r2_value.getText().toString());
    		u1 = Integer.parseInt(u1_value.getText().toString());
    		
    		u2 = u1*r1/(r2+r1);
    		
    		u2_value.setText(String.valueOf(u2));
    		*/
    			//应该采用双精度，确保数据准确度
    			double r1,r2,u1,u2;
    			if("".equals(u2_value.getText().toString().trim())){
    			//if(u2_value.getText().toString() == null){ //判断u2为空白
        		r1 = Double.parseDouble(r1_value.getText().toString());
        		r2 = Double.parseDouble(r2_value.getText().toString());
        		u1 = Double.parseDouble(u1_value.getText().toString());
        		
        		u2 = u1*r2/(r2+r1);
        		
        		u2_value.setText(String.valueOf(u2));
    			}
    			
    			if("".equals(u1_value.getText().toString().trim())){ //判断u1为空白
            		r1 = Double.parseDouble(r1_value.getText().toString());
            		r2 = Double.parseDouble(r2_value.getText().toString());
            		u2 = Double.parseDouble(u2_value.getText().toString());
            		
            		u1 = u2*(r2+r1)/r2;
            		
            		u1_value.setText(String.valueOf(u1));
        			}
    			
    			if("".equals(r1_value.getText().toString().trim())){ //判断r1为空白
            		u1 = Double.parseDouble(u1_value.getText().toString());
            		r2 = Double.parseDouble(r2_value.getText().toString());
            		u2 = Double.parseDouble(u2_value.getText().toString());
            		
            		r1 = r2*u1/u2 - r2;
            		
            		r1_value.setText(String.valueOf(r1));
        			}
    			
    			if("".equals(r2_value.getText().toString().trim())){ //判断r2为空白
            		r1 = Double.parseDouble(r1_value.getText().toString());
            		u1 = Double.parseDouble(u1_value.getText().toString());
            		u2 = Double.parseDouble(u2_value.getText().toString());
            		
            		r2 = u2*r1/(u1-u2);
            		
            		r2_value.setText(String.valueOf(r2));
        			}
    		}catch(Exception ex1){
    			Toast.makeText(getBaseContext(), "input error"+ex1, Toast.LENGTH_LONG).show();
    		}    		
        	}
        	
        };
        
        Listener2 = new OnClickListener(){
        	public void onClick(View v){
        	//Intent intent2 = new Intent(this,Activity_RalativeLayout.class); 	
        	//setTitle("Relative Layout");
        	//startActivity(intent2);
        	finish();  //结束当前页面，就会回到上一个页面	
        	}
        	
        };
        
        Listener3 = new OnClickListener(){
        	public void onClick(View v){
        	//怎样清空各个输入框？
        		
    		EditText r1_value = (EditText) findViewById(R.id.R1_value);	
    		EditText r2_value = (EditText) findViewById(R.id.R2_value);	
    		EditText u1_value = (EditText) findViewById(R.id.Uin_value);	
    		EditText u2_value = (EditText) findViewById(R.id.Uout_value);	
        	
        	r1_value.setText("");
        	r2_value.setText("");
        	u1_value.setText("");
        	u2_value.setText("");
        	}
        	
        };
        setContentView(R.layout.activity_resistor_divider);
        
        button1 = (Button) findViewById(R.id.btn_calculate);
        button1.setOnClickListener(Listener1);
        
        button2 = (Button) findViewById(R.id.btn_ret);
        button2.setOnClickListener(Listener2);
        
        button3 = (Button) findViewById(R.id.btn_clr);
        button3.setOnClickListener(Listener3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_resistor_divider, menu);
        return true;
    }
}
