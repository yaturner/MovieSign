package com.das.moviesign.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
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

    int pos1, pos;

    SpannableStringBuilder ssb = new SpannableStringBuilder();
    ssb.append(getActivity().getString(R.string.title));
    pos = ssb.length();
    ssb.append(Constants.LINE_SEPERATOR);
    ssb.append(movieModel.getTitle());
    ssb.setSpan(new AbsoluteSizeSpan(18, true), 0, pos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    ssb.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), android.R.color.holo_blue_light)), pos, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    title.setText(ssb);

    ssb = new SpannableStringBuilder();
    ssb.append(getActivity().getString(R.string.original_title));
    pos = ssb.length();
    ssb.append(Constants.LINE_SEPERATOR);
    ssb.append(movieModel.getOriginalTitle());
    ssb.setSpan(new AbsoluteSizeSpan(18, true), 0, pos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    ssb.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), android.R.color.holo_blue_light)), pos, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    original_title.setText(ssb);

    ssb = new SpannableStringBuilder();
    ssb.append(getActivity().getString(R.string.release_date));
    pos = ssb.length();
    ssb.append(Constants.LINE_SEPERATOR);
    ssb.append(movieModel.getReleaseDate());
    ssb.setSpan(new AbsoluteSizeSpan(18, true), 0, pos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    ssb.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), android.R.color.holo_blue_light)), pos, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    release_date.setText(ssb);

    ssb = new SpannableStringBuilder();
    ssb.append(getActivity().getString(R.string.overview));
    pos = ssb.length();
    ssb.append(Constants.LINE_SEPERATOR);
    ssb.append(movieModel.getOverview());
    ssb.setSpan(new AbsoluteSizeSpan(18, true), 0, pos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    ssb.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), android.R.color.holo_blue_light)), pos, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    overview.setText(ssb);



    return view;
  }
}