package gymkhana.iitb.ac.in.navigationexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by akash on 14/6/15.
 * Adapter for recycler view
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ListObjectViewHolder> {

    private List<ListObject> listItems;
    private Context context;

    public RecyclerViewAdapter(List<ListObject> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p/>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p/>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int)}. Since it will be re-used to display different
     * items in the data set, it is a good idea to cache references to sub views of the View to
     * avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @Override
    public ListObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_layout,null);
        ListObjectViewHolder viewHolder = new ListObjectViewHolder(view);

        return viewHolder;
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method
     * should update the contents of the {@link ViewHolder#itemView} to reflect the item at
     * the given position.
     * <p/>
     * Note that unlike {@link ListView}, RecyclerView will not call this
     * method again if the position of the item changes in the data set unless the item itself
     * is invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside this
     * method and should not keep a copy of it. If you need the position of an item later on
     * (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will have
     * the updated adapter position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ListObjectViewHolder holder, int position) {
        final ListObject currentListObject = listItems.get(position);
        holder.imageView.setImageResource(currentListObject.getImageResource());
        holder.textTitle.setText(currentListObject.getTextTitle());
        holder.textContent.setText(currentListObject.getTextContent());
        if (currentListObject.isBookmarked()){
            holder.bookmarkIcon.setImageResource(R.drawable.ic_bookmark_white_24dp);
        }else{
            holder.bookmarkIcon.setImageResource(R.drawable.ic_bookmark_outline_white_24dp);
        }
        holder.bookmarkIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentListObject.setIsBookmarked(!currentListObject.isBookmarked());
                notifyDataSetChanged();
            }
        });
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return listItems.size();
    }

    /**
     * ViewHolder class for list items
     */
    public static class ListObjectViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textTitle;
        TextView textContent;
        ImageView bookmarkIcon;

        public ListObjectViewHolder(View rootView) {
            super(rootView);
            imageView = (ImageView) rootView.findViewById(R.id.image_view);
            textTitle = (TextView) rootView.findViewById(R.id.title_text);
            textContent = (TextView) rootView.findViewById(R.id.content_text);
            bookmarkIcon = (ImageView) rootView.findViewById(R.id.iv_bookmark);
        }
    }
}
