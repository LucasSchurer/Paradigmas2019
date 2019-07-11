
// JavaFX imports

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

// Entity imports

import entity.*;

import entity.block.nonsolid.*;
import entity.block.solid.mineral.*;
import entity.block.solid.nonmineral.*;

import entity.tool.combat.sword.*;

import entity.tool.axe.*;
import entity.tool.hoe.*;
import entity.tool.pickaxe.*;

// Controller class

public class Controller implements Initializable {

    @FXML
    private ImageView selectedBlockImage;

    private Block selectedBlock;
    private Tool selectedTool;

    // Stage

    @FXML
    private AnchorPane primaryStage;

    // Buttons

    @FXML
    private Button btnBreak;

    @FXML
    void breakSelectedBlock(ActionEvent event) {
        StringBuffer strBuffer = new StringBuffer();
        String str = new String();
        ArrayList<Integer> drops = this.selectedBlock.breakBlock(this.selectedTool);
        if (drops != null)
            for (Integer drop : drops) {
                if (drop != null)
                    strBuffer.append(Integer.toString(drop));
            }

        else
            str = "Nothing";

        if (!str.equals("Nothing")) {
            String dropName = EntityController.getBlock(drops.get(0)).getName();
            dropName = dropName.replaceAll("_", " ");
            dropName = dropName.substring(0, 1).toUpperCase() + dropName.substring(1);
            str = dropName;
        }

        changeDropsLbl(str);

    }

    /*
     * =============================================================================
     * =============================================================================
     */

    @FXML
    private Button btnInfo;

    // btnInfo -/ infoMessage

    @FXML
    private Label infoMessage;

    @FXML
    void showInfoMessage(MouseEvent event) {
        if (!infoBlockScene.isVisible() && !selectBlockScene.isVisible())
            infoMessage.setVisible(true);
    }

    // btnInfo - imgInfoIcon

    @FXML
    private ImageView imgInfoIcon;

    // btnInfo > infoBlockScene

    @FXML
    private VBox infoBlockScene;

