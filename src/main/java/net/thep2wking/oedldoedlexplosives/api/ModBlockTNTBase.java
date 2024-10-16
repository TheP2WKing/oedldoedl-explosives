package net.thep2wking.oedldoedlexplosives.api;

import net.minecraft.block.BlockTNT;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author TheP2WKing
 */
public class ModBlockTNTBase extends BlockTNT {
    public final String modid;
    public final String name;
    public final CreativeTabs tab;
    public final SoundType sound;
    public final MapColor mapColor;
    public final int lightLevel;

    /**
     * @author TheP2WKing
     * @param modid      String
     * @param name       String
     * @param tab        {@link CreativeTabs}
     * @param sound      {@link SoundType}
     * @param mapColor   {@link MapColor}
     * @param lightLevel int
     */
    public ModBlockTNTBase(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor,
            int lightLevel) {
        super();
        this.modid = modid;
        this.name = name;
        this.tab = tab;
        this.sound = sound;
        this.mapColor = mapColor;
        this.lightLevel = lightLevel;
        setUnlocalizedName(this.modid + "." + this.name);
        setRegistryName(this.modid + ":" + this.name);
        setCreativeTab(this.tab);
        setSoundType(this.sound);
        this.setDefaultState(this.blockState.getBaseState().withProperty(EXPLODE, Boolean.valueOf(false)));
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return mapColor;
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return lightLevel;
    }

    public ModEntityTNTBase createTNTEntity(World world, double x, double y, double z, EntityLivingBase ignitor) {
        return new ModEntityTNTBase(world, x, y, z, ignitor);
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        if (!worldIn.isRemote) {
            ModEntityTNTBase entitytntprimed = createTNTEntity(worldIn, (double) ((float) pos.getX() + 0.5F),
                    (double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), explosionIn.getExplosivePlacedBy());
            entitytntprimed.setFuse(
                    (short) (worldIn.rand.nextInt(entitytntprimed.getFuse() / 4) + entitytntprimed.getFuse() / 8));
            worldIn.spawnEntity(entitytntprimed);
        }
    }

    @Override
    public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
        if (!worldIn.isRemote) {
            if (((Boolean) state.getValue(EXPLODE)).booleanValue()) {
                ModEntityTNTBase entitytntprimed = createTNTEntity(worldIn, (double) ((float) pos.getX() + 0.5F),
                        (double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), igniter);
                worldIn.spawnEntity(entitytntprimed);
                worldIn.playSound((EntityPlayer) null, pos.getX(), pos.getY(), pos.getZ(),
                        SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (!worldIn.isRemote && entityIn instanceof EntityArrow) {
            EntityArrow entityarrow = (EntityArrow) entityIn;
            if (entityarrow.isBurning()) {
                this.explode(worldIn, pos, worldIn.getBlockState(pos).withProperty(EXPLODE, Boolean.valueOf(true)),
                        entityarrow.shootingEntity instanceof EntityLivingBase
                                ? (EntityLivingBase) entityarrow.shootingEntity
                                : null);
                worldIn.setBlockToAir(pos);
            }
        }
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosionIn) {
        return false;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(EXPLODE, Boolean.valueOf((meta & 1) > 0));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((Boolean) state.getValue(EXPLODE)).booleanValue() ? 1 : 0;
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { EXPLODE });
    }
}