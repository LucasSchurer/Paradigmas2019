import java.util.ArrayList;

class Inventory {
    private Player player;
    private int size;
    private Entity selectedEntity;
    private int selectedHotkey;
    private ArrayList<Entity> entities;

    Inventory(int size) {
        setSize(size);
        setSelectedHotkey(0);
        this.player = null;

        this.entities = new ArrayList<Entity>();
    }

    Inventory(int size, Player player) {
        setSize(size);
        setSelectedHotkey(0);
        setPlayer(player);

        player.setInventory(this);

        this.entities = new ArrayList<Entity>();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSelectedHotkey(int hotkey) {
        this.selectedHotkey = hotkey;
    }

    public void setSelectedEntity() {
        this.selectedEntity = entities.get(this.selectedHotkey);
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getSize() {
        return this.size;
    }

    public int getSelectedHotkey() {
        return this.selectedHotkey;
    }

    public Entity getSelectedEntity() {
        return this.selectedEntity;
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