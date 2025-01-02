public class CustomAdapter extends BaseAdapter {
    private int[] imageArray;
    private String[] nameArray;
    private Context context;

    public CustomAdapter(int[] imageArray, String[] nameArray, Context context) {
        this.imageArray = imageArray;
        this.nameArray = nameArray;
        this.context = context;
    }

    // ... diğer metodlar aynı kalacak ...
} 