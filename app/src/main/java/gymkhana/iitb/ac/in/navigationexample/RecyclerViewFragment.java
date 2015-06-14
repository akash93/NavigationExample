package gymkhana.iitb.ac.in.navigationexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Fragment showing items inside a {@link RecyclerView}
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<ListObject> listItems;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        //Set title for toolbar
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Recycler View");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        listItems = HomeActivity.populateListItems(rootView.getContext());
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listItems,rootView.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(adapter);
        return rootView;
    }


}
