package net.obviam.starassault.model;

/**
 * Created with IntelliJ IDEA.
 * User: skynet
 * Date: 5/1/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {

    static final float SIZE = 1f;

    Vector2 position = new Vector2();
    Rectangle bounds = new Rectangle();

    public Block(Vector2 pos){
        this.position = pos;
        this.bounds.height = SIZE;
        this.bounds.width = SIZE;
    }

    public Vector2 getPosition(){
        return position;
    }

    public Rectangle getBounds(){
        return bounds;
    }
}
