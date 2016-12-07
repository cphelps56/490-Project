package edu.louisville.cischef.topmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import edu.louisville.cischef.R;
import edu.louisville.cischef.add.AddFragment;
import edu.louisville.cischef.favorite.FavoriteFragment;
import edu.louisville.cischef.recipeList.RecipeListFragment;

/**
 * Created by Max02man on 11/24/2016.
 */

public class TopMenuFragment extends Fragment{
    public TopMenuFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_menu, container, false);
        wireEvents(view);

        return view;
    }

    private void wireEvents(View view) {
        Button butadd = (Button)view.findViewById(R.id.butadd);
        butadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AddFragment());
            }
        });
        Button butview = (Button) view.findViewById(R.id.butview);
        butview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new RecipeListFragment());
            }
        });
        Button butsearch = (Button) view.findViewById(R.id.fav_bar);
        butsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FavoriteFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment2load) {

        getActivity().getFragmentManager()
                .beginTransaction()
//                .replace(R.id.fragmentContent, new RecipeListFragment())
                .replace(R.id.fragmentContent, fragment2load)

                .commit();
    }


}
