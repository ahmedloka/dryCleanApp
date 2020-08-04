package my.apps.nada.project.dry.clean.activites.adapters.rv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.utilites.CairoBoldTextView;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ViewHolder> {

    private final NotificationsAdapter.OnClickHandler onClickHandler;
    private final List<String> listImgUrls;
    private final List<String> listNames;
    private Context context;

    public NotificationsAdapter(Context context, List<String> listImgUrls, List<String> listNames, NotificationsAdapter.OnClickHandler onClickHandler) {
        this.context = context;
        this.listNames = listNames;
        this.listImgUrls = listImgUrls;
        this.onClickHandler = onClickHandler;
    }

    @Override
    public int getItemCount() {
        return listNames == null ? 0 : listNames.size();
    }

    @NonNull
    @Override
    public NotificationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notifications, parent, false);
        return new NotificationsAdapter.ViewHolder(view);
    }

    private void removeAt(int position) {
        listNames.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listNames.size());
    }

    @Override
    public void onBindViewHolder(@NonNull final NotificationsAdapter.ViewHolder holder, final int listPosition) {
        try {

            holder.txt.setText(listNames.get(listPosition));

            Picasso.get()
                    .load(listImgUrls.get(listPosition))
                    .fit()
                    .centerCrop()
                    .into(holder.img);
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

        private CircleImageView img;
        private CairoBoldTextView txt;

        ViewHolder(View itemView) {
            super(itemView);

            initViews(itemView);
        }

        private void initViews(View itemView) {

            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txt_desc);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            onClickHandler.onClick(position);
        }
    }
}



