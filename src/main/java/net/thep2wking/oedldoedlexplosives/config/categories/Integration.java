package net.thep2wking.oedldoedlexplosives.config.categories;

import net.minecraftforge.common.config.Config;

public class Integration {
	@Config.Name("theoneprobe")
	public final TheOneProbe THEONEPROBE = new TheOneProbe();

	public static class TheOneProbe {
		@Config.Name("Rotatable TNT Axis")
		public boolean ROTATABLE_TNT_AXIS = true;
	}

	@Config.Name("jer")
	public final JER JER = new JER();

	public static class JER {
		@Config.Name("TheP2WKing Mob Drops")
		public boolean THEP2WKING_MOB_DROPS = true;
	}
}