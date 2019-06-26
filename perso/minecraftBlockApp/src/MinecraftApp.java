import java.util.ArrayList;

class MinecraftApp {
    public static void main(String[] args) {
        Inventory playerInventory = new Inventory(40);
        Inventory worldInventory = new Inventory(400);

        System.out.println("Printando inventario:");
        playerInventory.printInventory();

        Block stone1 = new Stone();
        Tool pick1 = new WoodenPickaxe();
        Tool axe1 = new WoodenAxe();
    }
}