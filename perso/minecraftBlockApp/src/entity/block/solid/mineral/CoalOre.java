package entity.block.solid.mineral;

import java.util.ArrayList;
import java.util.Arrays;

import entity.*;

public class CoalOre extends Block {

    public CoalOre() {
        setId(16);
        setName("coal_ore");
        setTransparency(false);
        setLuminancy(0);
        setBlastResistance(15);
        setToolType("pickaxe");
        setRenewable(false);
        setStackable(64);
        setFlammable(false);
        setDrops(new ArrayList<Integer>(Arrays.asList(263)));
        setHardness(3);
    }

    public ArrayList<Integer> breakBlock(Tool tool) {
        return getDrops();
    }
}