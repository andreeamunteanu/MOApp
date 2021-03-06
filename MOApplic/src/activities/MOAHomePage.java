package activities;

import storage.Database;
import storage.User;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moapplic.R;

public class MOAHomePage extends ActionBarActivity {
User currentUser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_moahome_page);
		Intent intent = getIntent();
		String userId= intent.getStringExtra("id");
		int intUserId= Integer.parseInt(userId);
		currentUser=Database.getINSTANCE().getUsers().get(intUserId);
		TextView textView =(TextView)findViewById(R.id.favouriteSite);
		textView.setClickable(true);
		textView.setMovementMethod(LinkMovementMethod.getInstance());
		String text = "<a href='"+currentUser.getFavouriteSite()+"'> favourite site </a>";
		textView.setText(Html.fromHtml(text));
		
		ImageView weatherImageView =(ImageView)findViewById(R.id.weather_image_view);
		weatherImageView.setClickable(true);
		weatherImageView.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v){
		        Intent intent = new Intent();
		        intent.setAction(Intent.ACTION_VIEW);
		        intent.addCategory(Intent.CATEGORY_BROWSABLE);
		        intent.setData(Uri.parse("http://www.moa.fr"));
		        startActivity(intent);
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.moahome_page, menu);
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
}
