import java.util.ArrayList;
import javafx.util.Pair;
import javafx.scene.image.Image;

abstract class Block extends Entity implements BlockGraphics {

    abstract public void setTransparency();

    abstract public void setLuminancy();

    abstract public void setBlastResistance();

    abstract public void setToolType();

    abstract public void setFlammable();

    abstract public void setDrops();

    abstract public void setHardness();

    abstract public double getTransparency();

    abstract public double getLuminancy();

    abstract public double getBlastResistance();

    abstract public String getToolType();

    abstract public double getFlammable();

    abstract public ArrayList<Integer> getDrops();

    abstract public double getHardness();

    abstract public ArrayList<Integer> breakBlock(Tool tool);
}