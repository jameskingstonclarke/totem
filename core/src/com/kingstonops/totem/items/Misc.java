package com.kingstonops.totem.items;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Vector3;
import com.kingstonops.totem.Debug;
import com.kingstonops.totem.Prefab;
import com.kingstonops.totem.Totem;
import com.kingstonops.totem.physics.TransformComponent;
import com.kingstonops.totem.rendering.RenderSystem;
import com.kingstonops.totem.world.WorldSystem;
import com.kingstonops.totem.world.animals.Animal;
import com.kingstonops.totem.world.tiles.Tile;
import com.kingstonops.totem.world.zones.ZoneComponent;

public class Misc {
    public static class RustyGear extends Item{
        public RustyGear(){
            super("rusty_gear", "rusty_gear.jpg", Rarity.LEGENDARY);
        }
        @Override
        public void on_use(Totem game, Vector3 pos) {
            super.on_use(game, pos);


        }
    }

    public static class Chair extends Item{
        public Chair(){
            super("chair", "chair.jpg", Rarity.COMMON);
        }
        @Override
        public void on_use(Totem game, Vector3 pos) {
            super.on_use(game, pos);
            ZoneComponent z = game.engine().getSystem(WorldSystem.class).m_active_zone.getComponent(ZoneComponent.class);
            z.entities().add(Tile.registry.instantiate("chair").spawn(game));


        }
    }

    public static class SpawnFence extends Item{
        public SpawnFence(){
            super("spawn_fence", "fence.png", Rarity.COMMON);
        }
        @Override
        public void on_use(Totem game, Vector3 pos) {
            super.on_use(game, pos);
            ZoneComponent z = game.engine().getSystem(WorldSystem.class).m_active_zone.getComponent(ZoneComponent.class);
            Entity e = Prefab.registry.instantiate("obj_fence").spawn(game);
            e.getComponent(TransformComponent.class).position.set(pos);
            z.entities().add(e);


        }
    }

    public static class SpawnCow extends Item{
        public SpawnCow(){
            super("spawn_cow", "cow.png", Rarity.COMMON);
        }
        @Override
        public void on_use(Totem game, Vector3 pos) {
            super.on_use(game, pos);
            ZoneComponent z = game.engine().getSystem(WorldSystem.class).m_active_zone.getComponent(ZoneComponent.class);
            Entity e = Prefab.registry.instantiate("animal_cow").spawn(game);
            e.getComponent(TransformComponent.class).position.set(pos);
            z.entities().add(e);
        }
    }

    public static class SpawnChicken extends Item{
        public SpawnChicken(){
            super("spawn_chicken", "chicken.png", Rarity.COMMON);
        }
        @Override
        public void on_use(Totem game, Vector3 pos) {
            super.on_use(game, pos);
            ZoneComponent z = game.engine().getSystem(WorldSystem.class).m_active_zone.getComponent(ZoneComponent.class);
            Entity e = Prefab.registry.instantiate("animal_chicken").spawn(game);
            e.getComponent(TransformComponent.class).position.set(pos);
            z.entities().add(e);
        }
    }

    public static class SpawnHay extends Item{
        public SpawnHay(){
            super("spawn_hay", "hay.png", Rarity.COMMON);
        }
        @Override
        public void on_use(Totem game, Vector3 pos) {
            super.on_use(game, pos);
            ZoneComponent z = game.engine().getSystem(WorldSystem.class).m_active_zone.getComponent(ZoneComponent.class);
            Entity e = Prefab.registry.instantiate("obj_hay").spawn(game);
            e.getComponent(TransformComponent.class).position.set(pos);
            z.entities().add(e);
        }
    }

    public static class SpawnTree extends Item{
        public SpawnTree(){
            super("spawn_tree", "tree.png", Rarity.COMMON);
        }
        @Override
        public void on_use(Totem game, Vector3 pos) {
            super.on_use(game, pos);
            ZoneComponent z = game.engine().getSystem(WorldSystem.class).m_active_zone.getComponent(ZoneComponent.class);
            Entity e = Prefab.registry.instantiate("obj_tree").spawn(game);
            e.getComponent(TransformComponent.class).position.set(pos);
            z.entities().add(e);
        }
    }
}
