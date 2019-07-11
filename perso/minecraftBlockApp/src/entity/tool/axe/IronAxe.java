package entity.tool.axe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class IronAxe extends Tool {

    public IronAxe() {
        setId(258);
        setName("iron_axe");
        setType("axe");
        setRarity("common");
        setMaterial("iron");
        setDurability(251);
        setDamage(6);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}