package com.gigigo.dagger2sample.app.ui.views.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnTextChanged;
import com.gigigo.dagger2sample.R;
import com.gigigo.dagger2sample.app.common.BaseFragment;
import com.gigigo.dagger2sample.app.ui.adapters.SearchResultsAdapter;
import com.gigigo.dagger2sample.app.ui.presenters.ArtistSearchPresenter;
import com.gigigo.dagger2sample.app.ui.viewmodel.ArtistSearchView;
import com.gigigo.dagger2sample.di.components.ApplicationComponent;
import com.gigigo.dagger2sample.di.components.DaggerArtistsSearchComponent;
import com.gigigo.dagger2sample.di.modules.ArtistSearchModule;
import com.gigigo.dagger2sample.domain.entities.Artist;
import com.gigigo.dagger2sample.presentation.presenters.BasePresenter;
import com.jsbs.libs.textviewlibs.views.ClearableEditText;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * Created by santiago.berrocoso on 14/06/2015.
 *
 * <p>
 * Provide a UI that allow the user to
 * issue a search for an artist.
 * </p>
 */
public class ArtistSearchFragment extends BaseFragment
    implements ArtistSearchView, SearchResultsAdapter.ItemClickListener /*, SearchResultsAdapter.ItemClickListener */ {

  public static final String LOG_TAG = ArtistSearchFragment.class.getSimpleName();

  @Inject
  ArtistSearchPresenter mSearchPresenter;

  @Inject
  SearchResultsAdapter mResultAdapter;

  @BindView(R.id.list_artist) RecyclerView mArtistResultsList;

  @BindView(R.id.etxt_search) ClearableEditText mArtistSearchInput;


  @Override protected int getFragmentLayout() {
    return R.layout.fragment_artist_search;
  }

  @Override protected BasePresenter getPresenter() {
    return mSearchPresenter;
  }

  /**
   * Start DAGGER injection
   */
  @Override protected void setUpComponent(ApplicationComponent component) {

    //TODO: Injectamos a traves del componente usado en este fragment: ArtistsSearchComponent
    DaggerArtistsSearchComponent.builder()
        .applicationComponent(component)
        .artistSearchModule(new ArtistSearchModule( ArtistSearchFragment.this))
        .build()
        .inject(ArtistSearchFragment.this);
  }

  @Override public void setupList() {
    mArtistResultsList.setLayoutManager(new LinearLayoutManager(CONTEXT));
    mArtistResultsList.setAdapter(mResultAdapter);
  }

  @Override public void setupAdapter() {
    mResultAdapter.setOnItemClickListener(this);
  }


  @OnTextChanged(R.id.etxt_search)
  public void onQueryChanged(CharSequence query){
    if (query.length() >= 3)
      mSearchPresenter.searchArtists(query.toString());
    else if (query.length() <= 2)
      mResultAdapter.clear();
  }

  @Override public void displayFoundArtists(ArrayList<Artist> artists) {
    mResultAdapter.replace( artists);
  }

  @Override public void displayFailedSearch() {
    Toast.makeText(CONTEXT, R.string.failed_search, Toast.LENGTH_SHORT).show();
  }

  @Override public void displayNetworkError() {
    Toast.makeText(CONTEXT, R.string.network_error, Toast.LENGTH_SHORT).show();
  }

  @Override public void displayServerError() {
    Toast.makeText(CONTEXT, R.string.server_error, Toast.LENGTH_SHORT).show();
  }

  @Override public void onItemClicked(int position) {

  }
}
