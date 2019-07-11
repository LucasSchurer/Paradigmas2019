package entity.block.solid.nonmineral;

import java.util.ArrayList;
import java.util.Arrays;
import entity.*;

public class Dirt extends Block {

    public Dirt() {
        setId(3);
        setName("dirt");
        setTransparency(false);
        setLuminancy(0);
        setBlastResistance(2.5);
        setToolType("shovel");
        setRenewable(true);
        setStackable(64);
        setFlammable(false);
        setDrops(new ArrayList<Integer>(Arrays.asList(3)));
        setHardness(0.5);
    }

    public ArrayList<Integer> breakBlock(Tool tool) {
        return getDrops();
    }
}