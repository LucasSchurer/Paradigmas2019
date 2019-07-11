package entity.tool.axe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class DiamondAxe extends Tool {

    public DiamondAxe() {
        setId(286);
        setName("diamond_axe");
        setType("axe");
        setRarity("common");
        setMaterial("diamond");
        setDurability(1562);
        setDamage(7);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}