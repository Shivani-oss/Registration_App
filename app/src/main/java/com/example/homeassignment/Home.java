package com.example.homeassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.homeassignment.ui.home.HomeFragment;
import com.example.homeassignment.ui.home.HomeViewModel;


public class Home extends AppCompatActivity {

    private HomeViewModel mViewModel;
    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdaptor sliderAdaptor;
    TextView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance())
                    .commitNow();
        }
    }
}
