package com.das.moviesign.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.das.moviesign.MainActivity;
import com.das.moviesign.R;
import com.das.moviesign.labs.MovieLab;

/**
 * Created by yaturner on 4/27/2017.
 */

public class SearchFragment extends Fragment
  implements View.OnClickListener
{
  private final static String TAG = SearchFragment.class.getSimpleName();

  private static SearchFragment fragment = null;
  private MainActivity mainActivity = MainActivity.getInstance();

  private FragmentManager fragmentManager = null;

  private MovieLab movieLab = null;

  private View view = null;
  private EditText titleText = null;
  private Button submitButton = null;

  public static SearchFragment newInstance(Bundle bundle) {
    SearchFragment fragment = new SearchFragment();
    fragment.fragment = fragment;
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    fragmentManager = getActivity().getSupportFragmentManager();
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    movieLab = MovieLab.get(mainActivity);

    view = inflater.inflate(R.layout.search_fragment, container, false);
    titleText = (EditText) view.findViewById(R.id.search_title);
    submitButton = (Button)view.findViewById(R.id.search_submit_button);

    submitButton.setOnClickListener(this);
    return view;
  }

  @Override
  public void onClick(View view) {
    int vId = view.getId();
    if(vId == R.id.search_submit_button) {
      String title = titleText.getText().toString().trim();
      if(title == null || title.isEmpty()) {
        Toast.makeText(getActivity(), R.string.no_title, Toast.LENGTH_LONG).show();
        return;
      }
      mainActivity.getMovieInfo(title, 1);
      ResultsFragment fragment = ResultsFragment.newInstance(null);
      fragmentManager.beginTransaction()
              .replace(R.id.fragment_container, fragment, ResultsFragment.class.getSimpleName())
              .addToBackStack(ResultsFragment.class.getSimpleName())
              .commit();
    }
  }
}