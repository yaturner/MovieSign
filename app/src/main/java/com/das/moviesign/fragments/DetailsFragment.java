package com.das.moviesign.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.das.moviesign.MainActivity;
import com.das.moviesign.R;
import com.das.moviesign.constants.Constants;
import com.das.moviesign.labs.MovieLab;
import com.das.moviesign.models.MovieModel;

/**
 * Created by yaturner on 4/27/2017.
 */

public class DetailsFragment extends Fragment {
  private final static String TAG = DetailsFragment.class.getSimpleName();

  private static DetailsFragment fragment = null;
  private MainActivity mainActivity = MainActivity.getInstance();

  private MovieModel movieModel = null;

  private View view = null;
  private TextView title = null;
  private TextView original_title = null;
  private TextView release_date = null;
  private TextView overview = null;

  public static DetailsFragment newInstance(Bundle bundle) {
    DetailsFragment fragment = new DetailsFragment();
    fragment.fragment = fragment;
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    movieModel = (MovieModel) getArguments().getSerializable(Constants.ARG_SELECTED_MOVIE);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.details_fragment, container, false);
    title = (TextView) view.findViewById(R.id.details_title);
    original_title = (TextView) view.findViewById(R.id.details_original_title);
    release_date = (TextView) view.findViewById(R.id.details_release_date);
    overview = (TextView) view.findViewById(R.id.details_overview);

    title.setText(movieModel.getTitle());
    original_title.setText(movieModel.getOriginalTitle());
    release_date.setText(movieModel.getReleaseDate());
    overview.setText(movieModel.getOverview());

    return view;
  }
}