package pl.xvariox.goldrush.procedures;

import pl.xvariox.goldrush.block.GroundSieveBlock;
import pl.xvariox.goldrush.GoldRushModElements;
import pl.xvariox.goldrush.GoldRushMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Map;

@GoldRushModElements.ModElement.Tag
public class GroundSieveWithSand2OnBlockRightClickedProcedure extends GoldRushModElements.ModElement {
	public GroundSieveWithSand2OnBlockRightClickedProcedure(GoldRushModElements instance) {
		super(instance, 25);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GoldRushMod.LOGGER.warn("Failed to load dependency x for procedure GroundSieveWithSand2OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GoldRushMod.LOGGER.warn("Failed to load dependency y for procedure GroundSieveWithSand2OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GoldRushMod.LOGGER.warn("Failed to load dependency z for procedure GroundSieveWithSand2OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GoldRushMod.LOGGER.warn("Failed to load dependency world for procedure GroundSieveWithSand2OnBlockRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z), Block.getStateId(Blocks.SAND.getDefaultState()));
		if ((Math.round((Math.random() * 2)) == 0)) {
			for (int index0 = 0; index0 < (int) ((Math.round((Math.random() * 3)) + 1)); index0++) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
							new ItemStack(Items.GOLD_NUGGET, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			}
		}
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			BlockState _bs = GroundSieveBlock.block.getDefaultState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
				if (_property != null && _bs.get(_property) != null)
					try {
						_bs = _bs.with(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			world.setBlockState(_bp, _bs, 3);
		}
	}
}
