package pl.xvariox.goldrush.procedures;

import pl.xvariox.goldrush.block.GroundSieveWithSand2Block;
import pl.xvariox.goldrush.GoldRushModElements;
import pl.xvariox.goldrush.GoldRushMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Map;

@GoldRushModElements.ModElement.Tag
public class GroundSieveWithSand1OnBlockRightClickedProcedure extends GoldRushModElements.ModElement {
	public GroundSieveWithSand1OnBlockRightClickedProcedure(GoldRushModElements instance) {
		super(instance, 24);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GoldRushMod.LOGGER.warn("Failed to load dependency x for procedure GroundSieveWithSand1OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GoldRushMod.LOGGER.warn("Failed to load dependency y for procedure GroundSieveWithSand1OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GoldRushMod.LOGGER.warn("Failed to load dependency z for procedure GroundSieveWithSand1OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GoldRushMod.LOGGER.warn("Failed to load dependency world for procedure GroundSieveWithSand1OnBlockRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z), Block.getStateId(Blocks.SAND.getDefaultState()));
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			BlockState _bs = GroundSieveWithSand2Block.block.getDefaultState();
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
