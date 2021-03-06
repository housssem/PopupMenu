package in.wptrafficanalyzer.popupmenudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button) findViewById(R.id.btn);
        
        OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/** Instantiating PopupMenu class */
				PopupMenu popup = new PopupMenu(getBaseContext(), v);
				
				/** Adding menu items to the popumenu */
				popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
				
				/** Defining menu item click listener for the popup menu */
				popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {					
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						Toast.makeText(getBaseContext(), "You selected the action : " + item.getTitle(), Toast.LENGTH_SHORT).show();
						return true;
					}
				});
				
				/** Showing the popup menu */
				popup.show();
				
			}
		};
        
        
        btn.setOnClickListener(listener);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
