import java.util.ArrayList;

class Controller {
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

        case 6:
            return new Sapling();

        case 7:
            return new Bedrock();

        case 8:
            return new Water();

        case 9:
            return new StationaryWater();

        case 10:
            return new Lava();

        case 11:
            return new StationaryLava();

        case 12:
            return new Sand();

        case 13:
            return new Gravel();

        case 14:
            return new GoldOre();

        case 15:
            return new IronOre();

        case 16:
            return new CoalOre();

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

        case 6:
            return new Sapling();

        case 7:
            return new Bedrock();

        case 8:
            return new Water();

        case 9:
            return new StationaryWater();

        case 10:
            return new Lava();

        case 11:
            return new StationaryLava();

        case 12:
            return new Sand();

        case 13:
            return new Gravel();

        case 14:
            return new GoldOre();

        case 15:
            return new IronOre();

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

        case 271:
            return new WoodenAxe();

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