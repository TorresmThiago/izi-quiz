package edu.infnet.al.izi_quiz.Assets.MatchPlayed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.infnet.al.izi_quiz.Assets.FontChangeCrawler;
import edu.infnet.al.izi_quiz.R;

public class HistoricAdapter extends RecyclerView.Adapter<HistoricAdapter.MatchPlayedHolder> {

    public static MatchPlayedItemClick matchPlayedItemClick;
    private final ArrayList<MatchPlayed> matchesPlayed;
    Context context;

    public HistoricAdapter(Context context, ArrayList<MatchPlayed> matchesPlayed, MatchPlayedItemClick matchPlayedItemClick) {
        this.matchPlayedItemClick = matchPlayedItemClick;
        this.matchesPlayed = matchesPlayed;
        this.context = context;
    }

    @NonNull
    @Override
    public MatchPlayedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.asset_itemlist, parent, false);

        FontChangeCrawler fontChanger = new FontChangeCrawler(context.getAssets(), "fonts/neutra_text_bold.OTF");
        fontChanger.replaceFonts((ViewGroup) itemView);

        return new MatchPlayedHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MatchPlayedHolder holder, final int position) {
        holder.matchDate.setText(position + ", fev. 2018 ");
    }

    @Override
    public int getItemCount() {
        return matchesPlayed.size();
    }

    class MatchPlayedHolder extends RecyclerView.ViewHolder {
        ImageView matchBackground;
        TextView matchDate;

        public MatchPlayedHolder(@NonNull View itemView) {
            super(itemView);

            this.matchBackground = itemView.findViewById(R.id.ItemListBackground);
            this.matchDate = itemView.findViewById(R.id.ItemListName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    matchPlayedItemClick.onMatchClick(matchesPlayed.get(getLayoutPosition()));
                }
            });
        }
    }
}
