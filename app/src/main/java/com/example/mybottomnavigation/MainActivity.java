package com.example.mybottomnavigation;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton textbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        textbtn = findViewById(R.id.fab_run_mainPage);
        textbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view){

                Snackbar snackbar = Snackbar.make(view , "This is Mosso", Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.undo_string, this);
                snackbar.show();
            }

        });

        FloatingActionButton textView = findViewById(R.id.fab_snapBar_mainPage);

        registerForContextMenu(textView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Mosso options");
        getMenuInflater().inflate(R.menu.example_layer_menu, menu);

        // use switch if you have more menus by call v

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.option_myLocation_1:
                Toast.makeText(this, "My location seletcted", Toast.LENGTH_SHORT).show();
                int  a = item.getItemId();

                return true;
            case R.id.option_other_Location_2:
                Toast.makeText(this,"Other Location selected ", Toast.LENGTH_SHORT ).show();
                return true;

            case R.id.option_track_3:
                Toast.makeText(this,"Track selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
               return super.onContextItemSelected(item);
        }

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Undo Mosso Operation Selected", Toast.LENGTH_SHORT ).show();

    }
}
