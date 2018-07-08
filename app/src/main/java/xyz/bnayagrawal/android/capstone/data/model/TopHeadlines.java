package xyz.bnayagrawal.android.capstone.data.model;

import java.util.Collection;

public final class TopHeadlines {

    private String status;
    private int totalResults;
    private Collection<Article> articles;

    public TopHeadlines(String status, int totalResults, Collection<Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public Collection<Article> getArticles() {
        return articles;
    }
}
