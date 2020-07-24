package com.ty.seedoctor.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ty.seedoctor.R;
import com.ty.seedoctor.bean.AnswerItme;

import java.util.List;

public class AnserAdapter extends RecyclerView.Adapter<AnserAdapter.AnserVH> {

    private List<AnswerItme> answerItmeList ;

    public AnserAdapter(List<AnswerItme> answerItmeList) {
        this.answerItmeList = answerItmeList;
    }

    @NonNull
    @Override
    public AnserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());
        return new AnserVH(mLayoutInflater.inflate(R.layout.recycleview_item_answer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnserVH holder, int position) {
        holder.question.setText(answerItmeList.get(position).getAsk());
        holder.answer.setText(answerItmeList.get(position).getAnswer());
        holder.answerAuthor.setText(answerItmeList.get(position).getAuther());
    }

    @Override
    public int getItemCount() {
        return answerItmeList.size();
    }

    class AnserVH extends RecyclerView.ViewHolder{
        private TextView question;
        private TextView answer;
        private TextView answerAuthor;

        public AnserVH(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            answer = itemView.findViewById(R.id.answer);
            answerAuthor = itemView.findViewById(R.id.answer_author);
        }
    }
}
