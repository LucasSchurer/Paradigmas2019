package entity;

public class Entity extends Graphics {
    private int id;
    private String name;
    private boolean renewable;
    private int stackable;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRenewable(boolean renewable) {
        this.renewable = renewable;
    }

    public void setStackable(int stackable) {
        this.stackable = stackable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isRenewable() {
        return renewable;
    }

    public int getStackable() {
        return stackable;
    }
}