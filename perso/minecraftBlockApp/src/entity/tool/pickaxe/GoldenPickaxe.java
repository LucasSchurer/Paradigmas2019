package entity.tool.pickaxe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class GoldenPickaxe extends Tool {

    public GoldenPickaxe() {
        setId(285);
        setName("golden_pickaxe");
        setType("pickaxe");
        setRarity("common");
        setMaterial("golden");
        setDurability(33);
        setDamage(3);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}