// Generated by Dagger (https://dagger.dev).
package com.omkarcodes.movee.ui.detail;

import com.omkarcodes.movee.ui.saved.MoveeDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DetailRepository_Factory implements Factory<DetailRepository> {
  private final Provider<DetailApi> apiProvider;

  private final Provider<MoveeDao> daoProvider;

  public DetailRepository_Factory(Provider<DetailApi> apiProvider, Provider<MoveeDao> daoProvider) {
    this.apiProvider = apiProvider;
    this.daoProvider = daoProvider;
  }

  @Override
  public DetailRepository get() {
    return newInstance(apiProvider.get(), daoProvider.get());
  }

  public static DetailRepository_Factory create(Provider<DetailApi> apiProvider,
      Provider<MoveeDao> daoProvider) {
    return new DetailRepository_Factory(apiProvider, daoProvider);
  }

  public static DetailRepository newInstance(DetailApi api, MoveeDao dao) {
    return new DetailRepository(api, dao);
  }
}