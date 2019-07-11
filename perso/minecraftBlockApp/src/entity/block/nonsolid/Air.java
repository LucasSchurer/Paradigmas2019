package entity.block.nonsolid;

import java.util.ArrayList;
import entity.*;

public class Air extends Block {
    
    public Air() {
        setId(0);
        setName("air");
        setTransparency(true);
        setLuminancy(0);
        setBlastResistance(0);
        setToolType("none");
        setRenewable(true);
        setStackable(0);
        setFlammable(false);
        setDrops(null);
        setHardness(0);
    }

    public ArrayList<Integer> breakBlock(Tool tool) {
        return getDrops();
    }
}