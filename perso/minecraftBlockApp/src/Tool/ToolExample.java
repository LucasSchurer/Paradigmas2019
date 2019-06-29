import javafx.scene.image.Image;

class ToolExample extends Tool {
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

    ToolExample() {
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

    }

    public void setName() {

    }

    public void setType() {

    }

    public void setRarity() {

    }

    public void setMaterial() {

    }

    public void setDurability() {

    }

    public void setRenewable() {

    }

    public void setStackable() {

    }

    public void setDamage() {

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
        this.sprite = new Image("file:../img/3d/stone.png");
    }

    public Image getImage() {
        return this.sprite;
    }
}