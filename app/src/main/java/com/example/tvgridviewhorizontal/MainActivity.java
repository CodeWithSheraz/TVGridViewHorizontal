package com.example.tvgridviewhorizontal;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.SinglePresenterSelector;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends LeanbackActivity {
    androidx.leanback.widget.HorizontalGridView horizontalGridView;
//    ArrayObjectAdapter arrayObjectAdapter;
    ArrayList<MovieModel> movieModels = new ArrayList<>();


    public int[] images = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9,
            R.drawable.p10,
            R.drawable.p11,
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9,
            R.drawable.p10,
            R.drawable.p11,
    };
    
    String[] title = {
            "Thor", "Captain Marvel", "Spider Man" , "Spiderman Home-Coming", "Avengers", "Doctor Strange",
            "Ant-Man", "Avengers Tabahi", "Captain Marvel Lay", "Loki", "Thor", "Captain Marvel", "Spider Man" , "Spiderman Home-Coming", "Avengers", "Doctor Strange",
            "Ant-Man", "Avengers Tabahi", "Captain Marvel Lay", "Loki"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        horizontalGridView = findViewById(R.id.horizontalGridView);
        horizontalGridView.setWindowAlignment(horizontalGridView.WINDOW_ALIGN_BOTH_EDGE);
        horizontalGridView.setWindowAlignmentOffsetPercent(35);
        horizontalGridView.setHorizontalSpacing(35);
        horizontalGridView.setNumRows(2);

        for(int i=0; i< images.length; i++){
            MovieModel temp = new MovieModel();
            temp.setMovieName(title[i]);
            temp.setMoviePoster(images[i]);
            movieModels.add(temp);
            Log.d("RowTest", "Working Data set in Model : " + title[i] );
            Log.d("RowTest", "Get data from Model : " + "" );
        }

        for (int i = 0; i < movieModels.size(); i++){
            Log.d("RowTest", movieModels.get(i).getMovieName() + "  , " + movieModels.get(i).getMoviePoster() );
        }

        ItemBridgeAdapter adapter = new ItemBridgeAdapter();
        ArrayObjectAdapter mRowsAdapter = new ArrayObjectAdapter(new CardPresenter());

        for (int j = 0; j < movieModels.size(); j++) {
            mRowsAdapter.add(movieModels.get(j));
//            mRowsAdapter.add(title[j]);
        }
//        new ListRow(headerItem, arrayObjectAdapter1)
        adapter.setAdapter(mRowsAdapter);
        horizontalGridView.setAdapter(adapter);


//        RecyclerView.Adapter<ViewHolder> customAdapter = new CustomAdapter(images, title, this);
////        customAdapter.setPresenter(new SinglePresenterSelector(new ListRowPresenter()));
//        horizontalGridView.setAdapter(customAdapter);

    }
}