package entity.block.solid.nonmineral;

import java.util.ArrayList;
import java.util.Arrays;
import entity.*;

public class Cobblestone extends Block {

    public Cobblestone() {
        setId(4);
        setName("cobblestone");
        setTransparency(false);
        setLuminancy(0);
        setBlastResistance(30);
        setToolType("pickaxe");
        setRenewable(true);
        setStackable(64);
        setFlammable(false);
        setDrops(new ArrayList<Integer>(Arrays.asList(4)));
        setHardness(2);

        // setImage("file:../resources/img/block/solid/nonmineral/Bedrock.png");
    }

    public ArrayList<Integer> breakBlock(Tool tool) {
        if (tool.getType().equals(this.getToolType()))
            return getDrops();
        else
            return null;
    }
}
