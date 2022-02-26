package net.rarplayz.spacestark.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rarplayz.spacestark.Spacestark;
import net.rarplayz.spacestark.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Spacestark.MOD_ID);

    public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock("citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_CITRINE_BLOCK = registerBlock("raw_citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CITRINE_ORE = registerBlock("citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_CITRINE_ORE = registerBlock("deepslate_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NETHERRACK_CITRINE_ORE = registerBlock("netherrack_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ENDSTONE_CITRINE_ORE = registerBlock("endstone_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, CreativeModeTab.TAB_MISC);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
