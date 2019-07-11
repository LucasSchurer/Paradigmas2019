package entity.block.solid.nonmineral;

import java.util.ArrayList;
import java.util.Arrays;
import entity.*;

public class Soil extends Block {

    public Soil() {
        setId(60);
        setName("soil");
        setTransparency(false);
        setLuminancy(0);
        setBlastResistance(3);
        setToolType("shovel");
        setRenewable(false);
        setStackable(64);
        setFlammable(false);
        setDrops(new ArrayList<Integer>(Arrays.asList(3)));
        setHardness(0.6);
    }

    public ArrayList<Integer> breakBlock(Tool tool) {
        return getDrops();
    }
}