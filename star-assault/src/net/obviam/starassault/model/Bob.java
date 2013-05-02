package net.obviam.starassault.model;

/**
 * Created with IntelliJ IDEA.
 * User: skynet
 * Date: 5/1/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bob {

    public enum State{
        IDLE, WALKING, JUMPING, DYING
    }

    public static final float SPEED = 2f; //unit per second
    public static final float JUMP_VELOCITY = 1f;
    public static final float SIZE = 0.5f; //half a unit

    Vector2 position = new Vector2();
    Vector2 acceleration = new Vector2();
    Vector2 velocity = new Vector2();
    Rectangle bounds = new Rectangle();
    State state = State.IDLE;
    boolean facingleft = true;
    float stateTime = 0;

    public Bob(Vector2 position){
        this.position = position;
        this.bounds.height = SIZE;
        this.bounds.width = SIZE;
    }

    public boolean isFacingLeft(){
        return facingleft;
    }

    public void setFacingleft(boolean facingleft){
        this.facingleft = facingleft;
    }

    public Vector2 getPosition(){
        return position;
    }

    public Vector2 getAcceleration(){
        return acceleration;
    }

    public Vector2 getVelocity(){
        return velocity;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public State getState(){
        return state;
    }

    public void setState(State newState){
        this.state = newState;
    }

    public void update(float delta){
        stateTime += delta;
        position.add(velocity.cpy().scl(delta));
    }


}
