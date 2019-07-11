package entity.tool.hoe;

import java.util.ArrayList;
import javafx.util.Pair;
import entity.*;
import entity.block.solid.nonmineral.Soil;

public class WoodenHoe extends Tool {

    public WoodenHoe() {
        setId(290);
        setName("wooden_hoe");
        setType("hoe");
        setRarity("common");
        setMaterial("wooden");
        setDurability(60);
        setDamage(1);
        setRenewable(true);
        setStackable(1);
    }

    public Pair<Block, Tool> rightClick(Block block) {
        // ID = 3 = Dirt
        if (block.getId() == 3) {
            this.setDurability(this.getDurability() - 1);
            block = new Soil();
        }

        return new Pair<Block, Tool>(block, this);
    }
}