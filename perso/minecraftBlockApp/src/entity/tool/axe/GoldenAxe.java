package entity.tool.axe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;

public class GoldenAxe extends Tool {

    public GoldenAxe() {
        setId(279);
        setName("golden_axe");
        setType("axe");
        setRarity("common");
        setMaterial("golden");
        setDurability(33);
        setDamage(4);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        return new Pair<Block, Tool>(block, this);
    }
}