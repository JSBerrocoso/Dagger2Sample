package com.gigigo.dagger2sample.data.api.services;

import android.util.Log;
import com.gigigo.dagger2sample.data.entities.ArtistSearchResponse;
import com.gigigo.dagger2sample.domain.constants.SpotifyApiConstants;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by santiago.berrocoso on 06/10/16.
 */
public class ApiService {

  private static final String TAG = ApiService.class.getSimpleName();
  private static Retrofit RETROFIT;

  public static Retrofit getInstance() {

    //The adapter will be a singleton
    if (RETROFIT == null) {

      //OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
      //httpClient.addInterceptor(new Interceptor() {
      //  @Override
      //  public Response intercept(Interceptor.Chain chain) throws IOException {
      //    Request original = chain.request();
      //
      //    // Request customization: add request headers
      //    Request.Builder requestBuilder = original.newBuilder()
      //        .header("Authorization", "auth-value"); // <-- this is the important line
      //
      //    Request request = requestBuilder.build();
      //    Response response = chain.proceed(request);
      //    if (response.code() == 400 ) {
      //      Log.d(TAG, "onResponse - Status : " + response.code());
      //      Gson gson = new Gson();
      //      TypeAdapter<ArtistSearchResponse> adapter = gson.getAdapter(ArtistSearchResponse.class);
      //      try {
      //        if (response.toString() != null)
      //          adapter.fromJson(response.toString());
      //      } catch (IOException e) {
      //        e.printStackTrace();
      //      }
      //    }
      //    return response;
      //  }
      //});

      //OkHttpClient client = httpClient.build();

      OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
      HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      clientBuilder.addInterceptor(loggingInterceptor);

      RETROFIT = new Retrofit.Builder()
          .baseUrl(SpotifyApiConstants.BASE_URL)
          .client(clientBuilder.build())
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
          .build();
    }


    return RETROFIT;
  }
}
