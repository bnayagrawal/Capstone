package xyz.bnayagrawal.android.capstone.feature.news;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import xyz.bnayagrawal.android.capstone.data.remote.NewsRepository;

public class NewsViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private NewsRepository newsRepository;

    @Inject
    public NewsViewModelFactory(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new NewsViewModel(newsRepository);
    }
}
