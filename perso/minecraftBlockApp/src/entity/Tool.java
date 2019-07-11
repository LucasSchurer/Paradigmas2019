package entity;

import javafx.util.Pair;

public abstract class Tool extends Entity {
    private String type;
    private String rarity;
    private String material;
    private int durability;
    private int damage;

    public abstract Pair<Block, Tool> rightClick(Block block);

    // Setters

    public void setType(String type) {
        this.type = type;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    // Getters

    public String getType() {
        return type;
    }

    public String getRarity() {
        return rarity;
    }

    public String getMaterial() {
        return material;
    }

    public int getDurability() {
        return durability;
    }

    public int getDamage() {
        return damage;
    }
}