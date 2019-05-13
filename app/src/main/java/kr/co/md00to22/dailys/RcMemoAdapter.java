package kr.co.md00to22.dailys;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RcMemoAdapter extends RecyclerView.Adapter {

    ArrayList<Memo> memoes;
    Context context;

    public RcMemoAdapter(ArrayList<Memo> memoes, Context context) {
        this.memoes = memoes;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.recycler_memolist, viewGroup, false);

        VH holder=new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Memo memo=memoes.get(i);
        VH holder=(VH)viewHolder;

        if(memo.getTexts().size()!=0)holder.memo_content.setText(memo.getTexts().get(0));

        if(memo.getPhotos().size()==0) {
            //holder.meom_thumbnail.setImageURI(memo.getPhotos().get(0));
        }
        if (memo.getTitle()==null || memo.getTitle().equals("")){
            holder.memo_title.setVisibility(View.GONE);
        }else{
            holder.memo_title.setText(memo.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return memoes.size();
    }


    class VH extends RecyclerView.ViewHolder{

        ImageView memo_thumbnail;
        TextView memo_title, memo_content;

        public VH(@NonNull View itemView) {
            super(itemView);

            memo_thumbnail=itemView.findViewById(R.id.memo_thumbnail);
            memo_title=itemView.findViewById(R.id.memo_title);
            memo_content=itemView.findViewById(R.id.memo_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "준비중", Toast.LENGTH_SHORT).show();
                    //todo:한번 클릭 : Read창 띄우기
                }
            });
        }
    }
}
