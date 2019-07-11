package entity.tool.axe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class WoodenAxe extends Tool {

    public WoodenAxe() {
        setId(271);
        setName("wooden_axe");
        setType("axe");
        setRarity("common");
        setMaterial("wooden");
        setDurability(60);
        setDamage(4);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}