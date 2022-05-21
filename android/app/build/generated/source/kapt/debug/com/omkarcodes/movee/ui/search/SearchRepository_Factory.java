// Generated by Dagger (https://dagger.dev).
package com.omkarcodes.movee.ui.search;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SearchRepository_Factory implements Factory<SearchRepository> {
  private final Provider<SearchApi> apiProvider;

  public SearchRepository_Factory(Provider<SearchApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public SearchRepository get() {
    return newInstance(apiProvider.get());
  }

  public static SearchRepository_Factory create(Provider<SearchApi> apiProvider) {
    return new SearchRepository_Factory(apiProvider);
  }

  public static SearchRepository newInstance(SearchApi api) {
    return new SearchRepository(api);
  }
}
