package sg.edu.rp.c346.id22023330.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvMovieTitle);
        TextView tvGenre = rowView.findViewById(R.id.tvGenre);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);

        Movie currentVersion = movieList.get(position);

        tvTitle.setText(currentVersion.getTitle());
        tvGenre.setText(currentVersion.getGenre());
        tvYear.setText(String.valueOf(currentVersion.getYear()));

        if (currentVersion.getRating().equals("G")) {
            Picasso.with(parent_context)
                    .load("https://www.imda.gov.sg/-/media/imda/images/content/regulation-licensing-and-consultations/content-standards-and-classification/classification-rating/general-rating.webp")
                    .placeholder(R.drawable.rating_g)
                    .into(ivRating);
        } else if (currentVersion.getRating().equals("PG")) {
            Picasso.with(parent_context)
                    .load("https://www.imda.gov.sg/-/media/imda/images/content/regulation-licensing-and-consultations/content-standards-and-classification/classification-rating/pg-rating.webp")
                    .placeholder(R.drawable.rating_pg)
                    .into(ivRating);
        } else if (currentVersion.getRating().equals("PG13")) {
            Picasso.with(parent_context)
                    .load("https://www.imda.gov.sg/-/media/imda/images/content/regulation-licensing-and-consultations/content-standards-and-classification/classification-rating/pg13-rating.webp")
                    .placeholder(R.drawable.rating_pg13)
                    .into(ivRating);
        } else if (currentVersion.getRating().equals("NC16")) {
            Picasso.with(parent_context)
                    .load("https://www.imda.gov.sg/-/media/imda/images/content/regulation-licensing-and-consultations/content-standards-and-classification/classification-rating/nc16-rating.webp")
                    .placeholder(R.drawable.rating_nc16)
                    .into(ivRating);
        } else if (currentVersion.getRating().equals("M18")) {
            Picasso.with(parent_context)
                    .load("https://www.imda.gov.sg/-/media/imda/images/content/regulation-licensing-and-consultations/content-standards-and-classification/classification-rating/m18-rating.webp")
                    .placeholder(R.drawable.rating_m18)
                    .into(ivRating);
        } else if (currentVersion.getRating().equals("R21")) {
            Picasso.with(parent_context)
                    .load("https://www.imda.gov.sg/-/media/imda/images/content/regulation-licensing-and-consultations/content-standards-and-classification/classification-rating/r21-rating.webp")
                    .placeholder(R.drawable.rating_r21)
                    .into(ivRating);
        }

        return rowView;
    }

}
