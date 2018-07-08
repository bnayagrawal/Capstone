package xyz.bnayagrawal.android.capstone.feature.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xyz.bnayagrawal.android.capstone.R;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set default theme
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }
}
