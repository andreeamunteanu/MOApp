package activities;

import storage.Database;
import storage.User;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.moapplic.R;

public class Second extends ActionBarActivity {
	TextView userNameTextView;
	User currentUser;
	Button nextButton;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second1);
		Intent myIntent = getIntent(); // gets the previously created intent
		String userId = myIntent.getStringExtra("id");
		int intUserId = Integer.parseInt(userId);
		userNameTextView = (TextView) findViewById(R.id.user_name_text_view);
		currentUser = Database.getINSTANCE().getUsers().get(intUserId);
		userNameTextView.setText(currentUser.getUsername());
		nextButton = (Button) findViewById(R.id.next_button);
		nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Second.this, MOAHomePage.class);
				intent.putExtra("id", currentUser.getId()+"");
				startActivity(intent);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
