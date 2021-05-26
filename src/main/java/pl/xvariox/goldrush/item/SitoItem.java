
package pl.xvariox.goldrush.item;

import pl.xvariox.goldrush.GoldRushModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@GoldRushModElements.ModElement.Tag
public class SitoItem extends GoldRushModElements.ModElement {
	@ObjectHolder("gold_rush:sieve")
	public static final Item block = null;
	public SitoItem(GoldRushModElements instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxDamage(192).rarity(Rarity.COMMON));
			setRegistryName("sieve");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
