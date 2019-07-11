package entity.block.solid.nonmineral;

import java.util.ArrayList;
import entity.*;

public class Bedrock extends Block {

    public Bedrock() {
        setId(7);
        setName("bedrock");
        setTransparency(false);
        setLuminancy(0);
        setBlastResistance(18000);
        setToolType("none");
        setRenewable(false);
        setStackable(64);
        setFlammable(false);
        setDrops(null);
        setHardness(0);

        // setImage("file:../resources/img/block/solid/nonmineral/Bedrock.png");
    }

    public ArrayList<Integer> breakBlock(Tool tool) {
        return getDrops();
    }
}
