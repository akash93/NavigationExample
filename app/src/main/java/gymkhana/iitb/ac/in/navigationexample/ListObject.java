package gymkhana.iitb.ac.in.navigationexample;

/**
 * Created by akash on 14/6/15.
 * Object instance of each list item
 */
public class ListObject {
    private int imageResource;
    private String textTitle;
    private String textContent;
    private boolean isBookmarked;

    public ListObject(int imageResource, String textTitle, String textContent) {
        this.imageResource = imageResource;
        this.textTitle = textTitle;
        this.textContent = textContent;
        this.isBookmarked = false;
    }

    public boolean isBookmarked() {
        return isBookmarked;
    }

    public void setIsBookmarked(boolean isBookmarked) {
        this.isBookmarked = isBookmarked;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
