import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.scene.image.Image;

class Gravel extends Block {
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

    Gravel() {
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
        this.id = 13;
    }

    public void setName() {
        this.name = "gravel";
    }

    public void setTransparency() {
        this.transparency = 0;
    }

    public void setLuminancy() {
        this.luminancy = 0;
    }

    public void setBlastResistance() {
        this.blastResistance = 3;
    }

    public void setToolType() {
        this.toolType = "shovel";
    }

    public void setRenewable() {
        this.renewable = false;
    }

    public void setStackable() {
        this.stackable = 64;
    }

    public void setFlammable() {
        this.flammable = 0;
    }

    public void setDrops() {
        Random random = new Random();
        int drop = random.nextInt(100);
        drop++;
        if (drop > 90) {
            drop = 318;
        } else {
            drop = 13;
        }

        this.drops = new ArrayList<Integer>(Arrays.asList(drop));
    }

    public void setHardness() {
        this.hardness = 0.6;
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
        return this.getDrops();
    }

    public void setImage() {
        this.sprite = new Image("file:../img/3d/stone.png");
    }

    public Image getImage() {
        return this.sprite;
    }
}