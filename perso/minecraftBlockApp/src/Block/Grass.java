import java.util.ArrayList;
import java.util.Arrays;

class Grass extends Block {
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

    Grass() {
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
    }

    public void setId() {
        this.id = 2;
    }

    public void setName() {
        this.name = "grass";
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
        this.renewable = true;
    }

    public void setStackable() {
        this.stackable = 64;
    }

    public void setFlammable() {
        this.flammable = 0;
    }

    public void setDrops() {
        this.drops = new ArrayList<Integer>(Arrays.asList(3));
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
}