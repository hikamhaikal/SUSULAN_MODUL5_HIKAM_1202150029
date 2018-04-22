package id.simplify.hikam_1202150029_modul5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by simplify on 22/03/18.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {

    private List<TodoList> mTodoList;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public TodoListAdapter(List<TodoList> mTodoList, Context mContext, RecyclerView mRecyclerView) {
        this.mTodoList = mTodoList;
        this.mContext = mContext;
        this.mRecyclerView = mRecyclerView;
    }

    @Override
    public TodoListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.activity_simple_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TodoListAdapter.ViewHolder holder, int position) {
        final TodoList todoList = mTodoList.get(position);
        holder.tvTodo.setText(todoList.getTodo());
        holder.tvDescription.setText(todoList.getDescription());
        holder.tvPriority.setText(todoList.getPriority());
    }

    @Override
    public int getItemCount() {
        return mTodoList.size();
    }

    public void add(int position, TodoList todoList) {
        mTodoList.add(position, todoList);
        notifyItemInserted(position);
    }


    public void remove(int position) {
        mTodoList.remove(position);
        notifyItemRemoved(position);
        notifyItemChanged(position, mTodoList.size());
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTodo, tvDescription, tvPriority;
        View layout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            tvTodo = (TextView) itemView.findViewById(R.id.tvTodo);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            tvPriority = (TextView) itemView.findViewById(R.id.tvPriority);
        }
    }
}
