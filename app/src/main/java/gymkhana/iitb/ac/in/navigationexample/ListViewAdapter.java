package gymkhana.iitb.ac.in.navigationexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by akash on 14/6/15.
 * Adapter for the listview
 */
public class ListViewAdapter extends BaseAdapter {

    private List<ListObject> listItems;
    private Context context;

    public ListViewAdapter(List<ListObject> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return listItems.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     * We dont need this method so not changing anything
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = convertView;
        final ListObject currentListObject = listItems.get(position);
        RecyclerViewAdapter.ListObjectViewHolder viewHolder;
        if (rootView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = inflater.inflate(R.layout.list_item_layout,null);
            viewHolder = new RecyclerViewAdapter.ListObjectViewHolder(rootView);
            rootView.setTag(viewHolder);
        }else{
            viewHolder = (RecyclerViewAdapter.ListObjectViewHolder) rootView.getTag();
        }

        viewHolder.imageView.setImageResource(currentListObject.getImageResource());
        viewHolder.textTitle.setText(currentListObject.getTextTitle());
        viewHolder.textContent.setText(currentListObject.getTextContent());
        if (currentListObject.isBookmarked()){
            viewHolder.bookmarkIcon.setImageResource(R.drawable.ic_bookmark_white_24dp);
        }else{
            viewHolder.bookmarkIcon.setImageResource(R.drawable.ic_bookmark_outline_white_24dp);
        }
        viewHolder.bookmarkIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * {@link notifyDataSetChanged} should be called when a list Item updates
                 * In this case we are updating the icon state on click
                 * so this method will inform the adapter that the dataset has changed
                 * and the adapter should refresh itself
                 */
                currentListObject.setIsBookmarked(!currentListObject.isBookmarked());
                notifyDataSetChanged();
            }
        });

        return rootView;
    }
}
