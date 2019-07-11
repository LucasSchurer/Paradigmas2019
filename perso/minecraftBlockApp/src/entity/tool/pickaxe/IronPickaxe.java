package entity.tool.pickaxe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class IronPickaxe extends Tool {

    public IronPickaxe() {
        setId(257);
        setName("iron_pickaxe");
        setType("pickaxe");
        setRarity("common");
        setMaterial("iron");
        setDurability(251);
        setDamage(5);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}