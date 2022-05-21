// Generated by Dagger (https://dagger.dev).
package com.omkarcodes.movee.di;

import com.omkarcodes.movee.ui.detail.DetailApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideDetailApiFactory implements Factory<DetailApi> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideDetailApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public DetailApi get() {
    return provideDetailApi(retrofitProvider.get());
  }

  public static AppModule_ProvideDetailApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideDetailApiFactory(retrofitProvider);
  }

  public static DetailApi provideDetailApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDetailApi(retrofit));
  }
}
