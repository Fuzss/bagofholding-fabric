package fuzs.bagofholding.registry;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import fuzs.bagofholding.BagOfHolding;
import fuzs.bagofholding.capability.BagPerseveranceCapability;
import fuzs.bagofholding.capability.BagPerseveranceCapabilityImpl;
import fuzs.bagofholding.world.inventory.BagItemMenu;
import fuzs.bagofholding.world.item.BagOfHoldingItem;
import fuzs.bagofholding.world.item.crafting.BagUpgradeRecipe;
import fuzs.bagofholding.world.item.enchantment.PreservationEnchantment;
import fuzs.extensibleenums.core.ExtensibleEnchantmentCategory;
import fuzs.puzzleslib.capability.CapabilityController;
import fuzs.puzzleslib.capability.data.PlayerRespawnStrategy;
import fuzs.puzzleslib.registry.RegistryManager;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.Locale;

public class ModRegistry {
    public static final EnchantmentCategory BAG_OF_HOLDING_ENCHANTMENT_CATEGORY = ExtensibleEnchantmentCategory.create(BagOfHolding.MOD_ID.toUpperCase(Locale.ROOT).concat("_BAG_OF_HOLDING"), item -> item instanceof BagOfHoldingItem);

    private static final RegistryManager REGISTRY = RegistryManager.of(BagOfHolding.MOD_ID);
    public static final Item LEATHER_BAG_OF_HOLDING_ITEM = REGISTRY.registerItem("leather_bag_of_holding", () -> new BagOfHoldingItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1), () -> BagOfHolding.CONFIG.server().leatherBagRows, DyeColor.BROWN, BagItemMenu::leatherBag));
    public static final Item IRON_BAG_OF_HOLDING_ITEM = REGISTRY.registerItem("iron_bag_of_holding", () -> new BagOfHoldingItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1), () -> BagOfHolding.CONFIG.server().ironBagRows, DyeColor.WHITE, BagItemMenu::ironBag));
    public static final Item GOLDEN_BAG_OF_HOLDING_ITEM = REGISTRY.registerItem("golden_bag_of_holding", () -> new BagOfHoldingItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1), () -> BagOfHolding.CONFIG.server().goldenBagRows, DyeColor.YELLOW, BagItemMenu::goldenBag));
    public static final MenuType<BagItemMenu> LEATHER_BAG_OF_HOLDING_MENU_TYPE = REGISTRY.registerRawMenuType("leather_bag_of_holding", () -> BagItemMenu::leatherBag);
    public static final MenuType<BagItemMenu> IRON_BAG_OF_HOLDING_MENU_TYPE = REGISTRY.registerRawMenuType("iron_bag_of_holding", () -> BagItemMenu::ironBag);
    public static final MenuType<BagItemMenu> GOLDEN_BAG_OF_HOLDING_MENU_TYPE = REGISTRY.registerRawMenuType("golden_bag_of_holding", () -> BagItemMenu::goldenBag);
    public static final Enchantment PRESERVATION_ENCHANTMENT = REGISTRY.registerEnchantment("preservation", () -> new PreservationEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlot.values()));
    public static final RecipeSerializer<ShapedRecipe> BAG_UPGRADE_RECIPE_SERIALIZER = REGISTRY.register(Registry.RECIPE_SERIALIZER, "crafting_special_bag_upgrade", () -> new BagUpgradeRecipe.Serializer());

    private static final CapabilityController CAPABILITIES = CapabilityController.of(BagOfHolding.MOD_ID);
    public static final ComponentKey<BagPerseveranceCapability> BAG_PERSEVERANCE_CAPABILITY = CAPABILITIES.registerPlayerCapability("bag_perseverance", BagPerseveranceCapability.class, player -> new BagPerseveranceCapabilityImpl(), PlayerRespawnStrategy.NEVER);

    public static void touch() {

    }
}
