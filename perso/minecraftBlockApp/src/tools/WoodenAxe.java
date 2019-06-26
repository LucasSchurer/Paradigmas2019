class WoodenAxe extends Tool {
    private int id;
    private String name;
    private String type;
    private String rarity;
    private String material;
    private int durability;
    private boolean renewable;
    private int stackable;
    private int damage;

    WoodenAxe() {
        setId();
        setName();
        setType();
        setRarity();
        setMaterial();
        setDurability();
        setRenewable();
        setDamage();
    }

    public void setId() {
        this.id = 271;
    }

    public void setName() {
        this.name = "wooden_axe";
    }

    public void setType() {
        this.type = "axe";
    }

    public void setRarity() {
        this.rarity = "common";
    }

    public void setMaterial() {
        this.material = "wood";
    }

    public void setDurability() {
        this.durability = 60;
    }

    public void setRenewable() {
        this.renewable = true;
    }

    public void setStackable() {
        this.stackable = 1;
    }

    public void setDamage() {
        this.damage = 7;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getRarity() {
        return this.rarity;
    }

    public String getMaterial() {
        return this.material;
    }

    public int getDurability() {
        return this.durability;
    }

    public boolean getRenewable() {
        return this.renewable;
    }

    public int getStackable() {
        return this.stackable;
    }

    public int getDamage() {
        return this.damage;
    }

    public void rightClick() {

    }
}