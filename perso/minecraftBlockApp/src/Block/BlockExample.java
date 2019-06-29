import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.image.Image;

class BlockExample extends Block {
    private int id;
    private String name;
    private double transparency;
    private double luminancy;
    private double blastResistance;
    private String toolType;
    private boolean renewable;
    private int stackable;
    private double flammable;
    private ArrayList<Integer> drops;
    private double hardness;

    // Graphics, using JavaFX
    private Image sprite;

    BlockExample() {
        setId();
        setName();
        setTransparency();
        setLuminancy();
        setBlastResistance();
        setToolType();
        setRenewable();
        setStackable();
        setFlammable();
        setDrops();
        setHardness();

        // Graphics

        setImage();
    }

    public void setId() {

    }

    public void setName() {

    }

    public void setTransparency() {

    }

    public void setLuminancy() {

    }

    public void setBlastResistance() {

    }

    public void setToolType() {

    }

    public void setRenewable() {

    }

    public void setStackable() {

    }

    public void setFlammable() {

    }

    public void setDrops() {
        this.drops = new ArrayList<Integer>(Arrays.asList());
    }

    public void setHardness() {

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getTransparency() {
        return this.transparency;
    }

    public double getLuminancy() {
        return this.luminancy;
    }

    public double getBlastResistance() {
        return this.blastResistance;
    }

    public String getToolType() {
        return this.toolType;
    }

    public boolean getRenewable() {
        return this.renewable;
    }

    public int getStackable() {
        return this.stackable;
    }

    public double getFlammable() {
        return this.flammable;
    }

    public ArrayList<Integer> getDrops() {
        return this.drops;
    }

    public double getHardness() {
        return this.hardness;
    }

    public ArrayList<Integer> breakBlock(Tool tool) {
        return new ArrayList<Integer>();
    }

    public void setImage() {
        this.sprite = new Image("file:../img/3d/stone.png");
    }

    public Image getImage() {
        return this.sprite;
    }
}