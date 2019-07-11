package entity.tool.combat.sword;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class WoodenSword extends Tool {

    public WoodenSword() {
        setId(268);
        setName("wooden_sword");
        setType("sword");
        setRarity("common");
        setMaterial("wooden");
        setDurability(59);
        setDamage(4);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}