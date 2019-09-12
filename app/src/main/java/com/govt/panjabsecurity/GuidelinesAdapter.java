package com.govt.panjabsecurity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GuidelinesAdapter  extends RecyclerView.Adapter<GuidelinesAdapter.CardHolder>{
    private ArrayList<Guidelines_card> cardList;
    private GuidelinesAdapter.OnItemClickListener clickListener;

    public GuidelinesAdapter(ArrayList<Guidelines_card> cardList){
        this.cardList=cardList;
    }

    public void setOnItemClickListener(GuidelinesAdapter.OnItemClickListener listener){
        clickListener = listener;
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public static class CardHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView;

        public CardHolder(View cardView, final GuidelinesAdapter.OnItemClickListener listener){
            super(cardView);
            mImageView = cardView.findViewById(R.id.imageView);
            mTextView = cardView.findViewById(R.id.textView);

            cardView.setOnClickListener(new  View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public GuidelinesAdapter.CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_guidelines2, parent, false);
        GuidelinesAdapter.CardHolder ch = new GuidelinesAdapter.CardHolder(v,clickListener );
        return ch;
    }

    @Override
    public void onBindViewHolder(@NonNull GuidelinesAdapter.CardHolder holder, int position) {
        Guidelines_card currentItem = cardList.get(position);
        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView.setText(currentItem.getText());

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
}
