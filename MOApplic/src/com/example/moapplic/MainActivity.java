package com.example.moapplic;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener, android.view.View.OnClickListener {
EditText name;
EditText pass;
Button login;
Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText)findViewById(R.id.editText1);
        pass= (EditText) findViewById(R.id.editText2);
        login= (Button) findViewById(R.id.Button1);
        cancel= (Button) findViewById(R.id.Button2);
        login.setOnClickListener(this);
        cancel.setOnClickListener(this);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View w) {
		// TODO Auto-generated method stub
		String na=name.getText().toString();
		String pa=pass.getText().toString();
		
		switch (w.getId()){
		case R.id.Button1:
		
				if(na.length()>8 && pa.length()>8 && na.matches(".*\\d.*") &&pa.matches(".*\\d.*")){
					Intent i=new Intent (this,Second.class);
					startActivity (i);	
				}
				else{
					Toast.makeText(getApplicationContext(), "Mai incearca!",
							   Toast.LENGTH_LONG).show();
				}
				
			break; 
			
			case R.id.Button2:
					name.setText(" ");
					pass.setText(" ");
				break;
		
			default:
		
		break;
			
		}
	}


	@Override
	public void onClick(DialogInterface dialog, int which) {
		
	}
}
