package entity.tool.pickaxe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class WoodenPickaxe extends Tool {

    public WoodenPickaxe() {
        setId(270);
        setName("wooden_pickaxe");
        setType("pickaxe");
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