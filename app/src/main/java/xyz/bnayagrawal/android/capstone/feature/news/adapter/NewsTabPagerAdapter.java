package xyz.bnayagrawal.android.capstone.feature.news.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import xyz.bnayagrawal.android.capstone.data.remote.NewsApiServer;
import xyz.bnayagrawal.android.capstone.feature.news.NewsFragment;

import static xyz.bnayagrawal.android.capstone.feature.news.NewsFragment.EXTRA_NEWS_CATEGORY;

public class NewsTabPagerAdapter extends FragmentPagerAdapter {

    private int tabCount;

    public NewsTabPagerAdapter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        NewsFragment fragment = new NewsFragment();

        //Set news category
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_NEWS_CATEGORY,NewsApiServer.POSSIBLE_CATEGORY_OPTIONS[position]);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
