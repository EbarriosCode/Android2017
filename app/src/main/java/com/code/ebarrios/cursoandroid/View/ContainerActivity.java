package com.code.ebarrios.cursoandroid.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.code.ebarrios.cursoandroid.R;
import com.code.ebarrios.cursoandroid.View.Fragments.HomeFragment;
import com.code.ebarrios.cursoandroid.View.Fragments.ProfileFragment;
import com.code.ebarrios.cursoandroid.View.Fragments.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TextView txtCambiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        //txtCambiar = (TextView) findViewById(R.id.txtView);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        //bottomNavigationView.setSelectedItemId(R.id.menu_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu_search:
                        //txtCambiar.setText("Buscar");
                        addFragment(new SearchFragment());
                        break;

                    case R.id.menu_home:
                        addFragment(new HomeFragment());
                        break;

                    case R.id.menu_profile:
                        addFragment(new ProfileFragment());
                        break;
                }
                return false;
            }
        });

    }

    private void addFragment(Fragment fragment){
        if (null != fragment){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
    }
}
