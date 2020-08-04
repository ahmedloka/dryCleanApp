package my.apps.nada.project.dry.clean.activites.adapters.rv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.utilites.CairoBoldTextView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private final HomeAdapter.OnClickHandler onClickHandler;
    private final List<String> listImgUrls;
    private final List<String> listNames;
    private final List<String> listLocations;
    private final List<String> listCovers;

    private Context context;

    public HomeAdapter(Context context, List<String> mListNames, List<String> mListLocation, List<String> mListImages, List<String> mListImagesCover, HomeAdapter.OnClickHandler onClickHandler) {
        this.context = context;
        this.listNames = mListNames;
        this.listImgUrls = mListImages;
        this.listCovers = mListImagesCover;
        this.listLocations = mListLocation;
        this.onClickHandler = onClickHandler;
    }

    @Override
    public int getItemCount() {
        return listNames == null ? 0 : listNames.size();
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_rv, parent, false);
        return new HomeAdapter.ViewHolder(view);
    }

    private void removeAt(int position) {
        listNames.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listNames.size());
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeAdapter.ViewHolder holder, final int listPosition) {
        try {

            holder.location.setText(listLocations.get(listPosition));
            holder.name.setText(listNames.get(listPosition));

            Picasso.get()
                    .load(listImgUrls.get(listPosition))
                    .fit()
                    .centerCrop()
                    .into(holder.img);


            Picasso.get()
                    .load(listCovers.get(listPosition))
                    .fit()
                    .centerCrop()
                    .into(holder.cover);
        } catch (Exception ignored) {

        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public interface OnClickHandler {
        void onClick(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private AppCompatImageView cover;
        private CircleImageView img;
        private CairoBoldTextView name, location;

        ViewHolder(View itemView) {
            super(itemView);

            initViews(itemView);
        }

        private void initViews(View itemView) {

            img = itemView.findViewById(R.id.img);
            cover = itemView.findViewById(R.id.img_cover);
            name = itemView.findViewById(R.id.name);
            location = itemView.findViewById(R.id.location);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            onClickHandler.onClick(position);
        }
    }
}



