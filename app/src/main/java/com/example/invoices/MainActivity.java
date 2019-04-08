package com.example.invoices;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.invoices.adapters.SectionsFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsFragmentAdapter mSectionFragmetnAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionFragmetnAdapter = new SectionsFragmentAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsFragmentAdapter adapter = new SectionsFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new invocies_fragment(), "Faktury");
        adapter.addFragment(new tax_fragment(), "Podatek");
        adapter.addFragment(new zus_fragment(), "ZUS");
        viewPager.setAdapter(adapter);
    }
}
