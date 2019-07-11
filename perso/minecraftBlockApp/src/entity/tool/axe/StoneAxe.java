package entity.tool.axe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class StoneAxe extends Tool {

    public StoneAxe() {
        setId(275);
        setName("stone_axe");
        setType("axe");
        setRarity("common");
        setMaterial("stone");
        setDurability(132);
        setDamage(5);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}