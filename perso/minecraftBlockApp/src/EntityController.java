import java.util.ArrayList;

// Entity imports

import entity.*;

import entity.block.nonsolid.*;
import entity.block.solid.mineral.*;
import entity.block.solid.nonmineral.*;

import entity.tool.combat.sword.*;

import entity.tool.axe.*;
import entity.tool.hoe.*;
import entity.tool.pickaxe.*;

public class EntityController {
    public static Entity getEntity(int id) {
        switch (id) {
        case 1:
            return new Stone();

        case 2:
            return new Grass();

        case 3:
            return new Dirt();

        case 4:
            return new Cobblestone();

        case 5:
            return new Wood();

        case 7:
            return new Bedrock();

        case 16:
            return new CoalOre();

        case 271:
            return new WoodenAxe();

        case 275:
            return new StoneAxe();

        case 258:
            return new IronAxe();

        case 279:
            return new DiamondAxe();

        case 286:
            return new GoldenAxe();

        default:
            return null;
        }
    }

    public static ArrayList<Entity> getEntities(ArrayList<Integer> ids) {
        ArrayList<Entity> entities = new ArrayList<Entity>();

        for (Integer id : ids) {
            entities.add(getEntity(id));
        }

        return entities;
    }

    public static Block getBlock(int id) {
        switch (id) {
        case 1:
            return new Stone();

        case 2:
            return new Grass();

        case 3:
            return new Dirt();

        case 4:
            return new Cobblestone();

        case 5:
            return new Wood();

        case 7:
            return new Bedrock();

        case 16:
            return new CoalOre();

        default:
            return null;
        }
    }

    public static ArrayList<Block> getBlocks(ArrayList<Integer> ids) {
        ArrayList<Block> blocks = new ArrayList<Block>();

        for (Integer id : ids) {
            blocks.add(getBlock(id));
        }

        return blocks;
    }

    public static Tool getTool(int id) {
        switch (id) {
        case 270:
            return new WoodenPickaxe();

        case 274:
            return new StonePickaxe();

        case 257:
            return new IronPickaxe();

        case 278:
            return new DiamondPickaxe();

        case 285:
            return new GoldenPickaxe();

        case 271:
            return new WoodenAxe();

        case 275:
            return new StoneAxe();

        case 258:
            return new IronAxe();

        case 279:
            return new DiamondAxe();

        case 286:
            return new GoldenAxe();

        default:
            return null;
        }
    }

    public static ArrayList<Tool> getTools(ArrayList<Integer> ids) {
        ArrayList<Tool> tools = new ArrayList<Tool>();

        for (Integer id : ids) {
            tools.add(getTool(id));
        }

        return tools;
    }
}