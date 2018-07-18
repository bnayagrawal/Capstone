package xyz.bnayagrawal.android.capstone.feature.article;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.bnayagrawal.android.capstone.R;
import xyz.bnayagrawal.android.capstone.data.model.Article;
import xyz.bnayagrawal.android.capstone.databinding.ActivityArticleBinding;

public class ArticleActivity extends AppCompatActivity {

    public static final String EXTRA_ARTICLE =
            "xyz.bnayagrawal.android.capstone.feature.article";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityArticleBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_article);
        ButterKnife.bind(this);

        //Get article from bundle
        Intent articleIntent = getIntent();
        if (null != articleIntent && articleIntent.hasExtra(EXTRA_ARTICLE)) {
            Article article = articleIntent.getParcelableExtra(EXTRA_ARTICLE);
            binding.setArticle(article);

            //load article image
            Glide.with(this).load(article.getUrlToImage())
                    .apply(new RequestOptions().centerCrop().placeholder(R.drawable.ic_placeholder_thumb))
                    .transition(GenericTransitionOptions.with(R.anim.fade_in))
                    .into(binding.imgArticleImage);
        } else {
            finish();
        }

    }

    /**
     * Triggered when share button is clicked
     *
     * @param url url of the article
     */
    public void onFabShareClick(String url) {
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
    }
}
