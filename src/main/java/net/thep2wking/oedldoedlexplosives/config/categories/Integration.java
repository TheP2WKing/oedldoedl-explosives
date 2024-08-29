package net.thep2wking.oedldoedlexplosives.config.categories;

import net.minecraftforge.common.config.Config;

public class Integration {
	@Config.Name("theoneprobe")
	public final TheOneProbe THEONEPROBE = new TheOneProbe();

	public static class TheOneProbe {
		@Config.Name("Rotatable TNT Axis")
		public boolean ROTATABLE_TNT_AXIS = true;
	}
}