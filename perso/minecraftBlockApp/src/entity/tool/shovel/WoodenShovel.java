package entity.tool.shovel;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class WoodenShovel extends Tool {

    public WoodenShovel() {
        setId(269);
        setName("wooden_shovel");
        setType("shovel");
        setRarity("common");
        setMaterial("wooden");
        setDurability(60);
        setDamage(2);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}