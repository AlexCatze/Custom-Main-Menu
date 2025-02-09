package lumien.custommainmenu.lib.actions;

import cpw.mods.fml.client.FMLClientHandler;
import lumien.custommainmenu.gui.GuiCustom;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;

public class ActionConnectToServer implements IAction {
    String ip;
    String serverName;

    public ActionConnectToServer(String ip) {
        this.ip = ip;
    }

    @Override
    public void perform(Object source, GuiCustom menu) {
        ServerData serverData = new ServerData(null, this.ip);
        FMLClientHandler.instance().setupServerList();
        FMLClientHandler.instance().connectToServer((GuiScreen) menu, serverData);
    }
}
