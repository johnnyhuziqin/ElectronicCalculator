package com.electronic_caculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Parallel_resistor extends Activity {
	//OnClickListener ListenerDo = null;
	//OnClickListener ListenerRet = null;
	//OnClickListener ListenerClr = null;
	/*
	Button buttonDo = (Button) findViewById(R.id.btn_calculate_para);
	Button buttonRet = (Button) findViewById(R.id.btn_ret_para);	
	Button buttonClr = (Button) findViewById(R.id.btn_clr_para);  //clear	
	
	EditText R1 = (EditText) findViewById(R.id.parallelR1_value);	
	EditText R2 = (EditText) findViewById(R.id.parallelR2_value);	
	EditText R3 = (EditText) findViewById(R.id.parallelR3_value);	
	EditText R4 = (EditText) findViewById(R.id.parallelR4_value);	
	EditText R5 = (EditText) findViewById(R.id.parallelR5_value);	
	EditText Rp = (EditText) findViewById(R.id.parallelRp_value);	
	*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallel_resistor);
        
        Button buttonDo = (Button) findViewById(R.id.btn_calculate_para);
    	Button buttonRet = (Button) findViewById(R.id.btn_ret_para);	
    	Button buttonClr = (Button) findViewById(R.id.btn_clr_para);  //clear	
    	
    	final EditText R1 = (EditText) findViewById(R.id.parallelR1_value);	
    	final EditText R2 = (EditText) findViewById(R.id.parallelR2_value);	
    	final EditText R3 = (EditText) findViewById(R.id.parallelR3_value);	
    	final EditText R4 = (EditText) findViewById(R.id.parallelR4_value);	
    	final EditText R5 = (EditText) findViewById(R.id.parallelR5_value);	
    	final EditText Rp = (EditText) findViewById(R.id.parallelRp_value);	
    	
        
        OnClickListener ListenerDo = new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
		    		
	    			//应该采用双精度，确保数据准确度
	    			double r1,r2,r3,r4,r5,rp;
	    			
	    			//必须先把前面的空格填写，才会计算后面的空格，否则会忽略后面的空格
	    			
	    			r1 = Double.parseDouble(R1.getText().toString());
	        		r2 = Double.parseDouble(R2.getText().toString());
	        		if("".equals(R3.getText().toString())){
	        			rp = r1*r2/(r1+r2);
	        			R4.setText("");  //再重复清除一下，以免误解
	    				R5.setText("");
	        		}else if("".equals(R4.getText().toString())){
	        			r3 = Double.parseDouble(R3.getText().toString());
	        			//rp = r1*r2*r3/(r1+r2+r3); //这是错误的计算方式
	        			rp = 1/(1/r1+1/r2+1/r3);
	        			R5.setText("");
	        		}else if("".equals(R5.getText().toString())){
	        			r3 = Double.parseDouble(R3.getText().toString());
	        			r4 = Double.parseDouble(R4.getText().toString());
	        			rp = 1/(1/r1+1/r2+1/r3+1/r4);
	        		}else{
	        			r3 = Double.parseDouble(R3.getText().toString());
	        			r4 = Double.parseDouble(R4.getText().toString());
		        		r5 = Double.parseDouble(R5.getText().toString());
		        		rp = 1/(1/r1+1/r2+1/r3+1/r4+1/r5);
	        		}
	        			        		
	        		Rp.setText(String.valueOf(rp));
	    			
	    		}catch(Exception ex1){
	    			Toast.makeText(getBaseContext(), "input error"+ex1, Toast.LENGTH_LONG).show();
	    		}  
			}
        	
        };
        
        OnClickListener ListenerRet = new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
        	
        };
        
        OnClickListener ListenerClr = new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				R1.setText("");
				R2.setText("");
				R3.setText("");
				R4.setText("");
				R5.setText("");
				Rp.setText("");
			}
        	
        };
        
        buttonDo.setOnClickListener(ListenerDo);
        buttonClr.setOnClickListener(ListenerClr);
        buttonRet.setOnClickListener(ListenerRet);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_parallel_resistor, menu);
        return true;
    }
}
