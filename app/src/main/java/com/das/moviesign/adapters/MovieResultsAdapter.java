package com.das.moviesign.adapters;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.das.moviesign.R;
import com.das.moviesign.models.MovieModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaturner on 4/27/2017.
 */

public class MovieResultsAdapter extends ArrayAdapter {
  private ArrayList<MovieModel> objects = null;
  private Context context = null;
  private LayoutInflater layoutInflater = null;
  private int resId;

  public MovieResultsAdapter(@NonNull Context context, @NonNull int resource, @NonNull ArrayList<MovieModel> objects) {
    super(context, resource, objects);
    this.context = context;
    this.objects = objects;
    this.resId = resource;
    this.layoutInflater = LayoutInflater.from(context);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // Get the data item for this position
    final MovieModel movieModel = objects.get(position);
    Holder holder = null;

    if(convertView == null) {
      holder = new Holder();
      convertView = layoutInflater.inflate(resId, parent, false);
      holder.titleView = (TextView) convertView.findViewById(R.id. result_item_title);
      holder.movieModel = movieModel;
      convertView.setTag(holder);
    }
    else
    {
      holder = (Holder) convertView.getTag();
    }

    holder.titleView.setText(movieModel.getTitle());

    return convertView;
  }

  public class Holder {
    public TextView titleView = null;
    public MovieModel movieModel = null;
  }
}
