class Player {
    private String name;
    private Inventory inventory;

    Player(String name) {
        setName(name);
        Inventory inventory = new Inventory(36);
        setInventory(inventory);
    }

    Player(String name, Inventory inventory) {
        setName(name);
        setInventory(inventory);

        inventory.setPlayer(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return this.name;
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}