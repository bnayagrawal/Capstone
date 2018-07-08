package xyz.bnayagrawal.android.capstone.data.remote;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import retrofit2.http.QueryMap;
import xyz.bnayagrawal.android.capstone.data.model.Everything;
import xyz.bnayagrawal.android.capstone.data.model.Sources;
import xyz.bnayagrawal.android.capstone.data.model.TopHeadlines;

public interface NewsService {

    @GET(NewsApiServer.ENDPOINT_TOP_HEADLINES)
    Call<TopHeadlines> getTopHeadlines(@Header("X-Api-Key") String apiKey, @QueryMap Map<String, String> options);

    @GET(NewsApiServer.ENDPOINT_EVERYTHING)
    Call<Everything> getEverything(@Header("X-Api-Key") String apiKey, @QueryMap Map<String, String> options);

    @GET(NewsApiServer.ENDPOINT_SOURCES)
    Call<Sources> getSources(@Header("X-Api-Key") String apiKey, @QueryMap Map<String, String> options);
}
