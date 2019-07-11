package entity.block.solid.nonmineral;

import java.util.ArrayList;
import java.util.Arrays;
import entity.*;

public class Wood extends Block {

    public Wood() {
        setId(5);
        setName("wood");
        setTransparency(false);
        setLuminancy(0);
        setBlastResistance(15);
        setToolType("axe");
        setRenewable(true);
        setStackable(64);
        setFlammable(true);
        setDrops(new ArrayList<Integer>(Arrays.asList(5)));
        setHardness(2);

        // setImage("file:../resources/img/block/solid/nonmineral/Bedrock.png");
    }

    public ArrayList<Integer> breakBlock(Tool tool) {
        return getDrops();
    }
}
