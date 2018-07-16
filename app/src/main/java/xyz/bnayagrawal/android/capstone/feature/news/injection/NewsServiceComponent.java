package xyz.bnayagrawal.android.capstone.feature.news.injection;

import dagger.Component;
import xyz.bnayagrawal.android.capstone.feature.news.NewsFragment;

@Component(modules = {NewsServiceModule.class})
public interface NewsServiceComponent {

    void inject(NewsFragment fragment);
}
