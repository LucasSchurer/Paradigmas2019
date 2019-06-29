import javafx.scene.image.Image;

class WoodenPickaxe extends Tool {
    private int id;
    private String name;
    private String type;
    private String rarity;
    private String material;
    private int durability;
    private boolean renewable;
    private int stackable;
    private int damage;

    // Graphics, using JavaFX
    private Image sprite;

    WoodenPickaxe() {
        setId();
        setName();
        setType();
        setRarity();
        setMaterial();
        setDurability();
        setRenewable();
        setDamage();

        // Graphics

        setImage();
    }

    public void setId() {
        this.id = 270;
    }

    public void setName() {
        this.name = "wooden_pickaxe";
    }

    public void setType() {
        this.type = "pickaxe";
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
        this.damage = 2;
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

    public void setImage() {
        this.sprite = new Image("file:../img/2d/wooden_pickaxe.png");
    }

    public Image getImage() {
        return this.sprite;
    }
}