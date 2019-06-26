import java.util.ArrayList;

class Inventory {
    private int size;
    private ArrayList<Entity> entities;

    Inventory(int size) {
        setSize(size);

        this.entities = new ArrayList<Entity>();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isFull() {
        if (entities.size() == size) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (entities.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void addEntity(Entity entity) {
        if (entity != null)
            if (!this.isFull())
                this.entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        if (entity != null)
            if (!this.isEmpty())
                this.entities.remove(entity);
    }

    public void addEntities(ArrayList<Entity> entities) {
        for (Entity entity : entities) {
            this.addEntity(entity);
        }
    }

    public void removeEntities(ArrayList<Entity> entities) {
        for (Entity entity : entities) {
            this.removeEntity(entity);
        }
    }

    public void printInventory() {
        for (Entity entity : this.entities)
            if (entity != null)
                System.out.println(entity.getName());
            else
                System.out.println("error");
    }
}