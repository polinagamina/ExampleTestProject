package org.example;

public class OrderItem {
    private int id;
    public String action;
    private String name;

    public OrderItem(int id, String name, String action) {
        this.id = id;
        this.name = name;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
