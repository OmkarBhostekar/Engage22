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
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<SearchRepository> repositoryProvider;

  public SearchViewModel_Factory(Provider<SearchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<SearchRepository> repositoryProvider) {
    return new SearchViewModel_Factory(repositoryProvider);
  }

  public static SearchViewModel newInstance(SearchRepository repository) {
    return new SearchViewModel(repository);
  }
}
