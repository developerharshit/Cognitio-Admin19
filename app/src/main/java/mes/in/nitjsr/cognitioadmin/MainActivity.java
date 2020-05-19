package mes.in.nitjsr.cognitioadmin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences preferences;
    public static final String DEFAULT="N/A" ;
    public static String NAME;
    public static String EMAIL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.push_notif).setOnClickListener(this);
        findViewById(R.id.faqs).setOnClickListener(this);
        findViewById(R.id.set_notif).setOnClickListener(this);
        preferences=getSharedPreferences(Login.SHAREDPREFS,MODE_PRIVATE);

        NAME=preferences.getString("name",DEFAULT);
        EMAIL=preferences.getString("email",DEFAULT);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.push_notif){
            startActivity(new Intent(MainActivity.this,NotificationActivity.class));
        }

        if(v.getId()==R.id.faqs){
            startActivity(new Intent(MainActivity.this,FAQs.class));
        }

        if (v.getId()==R.id.set_notif){
            startActivity(new Intent(MainActivity.this,SetNotification.class));
        }
    }
}
