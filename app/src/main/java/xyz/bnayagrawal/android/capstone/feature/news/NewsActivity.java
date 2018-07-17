package xyz.bnayagrawal.android.capstone.feature.news;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.bnayagrawal.android.capstone.R;
import xyz.bnayagrawal.android.capstone.data.remote.NewsApiServer;
import xyz.bnayagrawal.android.capstone.feature.news.adapter.NewsTabPagerAdapter;

public class NewsActivity extends AppCompatActivity {

    @BindView(R.id.tab_layout) TabLayout tabLayout;
    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.toolbar_act_bta) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        setupToolbar();
        initTabs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_news,menu);
        return true;
    }

    /**
     * Setups toolbar of current activity
     */
    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * Initializes Tabs
     */
    private void initTabs() {
        //For each available category, add tabs
        for(String category: NewsApiServer.POSSIBLE_CATEGORY_OPTIONS)
            tabLayout.addTab(tabLayout.newTab().setText(category));

        PagerAdapter pagerAdapter = new NewsTabPagerAdapter(
                getSupportFragmentManager(),
                tabLayout.getTabCount()
        );

        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                /////////////////////
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                /////////////////////
            }
        });
    }
}
