package gymkhana.iitb.ac.in.navigationexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Fragment showing items inside a {@link ListView}
 */
public class ListViewFragment extends Fragment {

    private ListView listView;
    private List<ListObject> listItems;

    public ListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list_view, container, false);
        //Set toolbar title
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("List View");
        listView = (ListView) rootView.findViewById(R.id.list_view);
        listItems = HomeActivity.populateListItems(rootView.getContext());
        ListViewAdapter adapter = new ListViewAdapter(listItems,rootView.getContext());
        listView.setAdapter(adapter);
        return rootView;
    }


}
