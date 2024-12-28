package studio.dreamys.ecu.mixin.other.essential.cosmetics;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gg.essential.connectionmanager.common.packet.cosmetic.ServerCosmeticsPopulatePacket;
import gg.essential.cosmetics.model.Cosmetic;
import gg.essential.network.connectionmanager.ConnectionManager;
import gg.essential.network.connectionmanager.handler.cosmetics.ServerCosmeticsPopulatePacketHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Mixin(value = ServerCosmeticsPopulatePacketHandler.class, remap = false)
public class MixinServerCosmeticsPopulatePacketHandler {
    @Inject(method = "onHandle(Lgg/essential/network/connectionmanager/ConnectionManager;Lgg/essential/connectionmanager/common/packet/cosmetic/ServerCosmeticsPopulatePacket;)V", at = @At("HEAD"))
    public void onHandle(ConnectionManager connectionManager, ServerCosmeticsPopulatePacket packet, CallbackInfo ci) {
//        try {
//            Gson gson = new Gson();
//            List<Cosmetic> cosmetics = new ArrayList<>();
////            File dumpFile = new File(new File(System.getenv("APPDATA"), "ecu"), "dump.txt");
//            File dumpFile;
//            String os = System.getProperty("os.name").toLowerCase();
//            if (os.contains("win")) { // Windows
//                System.out.println("[EssentialCosmeticsUnlocker] Platform: Windows.");
//                dumpFile = new File(new File(System.getenv("APPDATA"), "ecu"), "dump.txt");
//            } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) { // Linux
//                System.out.println("[EssentialCosmeticsUnlocker] Platform: Linux.");
//                dumpFile = new File(new File(System.getProperty("HOME"), ".local/share/ecu"), "dump.txt");
//            } else { // Mac
//                System.out.println("[EssentialCosmeticsUnlocker] Platform: Mac.");
//                dumpFile = new File(new File(System.getProperty("HOME"), ".ecu"), "dump.txt");
//            }
//            dumpFile.getParentFile().mkdirs();
//
//            //start with already existing or new list
//            if (dumpFile.exists()) {
//                cosmetics = gson.fromJson(Files.readAllLines(dumpFile.toPath()).toString(), new TypeToken<List<Cosmetic>>() {
//                }.getType());
//            }
//
//            //add incoming cosmetics to the list
//            cosmetics.addAll(packet.getCosmetics());
//
//            //dump the list to file
//            System.out.println("[EssentialCosmeticsUnlocker] Dumping cosmetics to file" + dumpFile.getPath() + "...");
//            PrintWriter pw = new PrintWriter(new FileOutputStream(dumpFile, true));
//            pw.println(new Gson().toJson(cosmetics));
//            pw.close();
//            System.out.println("[EssentialCosmeticsUnlocker] Dumped cosmetics to file!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("[EssentialCosmeticsUnlocker] Could not dump cosmetics to file.");
//        }
        System.out.println(packet.getCosmetics());
    }
}
