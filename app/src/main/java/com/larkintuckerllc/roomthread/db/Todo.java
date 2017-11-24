package com.larkintuckerllc.roomthread.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Todo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public long date;

    public boolean equals(Todo todo) {
        return todo.id == id &&
                todo.name == name &&
                todo.date == date;
    }
}
