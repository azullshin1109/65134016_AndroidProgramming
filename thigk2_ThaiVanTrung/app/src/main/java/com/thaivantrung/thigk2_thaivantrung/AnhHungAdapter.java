package com.thaivantrung.thigk2_thaivantrung;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnhHungAdapter extends RecyclerView.Adapter<AnhHungAdapter.HeroViewHolder> {
    private final List<AnhHung> heroes;
    private final Context context;

    public HeroAdapter(Context context, List<AnhHung> heroes) {
        this.context = context;
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        AnhHung hero = heroes.get(position);
        holder.tvName.setText(hero.name);
        holder.tvHometown.setText("📍 Quê quán: " + hero.hometown);
        holder.imgPlaceholder.setBackgroundColor(hero.colorRes);
        // Show initials in placeholder
        String[] parts = hero.name.split(" ");
        String initial = parts[parts.length - 1].substring(0, 1);
        holder.tvInitial.setText(initial);
    }

    @Override
    public int getItemCount() { return heroes.size(); }

    static class HeroViewHolder extends RecyclerView.ViewHolder {
        LinearLayout imgPlaceholder;
        TextView tvInitial, tvName, tvHometown;
        HeroViewHolder(View v) {
            super(v);
            imgPlaceholder = v.findViewById(R.id.img_placeholder);
            tvInitial = v.findViewById(R.id.tv_initial);
            tvName = v.findViewById(R.id.tv_hero_name);
            tvHometown = v.findViewById(R.id.tv_hero_hometown);
        }
    }
}
