package entity.tool.pickaxe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class StonePickaxe extends Tool {

    public StonePickaxe() {
        setId(274);
        setName("stone_pickaxe");
        setType("pickaxe");
        setRarity("common");
        setMaterial("stone");
        setDurability(132);
        setDamage(3);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}