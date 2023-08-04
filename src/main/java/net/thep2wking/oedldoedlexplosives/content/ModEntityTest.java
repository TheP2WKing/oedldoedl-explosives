package net.thep2wking.oedldoedlexplosives.content;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class ModEntityTest extends ModEntityTNTBase {


	public ModEntityTest(World worldIn, double x, double y, double z, EntityLivingBase igniter) {
		super(worldIn, x, y, z, igniter);
		//TODO Auto-generated constructor stub
	}

	public ModEntityTest(World worldIn) {
		super(worldIn);
		//TODO Auto-generated constructor stub
	}

	@Override
	public void explode() {
		this.world.createExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 100f, true);
	}
	
}
