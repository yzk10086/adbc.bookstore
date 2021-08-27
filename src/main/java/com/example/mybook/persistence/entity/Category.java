package com.example.mybook.persistence.entity;

public class Category {
    private long id;
    private String name;
    private boolean root;
    private long parentId;
    private Category[] children;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public Category[] getChildren() {
        return children;
    }

    public void setChildren(Category[] children) {
        this.children = children;
    }
}
