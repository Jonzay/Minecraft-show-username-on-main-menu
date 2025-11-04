package codes.jonzay;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowUsernameOnMainMenu implements ModInitializer {
	public static final String MOD_ID = "showusernameonmainmenu";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[ShowUsernameOnMainMenu] Initialised");
	}
}