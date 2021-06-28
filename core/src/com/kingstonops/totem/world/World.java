package com.kingstonops.totem.world;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.kingstonops.totem.*;
import com.kingstonops.totem.rendering.RenderComponent;
import com.kingstonops.totem.rendering.RenderSystem;

public class World {

    private Totem m_game;

    public World(Totem game){
        m_game = game;
        for(int x =0;x<10;x++){
            for(int y =0;y<10;y++){
                Entity e = m_game.engine().createEntity();
                m_game.engine().addEntity(e);
                TransformComponent p = new TransformComponent();
                p.position = new Vector3(
                    RenderSystem.unit_to_pixel(x),
                    RenderSystem.unit_to_pixel(y),
                    0);
                e.add(p);
                RenderComponent r = new RenderComponent();
                r.texture = new TextureRegion(new Texture("grass.png"));
                e.add(r);
            }
        }

    }

}
