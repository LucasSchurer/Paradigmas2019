package entity.block.solid.nonmineral;

import java.util.ArrayList;
import java.util.Arrays;
import entity.*;

public class Grass extends Block {

    public Grass() {
        setId(2);
        setName("grass");
        setTransparency(false);
        setLuminancy(0);
        setBlastResistance(3);
        setToolType("shovel");
        setRenewable(true);
        setStackable(64);
        setFlammable(false);
        setDrops(new ArrayList<Integer>(Arrays.asList(3)));
        setHardness(0.6);

        // setImage("file:../resources/img/block/solid/nonmineral/Bedrock.png");
    }

    public ArrayList<Integer> breakBlock(Tool tool) {
        return getDrops();
    }
}
