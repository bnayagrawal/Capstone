package xyz.bnayagrawal.android.capstone.feature.news;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;

import xyz.bnayagrawal.android.capstone.data.model.Article;
import xyz.bnayagrawal.android.capstone.data.remote.NewsApiServer.NewsType;
import xyz.bnayagrawal.android.capstone.data.remote.NewsRepository;

public class NewsViewModel extends ViewModel {

    private NewsRepository newsRepository;

    private LiveData<Collection<Article>> articles;

    public NewsViewModel(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void fetchNews(String apiKey, Map<String, String> options, NewsType newsType) {
        if (this.articles != null)
            return;
        if (newsType == NewsType.EVERYTHING)
            articles = newsRepository.getEverything(apiKey, options);
        else
            articles = newsRepository.getTopHeadlines(apiKey,options);
    }

    public LiveData<Collection<Article>> getArticles() {
        return this.articles;
    }
}
