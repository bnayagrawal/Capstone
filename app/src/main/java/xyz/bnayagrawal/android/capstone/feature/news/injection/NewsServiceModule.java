package xyz.bnayagrawal.android.capstone.feature.news.injection;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.bnayagrawal.android.capstone.data.remote.NewsApiServer;
import xyz.bnayagrawal.android.capstone.data.remote.NewsRepository;
import xyz.bnayagrawal.android.capstone.data.remote.NewsService;

@Module
public class NewsServiceModule {

    @Named("newsService")
    @Provides
    NewsService provideNewsService(@Named("baseUrl") String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsService.class);
    }

    @Provides
    @Named("baseUrl")
    String provideBaseUrl() {
        return NewsApiServer.BASE_URL + NewsApiServer.BASE_ENDPOINT;
    }

    @Provides
    NewsRepository provideNewsRepository(@Named("newsService") NewsService newsService) {
        return new NewsRepository(newsService);
    }
}
