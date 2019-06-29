abstract class Tool extends Entity implements ToolGraphics {
    abstract public void setType();

    abstract public void setRarity();

    abstract public void setMaterial();

    abstract public void setDurability();

    abstract public void setDamage();

    abstract public String getType();

    abstract public String getRarity();

    abstract public String getMaterial();

    abstract public int getDurability();

    abstract public int getDamage();

    abstract public void rightClick();
}