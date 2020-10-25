package com.burningcactus.freezeflame.entity;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.entity.monster.EskimoEntity;
import com.burningcactus.freezeflame.entity.monster.FireElementalEntity;
import com.burningcactus.freezeflame.entity.monster.IceElementalEntity;
import com.burningcactus.freezeflame.util.FFRegistryNames;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FFEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, FreezeFlameMod.MODID);
    public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, FreezeFlameMod.MODID);
    //Entities initialized before registry. TODO: Remove these once spawn eggs are fixed, or we find a better way of doing this. RegistryObjects are expected to return new values.
    private static final EntityType<IceElementalEntity> iceElemental = buildEntity(FFRegistryNames.ICE_ELEMENTAL, IceElementalEntity::new, EntityClassification.MONSTER, 1.0F, 1.0F);
    private static final EntityType<FireElementalEntity> fireElemental = buildEntity(FFRegistryNames.FIRE_ELEMENTAL, FireElementalEntity::new, EntityClassification.MONSTER, 1.0F, 1.0F);
    private static final EntityType<EskimoEntity> eskimo = buildEntity(FFRegistryNames.ESKIMO, EskimoEntity::new, EntityClassification.MONSTER);
    //Entity Registry Objects
    public static final RegistryObject<EntityType<IceElementalEntity>> ICE_ELEMENTAL = ENTITIES.register(FFRegistryNames.ICE_ELEMENTAL, () -> iceElemental);
    public static final RegistryObject<EntityType<FireElementalEntity>> FIRE_ELEMENTAL = ENTITIES.register(FFRegistryNames.FIRE_ELEMENTAL, () -> fireElemental);
    public static final RegistryObject<EntityType<EskimoEntity>> ESKIMO = ENTITIES.register(FFRegistryNames.ESKIMO, () -> eskimo);
    //Spawn Eggs
    public static final RegistryObject<Item> ICE_ELEMENTAL_SPAWN_EGG = createSpawnEgg(FFRegistryNames.ICE_ELEMENTAL, iceElemental, 0x0000bb, 0x0022ff);
    public static final RegistryObject<Item> FIRE_ELEMENTAL_SPAWN_EGG = createSpawnEgg(FFRegistryNames.FIRE_ELEMENTAL, fireElemental, 0xbb0000, 0xff2200);
    public static final RegistryObject<Item> ESKIMO_SPAWN_EGG = createSpawnEgg(FFRegistryNames.ESKIMO, eskimo, 0x0055dd, 0x22aaaa);

    /**
     * Method to easily build a new entity
     * @param name - The name of the entity
     * @param factory - Functional interface of the entity to be built
     * @param classification - The type of entity to build
     * @param size1 - Size parameter
     * @param size2 - Size parameter
     * @param <T> - The Entity class to build off of
     * @return The EntityType
     */
    private static<T extends Entity> EntityType<T> buildEntity(String name, EntityType.IFactory<T> factory, EntityClassification classification, float size1, float size2) {
        return makeBuilder(factory, classification).size(size1, size2).build(name);
    }

    /**
     * Method to register a new Entity without size adjustments
     * @return The EntityType
     */
    private static<T extends Entity> EntityType<T> buildEntity(String name, EntityType.IFactory<T> factory, EntityClassification classification) {
        return makeBuilder(factory, classification).build(name);
    }

    /**
     * @param factory - Functional interface of the entity to be built
     * @param classification - The type of entity
     * @param <T> - The Entity to be built
     * @return Builder for the EntityType
     */
    private static<T extends Entity> EntityType.Builder<T> makeBuilder(EntityType.IFactory<T> factory, EntityClassification classification) {
        return EntityType.Builder.create(factory, classification);
    }

    private static RegistryObject<Item> createSpawnEgg(String name, EntityType<?> entityIn, int color1, int color2) {
        return SPAWN_EGGS.register(name + "_spawn_egg", () -> new SpawnEggItem(entityIn, color1, color2, new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    }
}
