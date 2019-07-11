package entity.tool.pickaxe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class DiamondPickaxe extends Tool {

    public DiamondPickaxe() {
        setId(278);
        setName("diamond_pickaxe");
        setType("pickaxe");
        setRarity("common");
        setMaterial("diamond");
        setDurability(1562);
        setDamage(6);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}