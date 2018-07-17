package xyz.bnayagrawal.android.capstone.feature.news;

import android.content.Intent;
import android.view.View;

import xyz.bnayagrawal.android.capstone.data.model.Article;
import xyz.bnayagrawal.android.capstone.feature.article.ArticleActivity;

public class ArticlePresenter {

    /**
     * Triggered when an article is clicked
     * @param article article
     */
    public void onItemClick(View view, Article article) {
        Intent intent = new Intent(view.getContext(), ArticleActivity.class);
        intent.putExtra(ArticleActivity.EXTRA_ARTICLE,article);
        view.getContext().startActivity(intent);
    }
}
