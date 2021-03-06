package gachon.mpclass.mp_termproject;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import gachon.mpclass.mp_termproject.R;

public class MyFrige extends AppCompatActivity{

    Fragment fillfrige, fillutensil, basket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frige);

        fillfrige = new FillFrige();
        fillutensil = new FillUtensil();
        basket = new Basket();


        getSupportFragmentManager().beginTransaction().add(R.id.frame, fillfrige).commit();

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0){

                    selected = fillfrige;

                }else if (position == 1) {

                    selected = fillutensil;
                }
                else if (position == 2) {

                    selected = basket;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}