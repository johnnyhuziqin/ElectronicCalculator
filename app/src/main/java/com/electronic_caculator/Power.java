package com.electronic_caculator;

import android.os.Bundle;
import android.provider.Contacts.People;
//import android.provider.Contacts.People;
import android.app.Activity;
import android.database.Cursor;
//import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.app.ListActivity; 

public class Power extends Activity {
	OnClickListener Listener1 = null;
	OnClickListener Listener2 = null;
	OnClickListener Listener3 = null;
	
	Button button1;
	Button button2;	
	Button button3;  //clear	
	
	private Cursor mCursor; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        Listener1 = new OnClickListener(){
        	public void onClick(View v){
    		EditText VppValue = (EditText) findViewById(R.id.OutputVppValue);
    		EditText VrmsValue = (EditText) findViewById(R.id.OutputVrmsValue);	
    		EditText ImpValue = (EditText) findViewById(R.id.ImpedanceValue);	
    		EditText PowValue = (EditText) findViewById(R.id.OutputPowerValue);	
    		 
    		try{
    		
    			//Ӧ�ò���˫���ȣ�ȷ������׼ȷ��
    			double Vpp,Vrms,Imp,Pow;
    			
    			//���ж�Vpp�Ƿ�Ϊ�գ�����ǿգ��͸���Vpp�����Vrms��Ȼ���ټ�������
    			//���VppΪ�գ���ֱ����Vrms���㹦�ʣ�������գ�����ʾ�������
    			
    			if("".equals(VppValue.getText().toString())){
    				Vrms = Double.parseDouble(VrmsValue.getText().toString());
    			}else{
    				Vpp = Double.parseDouble(VppValue.getText().toString());
    				Vrms = Vpp*0.707;
    				VrmsValue.setText(String.valueOf(Vrms));
    			}
    				
    			
    			
    			//Vpp = Double.parseDouble(VppValue.getText().toString());
        		Imp = Double.parseDouble(ImpValue.getText().toString());
        		//Pow = Double.parseDouble(PowValue.getText().toString());
        		
        		//Pow = ((Vpp/1.414)*(Vpp/1.414))/Imp;
        		//Pow = ((Vpp*0.707)*(Vpp*0.707))/Imp;
        		Pow = Vrms*Vrms/Imp;
        		
        		PowValue.setText(String.valueOf(Pow));
    			
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
        		
    		EditText VppValue = (EditText) findViewById(R.id.OutputVppValue);	
    		EditText VrmsValue = (EditText) findViewById(R.id.OutputVrmsValue);	
    		EditText ImpValue = (EditText) findViewById(R.id.ImpedanceValue);	
    		EditText PowValue = (EditText) findViewById(R.id.OutputPowerValue);	
    		
    		VppValue.setText("");
    		VrmsValue.setText("");
    		ImpValue.setText("");
    		PowValue.setText("");
        	}
        	
        };
        setContentView(R.layout.activity_power);
        
        button1 = (Button) findViewById(R.id.btn_calculate_power);
        button1.setOnClickListener(Listener1);
        
        button2 = (Button) findViewById(R.id.btn_ret_power);
        button2.setOnClickListener(Listener2);
        
        button3 = (Button) findViewById(R.id.btn_clr_power);
        button3.setOnClickListener(Listener3);
        
             
    }

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_power, menu);
        return true;
    }
}
