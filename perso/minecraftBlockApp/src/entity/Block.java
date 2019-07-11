package entity;

import java.util.ArrayList;

public abstract class Block extends Entity {
    private boolean transparency;
    private int luminancy;
    private double blastResistance;
    private String toolType;
    private boolean flammable;
    private ArrayList<Integer> drops;
    private double hardness;

    public abstract ArrayList<Integer> breakBlock(Tool tool);

    // Setters

    public void setTransparency(boolean transparency) {
        this.transparency = transparency;
    }

    public void setLuminancy(int luminancy) {
        this.luminancy = luminancy;
    }

    public void setBlastResistance(double blastResistance) {
        this.blastResistance = blastResistance;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public void setFlammable(boolean flammable) {
        this.flammable = flammable;
    }

    public void setDrops(ArrayList<Integer> drops) {
        this.drops = drops;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    // Getters

    public boolean isTransparency() {
        return transparency;
    }

    public int getLuminancy() {
        return luminancy;
    }

    public double getBlastResistance() {
        return blastResistance;
    }

    public String getToolType() {
        return toolType;
    }

    public boolean isFlammable() {
        return flammable;
    }

    public ArrayList<Integer> getDrops() {
        return drops;
    }

    public double getHardness() {
        return hardness;
    }
}