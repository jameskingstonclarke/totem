package com.kingstonops.totem.player;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.kingstonops.totem.IDComponent;
import com.kingstonops.totem.Prefab;
import com.kingstonops.totem.Totem;
import com.kingstonops.totem.items.InventoryComponent;
import com.kingstonops.totem.items.Item;
import com.kingstonops.totem.physics.ColliderComponent;
import com.kingstonops.totem.physics.MovementComponent;
import com.kingstonops.totem.physics.TransformComponent;
import com.kingstonops.totem.rendering.RenderComponent;
import com.kingstonops.totem.rendering.RenderSystem;

public class Player extends Prefab {

    @Override
    public Entity spawn(Totem game) {
        Entity e;
        e = game.engine().createEntity();
        game.engine().addEntity(e);

        e.add(new IDComponent("player"));


        ColliderComponent c = new ColliderComponent();
        c.m_solid = true;
        c.m_dynamic = true;
        c.m_bounds = new Vector2(.5f, .25f);
        e.add(c);


        InventoryComponent i = new InventoryComponent();
        i.put(Item.registry.instantiate("spawn_chicken").spawn(game));
        i.put(Item.registry.instantiate("spawn_cow").spawn(game));
        i.put(Item.registry.instantiate("spawn_hay").spawn(game));
        i.put(Item.registry.instantiate("spawn_tree").spawn(game));
        i.put(Item.registry.instantiate("speed_totem").spawn(game));
        i.put(Item.registry.instantiate("pickaxe").spawn(game));
        i.put(Item.registry.instantiate("chair").spawn(game));
        e.add(i);

        TransformComponent t = new TransformComponent();
        t.position = new Vector3(
                0,
                0,
                RenderSystem.PLAYER_LAYER
        );
        e.add(t);
        MovementComponent v = new MovementComponent();
        e.add(v);
        e.add(new PlayerComponent());
        RenderComponent r = new RenderComponent();
        r.texture = new TextureRegion(new Texture("guy.png"));
        e.add(r);


        // add the item the player is holding


        Entity holding_item = game.engine().createEntity();
        TransformComponent i_t = new TransformComponent();
        i_t.position = new Vector3(
                0,
                0,
                RenderSystem.PLAYER_LAYER+1
        );
        i_t.scale = new Vector3(
                .5f,
                .5f,
                0
        );
        holding_item.add(i_t);
        RenderComponent i_r = new RenderComponent();
        i_r.texture=new TextureRegion(RenderSystem.get(i.m_items.get(0).items().get(0).m_texture));
        holding_item.add(i_r);
        game.engine().addEntity(holding_item);
        e.getComponent(PlayerComponent.class).m_holding_item = holding_item;
        return e;
    }

}