    @FXML
    void showInfoBlockScene(MouseEvent event) {
        if (infoBlockScene.isVisible()) {
            infoBlockScene.setVisible(false);
            return;
        }

        infoMessage.setVisible(false);

        // Fill the TableView

        this.colField.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("first"));
        this.colValue.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("second"));

        String blockId = Integer.toString(this.selectedBlock.getId());

        String blockName = this.selectedBlock.getName();
        blockName = blockName.replaceAll("_", " ");
        blockName = blockName.substring(0, 1).toUpperCase() + blockName.substring(1);

        String blockTransparency = Boolean.toString((this.selectedBlock.isTransparency()));
        if (blockTransparency.equals("true"))
            blockTransparency = "Yes";
        else
            blockTransparency = "No";

        String blockLuminancy = Integer.toString(this.selectedBlock.getLuminancy());
        if (selectedBlock.getLuminancy() != 0)
            blockLuminancy = "Yes (" + blockLuminancy + ")";
        else
            blockLuminancy = "No";

        String blockBlastResistance = Double.toString(this.selectedBlock.getBlastResistance());

        String blockToolType = this.selectedBlock.getToolType();
        blockToolType = blockToolType.substring(0, 1).toUpperCase() + blockToolType.substring(1);

        String blockRenewable = Boolean.toString((this.selectedBlock.isRenewable()));
        if (blockRenewable.equals("true"))
            blockRenewable = "Yes";
        else
            blockRenewable = "No";

        String blockStackable = Integer.toString(this.selectedBlock.getStackable());
        if (!blockStackable.equals("0") || !blockStackable.equals("1"))
            blockStackable = "Yes (" + blockStackable + ")";
        else
            blockStackable = "No";

        String blockFlammable = Boolean.toString(this.selectedBlock.isFlammable());
        if (blockFlammable.equals("true"))
            blockFlammable = "Yes";
        else
            blockFlammable = "No";

        StringBuffer strBuffer = new StringBuffer();
        String str = new String();

        ArrayList<Integer> drops = this.selectedBlock.getDrops();
        if (drops != null)
            for (Integer drop : drops) {
                if (drop != null)
                    strBuffer.append(Integer.toString(drop));
            }

        else
            str = "Nothing";

        if (!str.equals("Nothing")) {
            if (strBuffer.toString().equals(Integer.toString(this.selectedBlock.getId())))
                str = "Itself";
            else {
                String dropName = EntityController.getBlock(drops.get(0)).getName();
                dropName = dropName.replaceAll("_", " ");
                dropName = dropName.substring(0, 1).toUpperCase() + dropName.substring(1);
                str = dropName;
            }
        }

        String blockDrops = str;

        String blockHardness = Double.toString(this.selectedBlock.getHardness());
        if (this.selectedBlock.getHardness() == 0.0)
            blockHardness = "Unbreakable";

        this.blockInfo.clear();
        blockInfo.add(new DataEntry("ID", blockId));
        blockInfo.add(new DataEntry("Name", blockName));
        blockInfo.add(new DataEntry("Transparency", blockTransparency));
        blockInfo.add(new DataEntry("Luminancy", blockLuminancy));
        blockInfo.add(new DataEntry("Blast Resistance", blockBlastResistance));
        ;
        blockInfo.add(new DataEntry("Tool", blockToolType));
        blockInfo.add(new DataEntry("Renewable", blockRenewable));
        blockInfo.add(new DataEntry("Stackable", blockStackable));
        blockInfo.add(new DataEntry("Flammable", blockFlammable));
        blockInfo.add(new DataEntry("Drops", blockDrops));
        blockInfo.add(new DataEntry("Hardness", blockHardness));

        this.infoBlockTable.setItems(blockInfo);

        selectBlockScene.setVisible(false);
        infoBlockScene.setVisible(true);
    }

    // btnInfo > infoBlockScene > TableView

    @FXML
    private TableView<DataEntry> infoBlockTable;

    // btnInfo > infoBlockScene > TableView > TableColumns

    @FXML
    private TableColumn<DataEntry, String> colField;

    @FXML
    private TableColumn<DataEntry, String> colValue;

    // btnInfo > infoBlockScene > TableView (DataEntry)

    public class DataEntry {
        private SimpleStringProperty first;
        private SimpleStringProperty second;

        private DataEntry(String a, String b) {
            this.first = new SimpleStringProperty(a);
            this.second = new SimpleStringProperty(b);
        }

        public SimpleStringProperty firstProperty() {
            return first;
        }

        public String getFirst() {
            return first.get();
        }

        public void setFirst(String a) {
            first.set(a);
        }

        public SimpleStringProperty secondProperty() {
            return second;
        }

        public String getSecond() {
            return second.get();
        }

        public void setSecond(String a) {
            second.set(a);
        }
    }

    private ObservableList<DataEntry> blockInfo = FXCollections.observableArrayList(new DataEntry("", ""));

    /*
     * =============================================================================
     * =============================================================================
     */

    @FXML
    private Button btnSelectBlock;

    // btnSelectBlock -/ selectBlockMessage

    @FXML
    private Label selectBlockMessage;

    @FXML
    void showSelectBlockMessage(MouseEvent event) {
        if (!infoBlockScene.isVisible() && !selectBlockScene.isVisible())
            selectBlockMessage.setVisible(true);
    }

    @FXML
    void hideSelectBlockMessage(MouseEvent event) {
        selectBlockMessage.setVisible(false);
    }

    // btnSelectBlock - imgSelectBlockIcon;

    @FXML
    private ImageView imgSelectBlockIcon;

    // btnSelectBlock > selectBlockScene

    @FXML
    private ScrollPane selectBlockScene;

    @FXML
    void showSelectBlockScene(ActionEvent event) {
        if (this.selectBlockScene.isVisible()) {
            this.selectBlockScene.setVisible(false);
            return;
        }

        this.selectBlockMessage.setVisible(false);
        this.infoBlockScene.setVisible(false);
        this.selectBlockScene.setVisible(true);
    }

    // btnSelectBlock > selectBlockScene > Buttons (Blocks)

    @FXML
    private ImageView imgStone;

    @FXML
    private Button btnStone;

    @FXML
    void changeSelectedStone(ActionEvent event) {
        changeSelectedBlock(new Stone());

        Image image = new Image("file:Gravel.png");
        this.selectedBlockImage.setImage(image);
    }

    @FXML
    private Button btnGrass;

    @FXML
    void changeSelectedGrass(ActionEvent event) {
        changeSelectedBlock(new Grass());
    }

    @FXML
    private Button btnDirt;

    @FXML
    void changeSelectedDirt(ActionEvent event) {
        changeSelectedBlock(new Dirt());
    }

    @FXML
    private Button btnCobblestone;

    @FXML
    void changeSelectedCobblestone(ActionEvent event) {
        changeSelectedBlock(new Cobblestone());
    }

    @FXML
    private Button btnWood;

    @FXML
    void changeSelectedWood(ActionEvent event) {
        changeSelectedBlock(new Wood());
    }

    public void changeSelectedBlock(Block block) {
        this.selectedBlock = block;
        changeSelectedBlockLbl(this.selectedBlock.getName());
    }

    /*
     * =============================================================================
     * =============================================================================
     */

    @FXML
    private Button btnSelectTool;

    // btnSelectTool -/ selectToolMessage

    @FXML
    private Label selectToolMessage;

    @FXML
    void showSelectToolMessage(MouseEvent event) {
        if (selectToolScene.isVisible())
            selectToolMessage.setVisible(false);
        else
            selectToolMessage.setVisible(true);
    }

    @FXML
    void hideSelectToolMessage(MouseEvent event) {
        selectToolMessage.setVisible(false);
    }

    // btnSelectTool - imgSelectToolIcon;

    @FXML
    private ImageView imgSelectToolIcon;

    // btnSelectTool > selectToolScene

    @FXML
    private ScrollPane selectToolScene;

    @FXML
    void showSelectToolScene(ActionEvent event) {
        if (selectToolScene.isVisible()) {
            selectToolScene.setVisible(false);
            return;
        }

        selectToolMessage.setVisible(false);
        selectToolScene.setVisible(true);
    }

    // btnSelectTool > selectToolScene > Buttons (Tools)

    @FXML
    private Button btnWoodenPickaxe;

    @FXML
    void changeSelectedWoodenPickaxe(ActionEvent event) {
        changeSelectedTool(new WoodenPickaxe());
    }

    @FXML
    private Button btnStonePickaxe;

    @FXML
    void changeSelectedStonePickaxe(ActionEvent event) {
        changeSelectedTool(new StonePickaxe());
    }

    @FXML
    private Button btnIronPickaxe;

    @FXML
    void changeSelectedIronPickaxe(ActionEvent event) {
        changeSelectedTool(new IronPickaxe());
    }

    @FXML
    private Button btnGoldenPickaxe;

    @FXML
    void changeSelectedGoldenPickaxe(ActionEvent event) {
        changeSelectedTool(new GoldenPickaxe());
    }

    @FXML
    private Button btnDiamondPickaxe;

    @FXML
    void changeSelectedDiamondPickaxe(ActionEvent event) {
        changeSelectedTool(new DiamondPickaxe());
    }

    @FXML
    private Button btnWoodenAxe;

    @FXML
    void changeSelectedWoodenAxe(ActionEvent event) {
        changeSelectedTool(new WoodenAxe());
    }

    @FXML
    private Button btnStoneAxe;

    @FXML
    void changeSelectedStoneAxe(ActionEvent event) {
        changeSelectedTool(new StoneAxe());
    }

    @FXML
    private Button btnIronAxe;

    @FXML
    void changeSelectedIronAxe(ActionEvent event) {
        changeSelectedTool(new IronAxe());
    }

    private Button btnGoldenAxe;

    @FXML
    void changeSelectedGoldenAxe(ActionEvent event) {
        changeSelectedTool(new GoldenAxe());
    }

    @FXML
    private Button btnDiamondAxe;

    @FXML
    void changeSelectedDiamondAxe(ActionEvent event) {
        changeSelectedTool(new DiamondAxe());
    }

    public void changeSelectedTool(Tool tool) {
        this.selectedTool = tool;
        changeSelectedToolLbl(this.selectedTool.getName());
    }

    /*
     * =============================================================================
     * =============================================================================
     */

    // Labels

    @FXML
    private Label selectedBlockLbl;

    public void changeSelectedBlockLbl(String name) {
        String blockName = this.selectedBlock.getName();
        blockName = blockName.replaceAll("_", " ");
        blockName = blockName.substring(0, 1).toUpperCase() + blockName.substring(1);

        this.selectedBlockLbl.setText("Selected Block: " + blockName);
    }

    @FXML
    private Label selectedToolLbl;

    public void changeSelectedToolLbl(String name) {
        String toolName = this.selectedTool.getName();
        toolName = toolName.replaceAll("_", " ");
        toolName = toolName.substring(0, 1).toUpperCase() + toolName.substring(1);

        this.selectedToolLbl.setText("Selected Tool: " + toolName);
    }

    @FXML
    private Label dropsLbl;

    public void changeDropsLbl(String name) {
        this.dropsLbl.setText("Drops: " + name);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Block selectedBlock = new Bedrock();
        Tool selectedTool = new WoodenAxe();

        this.selectedBlock = selectedBlock;
        this.selectedTool = selectedTool;

        changeSelectedBlockLbl(this.selectedBlock.getName());
        changeSelectedToolLbl(this.selectedTool.getName());
    }
}
