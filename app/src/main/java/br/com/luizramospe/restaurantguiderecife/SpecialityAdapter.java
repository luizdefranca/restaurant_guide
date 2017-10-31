package br.com.luizramospe.restaurantguiderecife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luizramos on 30/10/17.
 */

public class SpecialityAdapter extends BaseAdapter {
    private Context context;
    private List<String> restaurantSpecialities;
    private List<String> specialityImage;
    public SpecialityAdapter(Context context, List<String> restaurantSpecialities, List<String> specialityImage) {
        super();
        this.restaurantSpecialities = restaurantSpecialities;
        this.specialityImage = specialityImage;
        this.context = context;
    }


    // CONFIGURE CELL
    @Override
    public View getView(int position, View cell, ViewGroup parent) {
        if (cell == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cell = inflater.inflate(R.layout.especialities_cell, null);
        }

        ImageView specialityImg = (ImageView)cell.findViewById(R.id.specialityImage);

        String resourceImageName = specialityImage.get(position);
        int resID = cell.getResources().getIdentifier(resourceImageName, "drawable", context.getPackageName());
        specialityImg.setImageResource(resID);

        String specialityName = restaurantSpecialities.get(position);
        TextView specialityTitle = (TextView) cell.findViewById(R.id.specialityTitleTxt);
        specialityTitle.setText(specialityName);

        return cell;
    }

    @Override
    public int getCount() { return restaurantSpecialities.size(); }
    @Override
    public Object getItem(int position) { return restaurantSpecialities.get(position); }
    @Override
    public long getItemId(int position) { return position; }
}
