package my.apps.ahmed.emad.dry.clean.activites.adapters.rv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import my.apps.ahmed.emad.dry.clean.R;
import my.apps.ahmed.emad.dry.clean.activites.utilites.CairoBoldButton;
import my.apps.ahmed.emad.dry.clean.activites.utilites.CairoRegularTextView;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.ViewHolder> {

    private final MyOrdersAdapter.OnClickHandler onClickHandler;
    private final List<String> listImgUrls;
    private final List<String> listNames;
    private final List<String> listNums;
    private final List<String> listDates;
    private Context context;

    public MyOrdersAdapter(Context context, List<String> listImgUrls, List<String> listNames, List<String> listDates, List<String> listNums, MyOrdersAdapter.OnClickHandler onClickHandler) {
        this.context = context;
        this.listNames = listNames;
        this.listDates = listDates;
        this.listNums = listNums;
        this.listImgUrls = listImgUrls;
        this.onClickHandler = onClickHandler;
    }

    @Override
    public int getItemCount() {
        return listNames == null ? 0 : listNames.size();
    }

    @NonNull
    @Override
    public MyOrdersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_order, parent, false);
        return new MyOrdersAdapter.ViewHolder(view);
    }

    private void removeAt(int position) {
        listNames.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listNames.size());
    }

    @Override
    public void onBindViewHolder(@NonNull final MyOrdersAdapter.ViewHolder holder, final int listPosition) {
        try {

            holder.txtName.setText(listNames.get(listPosition));
            holder.txtDate.setText(listDates.get(listPosition));
            holder.txtOrderNum.setText(listNums.get(listPosition));

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
        private AppCompatImageView img;
        private CairoRegularTextView txtName;
        private CairoRegularTextView txtDate;
        private CairoRegularTextView txtOrderNum;
        private CairoBoldButton btnStatus;


        ViewHolder(View itemView) {
            super(itemView);

            initViews(itemView);
        }

        private void initViews(View itemView) {
            img = itemView.findViewById(R.id.img);
            txtName = itemView.findViewById(R.id.txt_name);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtOrderNum = itemView.findViewById(R.id.txt_order_num);
            btnStatus = itemView.findViewById(R.id.btn_status);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            onClickHandler.onClick(position);
        }
    }
}




