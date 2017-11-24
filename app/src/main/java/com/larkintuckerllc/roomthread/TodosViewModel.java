package com.larkintuckerllc.roomthread;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.larkintuckerllc.roomthread.db.AppDatabase;
import com.larkintuckerllc.roomthread.db.Todo;
import java.util.List;

public class TodosViewModel extends AndroidViewModel {

    public final LiveData<List<Todo>> todos;

    private AppDatabase mDb;

    public TodosViewModel(Application application) {
        super(application);
        mDb = AppDatabase.getDatabase(getApplication());
        todos = mDb.todoModel().findAllTodos();
    }

    public void addTodo(String name, long date) {
        Todo todo = new Todo();
        todo.name = name;
        todo.date = date;
        new Thread(() -> {
            mDb.todoModel().insertTodo(todo);
        }).start();
    }

    public void removeTodo(int id) {
        Todo todo = new Todo();
        todo.id = id;
        new Thread(() -> {
            mDb.todoModel().deleteTodo(todo);
        }).start();
    }

}
