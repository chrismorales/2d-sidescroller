package net.obviam.starassault;

import net.obviam.starassault.view.WorldRenderer;
import net.obviam.starassault.model.World;
import net.obviam.starassault.controller.WorldController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;


/**
 * Created with IntelliJ IDEA.
 * User: skynet
 * Date: 5/1/13
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameScreen implements Screen, InputProcessor {

    private World world;
    private WorldRenderer renderer;
    private WorldController controller;

    private int width, height;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        controller.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        renderer.setSize(width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public void show() {
        world = new World();
        renderer = new WorldRenderer(world, true);
        controller = new WorldController(world);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
    }

    /** Android Definitions for the keys being pressed **/
    @Override
    public boolean keyDown(int keycode){
        if(keycode == Keys.LEFT){
            controller.leftPressed();
        }
        if(keycode == Keys.RIGHT){
            controller.rightPressed();
        }
        if(keycode == Keys.Z){
            controller.jumpPressed();
        }
        if(keycode == Keys.X){
            controller.firePressed();
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode){
        if(keycode == Keys.LEFT)
            controller.leftReleased();
        if(keycode == Keys.RIGHT)
            controller.rightReleased();
        if(keycode == Keys.Z)
            controller.jumpReleased();
        if(keycode == Keys.X)
            controller.fireReleased();
        return true;
    }

    @Override
    public boolean keyTyped(char character){
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button){
        if(x < width / 2 && y > height / 2)
            controller.leftPressed();
        if(x > width / 2 && y > height / 2)
            controller.rightPressed();
        return true;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button){
        if( x < width / 2 && y > height / 2)
            controller.leftReleased();
        if(x > width / 2 && y > height / 2)
            controller.rightReleased();
        return true;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer){
        return false;
    }

    @Override
    public boolean mouseMoved(int x, int y){
        return false;
    }

    @Override
    public boolean scrolled(int amount){
        return false;
    }
}
