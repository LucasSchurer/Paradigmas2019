import java.util.ArrayList;
import java.util.Arrays;

class Air extends Block {
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

    Air() {
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
        this.id = 0;
    }

    public void setName() {
        this.name = "air";
    }

    public void setTransparency() {
        this.transparency = -1;
    }

    public void setLuminancy() {
        this.luminancy = 0;
    }

    public void setBlastResistance() {
        this.blastResistance = 0;
    }

    public void setToolType() {
        this.toolType = "none";
    }

    public void setRenewable() {
        this.renewable = true;
    }

    public void setStackable() {
        this.stackable = 0;
    }

    public void setFlammable() {
        this.flammable = 0;
    }

    public void setDrops() {
        this.drops = new ArrayList<Integer>();
    }

    public void setHardness() {
        this.hardness = -1;
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
        return null;
    }

    public double getHardness() {
        return this.hardness;
    }

    public ArrayList<Integer> breakBlock(Tool tool) {
        return null;
    }
}