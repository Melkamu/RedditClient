package com.melkam.redditclient.dependencyinjection;

import com.melkam.redditclient.api.ApiEndPoint;
import com.melkam.redditclient.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * @author Melkamu
 */
@Module(
        complete = false,
        library = true
)
public class ApiModule {

    @Provides
    @Singleton
    RestAdapter providesRestAdapter() {

        final RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setEndpoint(Constants.API_PATH);

        return builder.build();
    }

    @Provides
    @Singleton
    ApiEndPoint provideApiEndPoint(final RestAdapter restAdapter) {

        final ApiEndPoint apiEndPoint = restAdapter.create(ApiEndPoint.class);

        return apiEndPoint;
    }
}
