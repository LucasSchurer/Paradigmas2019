import java.util.ArrayList;
import java.util.Arrays;

class Cobblestone extends Block {
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

    Cobblestone() {
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
        this.id = 4;
    }

    public void setName() {
        this.name = "cobblestone";
    }

    public void setTransparency() {
        this.transparency = 0;
    }

    public void setLuminancy() {
        this.luminancy = 0;
    }

    public void setBlastResistance() {
        this.blastResistance = 30;
    }

    public void setToolType() {
        this.toolType = "pickaxe";
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
        this.drops = new ArrayList<Integer>(Arrays.asList(4));
    }

    public void setHardness() {
        this.hardness = 2;
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
        if (tool.getType().equals(this.getToolType()))
            return getDrops();
        else
            return null;
    }
}