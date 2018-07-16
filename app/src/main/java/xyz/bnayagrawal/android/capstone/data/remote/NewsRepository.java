package xyz.bnayagrawal.android.capstone.data.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.bnayagrawal.android.capstone.data.model.Article;
import xyz.bnayagrawal.android.capstone.data.model.Everything;
import xyz.bnayagrawal.android.capstone.data.model.Sources;
import xyz.bnayagrawal.android.capstone.data.model.TopHeadlines;

import static xyz.bnayagrawal.android.capstone.data.remote.NewsApiServer.STATUS_OK;

@Singleton
public class NewsRepository {

    private NewsService newsService;

    @Inject
    public NewsRepository(NewsService newsService) {
        this.newsService = newsService;
    }

    public LiveData<Collection<Article>> getEverything(String apiKey, Map<String, String> options) {
        final MutableLiveData<Collection<Article>> data = new MutableLiveData<>();
        newsService.getEverything(apiKey,options).enqueue(new Callback<Everything>() {
            @Override
            public void onResponse(@NonNull Call<Everything> call, @NonNull Response<Everything> response) {
                if(response.body().getStatus().equals(STATUS_OK))
                    data.setValue(response.body().getArticles());
                else
                    data.setValue(null);
            }

            @Override
            public void onFailure(@NonNull Call<Everything> call, @NonNull Throwable t) {
            }
        });
        return data;
    }

    public LiveData<Collection<Article>> getTopHeadlines(String apiKey, Map<String, String> options) {
        final MutableLiveData<Collection<Article>> data = new MutableLiveData<>();
        newsService.getTopHeadlines(apiKey,options).enqueue(new Callback<TopHeadlines>() {
            @Override
            public void onResponse(@NonNull Call<TopHeadlines> call, @NonNull Response<TopHeadlines> response) {
                if(response.body().getStatus().equals(STATUS_OK))
                    data.setValue(response.body().getArticles());
                else
                    data.setValue(null);
            }

            @Override
            public void onFailure(@NonNull Call<TopHeadlines> call, @NonNull Throwable t) {

            }
        });
        return data;
    }

    public LiveData<Collection<Sources.SourceDetails>> getSources(String apiKey, Map<String, String> options) {
        final MutableLiveData<Collection<Sources.SourceDetails>> data = new MutableLiveData<>();
        newsService.getSources(apiKey,options).enqueue(new Callback<Sources>() {
            @Override
            public void onResponse(@NonNull Call<Sources> call, @NonNull Response<Sources> response) {
                if(response.body().getStatus().equals(STATUS_OK))
                    data.setValue(response.body().getSources());
                else
                    data.setValue(null);
            }

            @Override
            public void onFailure(@NonNull Call<Sources> call, @NonNull Throwable t) {
            }
        });
        return data;
    }
}
