package com.kingstonops.totem.world.zones;

import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.kingstonops.totem.Debug;
import com.kingstonops.totem.Totem;
import com.kingstonops.totem.world.tiles.Tile;

public class Zone {

    public static int BG_LAYER = 0;
    public static int DECOR_LAYER = 1;
    public static int NPC_LAYER = 2;
    public static int PLAYER_LAYER = 3;

    public static void from_file(Totem game, String file){
        TiledMap tiled_map = new TmxMapLoader().load(file);
        assert tiled_map != null;

        TiledMapTileLayer layer_0 = (TiledMapTileLayer)tiled_map.getLayers().get(BG_LAYER);
        for(int x=0;x<layer_0.getWidth();x++){
            for(int y=0;y<layer_0.getHeight();y++){
                Debug.dbg(""+x+y*layer_0.getWidth());
                String name = ""+layer_0.getCell(x,y).getTile().getProperties().get("name");
                Tile.registry.instantiate(name).spawn(game, new Vector3(x,y, BG_LAYER));
            }
        }
    }
}
