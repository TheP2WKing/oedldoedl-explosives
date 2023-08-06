package net.thep2wking.oedldoedlexplosives.init;

import net.minecraft.util.SoundEvent;
import net.thep2wking.oedldoedlcore.api.sound.ModSoundEventBase;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;

public class ModSounds {
	public static final SoundEvent NUKE_ALARM = new ModSoundEventBase(OedldoedlExplosives.MODID, "nuke_alarm");
	public static final SoundEvent TACTICAL_NUKE = new ModSoundEventBase(OedldoedlExplosives.MODID, "tactical_nuke");
	public static final SoundEvent BOMB = new ModSoundEventBase(OedldoedlExplosives.MODID, "bomb");
	public static final SoundEvent ATOMIC = new ModSoundEventBase(OedldoedlExplosives.MODID, "atomic");

}