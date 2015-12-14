package com.electronic_caculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dc2dc extends Activity {

	OnClickListener Listener1 = null;
	OnClickListener Listener2 = null;
	OnClickListener Listener3 = null;
	
	Button button1;
	Button button2;	
	Button button3;  //clear	
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_dc2dc); //Ҫ��������öԲ���
        final EditText RefVol = (EditText) findViewById(R.id.et_DcDcRefVol);
        RefVol.setText(String.valueOf(1.25)); //Ԥ��ֵ������ÿ������
        Listener1 = new OnClickListener(){
        	public void onClick(View v){
    		//EditText RefVol = (EditText) findViewById(R.id.et_DcDcRefVol);
    		EditText R1 = (EditText) findViewById(R.id.et_DcDcR1);	
    		EditText R2 = (EditText) findViewById(R.id.et_DcDcR2);	
    		EditText Vo = (EditText) findViewById(R.id.et_DcDcVo);	
    		
    		//�Զ��жϿհ���������r1��r2��vo������2�����õ�����һ�����ο���ѹĬ��Ϊ1.25v����������
    		try{
    		
    			//Ӧ�ò���˫���ȣ�ȷ������׼ȷ��
    			double Ref,r1,r2,vo;
    			//Ref = 1.25 ;//Ĭ�ϵĲ���
    			if("".equals(Vo.getText().toString().trim()))
    			{
	    			Ref = Double.parseDouble(RefVol.getText().toString());	
	    			r1 = Double.parseDouble(R1.getText().toString());
	        		r2 = Double.parseDouble(R2.getText().toString());
	        		
	        		vo = Ref*(r1+r2)/r2;
	        		
	        		Vo.setText(String.valueOf(vo));
    			}
    			
    			if("".equals(R1.getText().toString().trim()))
    			{
    				Ref = Double.parseDouble(RefVol.getText().toString());	
	    			//r1 = Double.parseDouble(R1.getText().toString());
	        		r2 = Double.parseDouble(R2.getText().toString());
	        		
	        		vo = Double.parseDouble(Vo.getText().toString());//Ref*(r1+r2)/r2;
	        		
	        		r1 = vo*r2/Ref - r2;
	        		R1.setText(String.valueOf(r1));
    			}
    			if("".equals(R2.getText().toString().trim()))
    			{
    				Ref = Double.parseDouble(RefVol.getText().toString());	
	    			r1 = Double.parseDouble(R1.getText().toString());
	        		//r2 = Double.parseDouble(R2.getText().toString());
	        		vo = Double.parseDouble(Vo.getText().toString());//Ref*(r1+r2)/r2;
	        		
	        		r2 = (Ref*r1)/(vo-Ref);
	        		R2.setText(String.valueOf(r2));
    			}
	

    		}catch(Exception ex1){
    			Toast.makeText(getBaseContext(), "input error"+ex1, Toast.LENGTH_LONG).show();
    		}    		
        	}
        	
        };
        
        Listener2 = new OnClickListener(){
        	public void onClick(View v){
        	finish();  //������ǰҳ�棬�ͻ�ص���һ��ҳ��	
        	}
        	
        };
        
        Listener3 = new OnClickListener(){
        	public void onClick(View v){
        	//������ո��������
        		
    		//EditText RefVol = (EditText) findViewById(R.id.et_DcDcRefVol);
    		EditText R1 = (EditText) findViewById(R.id.et_DcDcR1);	
    		EditText R2 = (EditText) findViewById(R.id.et_DcDcR2);	
    		EditText Vo = (EditText) findViewById(R.id.et_DcDcVo);	
		
    		//RefVol.setText("");
    		R1.setText("");
    		R2.setText("");
    		Vo.setText("");
    		//Ref = 1.25 ;//Ĭ�ϵĲ���
			RefVol.setText(String.valueOf(1.25)); //Ԥ��ֵ������ÿ������
        	}
        	
        };
        
        button1 = (Button) findViewById(R.id.btn_calculate_dcdc);
        button1.setOnClickListener(Listener1);
        
        button2 = (Button) findViewById(R.id.btn_ret_dcdc);
        button2.setOnClickListener(Listener2);
        
        button3 = (Button) findViewById(R.id.btn_clr_dcdc);
        button3.setOnClickListener(Listener3);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_dc2dc, menu);
        return true;
    }
}
