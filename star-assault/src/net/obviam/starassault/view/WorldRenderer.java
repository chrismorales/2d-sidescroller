package net.obviam.starassault.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.obviam.starassault.model.Block;
import net.obviam.starassault.model.Bob;
import net.obviam.starassault.model.World;
import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created with IntelliJ IDEA.
 * User: skynet
 * Date: 5/1/13
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorldRenderer {

    private static final float CAMERA_WIDTH = 10f;
    private static final float CAMERA_HEIGHT = 7f;

    private World world;
    private OrthographicCamera cam;

    /** for debug rendering **/
    ShapeRenderer debugRenderer = new ShapeRenderer();

    /** Texures **/
    private Texture bobTexture;
    private Texture blockTexture;

    /** Sprite and other variables **/
    private SpriteBatch spriteBatch;
    private boolean debug = false;
    private int width;
    private int height;
    private float ppuX; // pixels per unit on the X axis
    private float ppuY; // pixels per unit on the Y axis

    public void setSize(int w, int h){
        this.width = w;
        this.height = h;
        ppuX = (float)width / CAMERA_WIDTH;
        ppuY = (float)height / CAMERA_HEIGHT;
    }

    private void loadTextures(){
        bobTexture = new Texture(Gdx.files.internal("bob_01.png"));
        blockTexture = new Texture(Gdx.files.internal("block.png"));
    }

    public WorldRenderer(World world, boolean debug){
        this.world = world;
        this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
        this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
        this.cam.update();
        this.debug = debug;
        spriteBatch = new SpriteBatch();
        loadTextures();
    }

    public void render(){
        spriteBatch.begin();
            drawBlocks();
            drawBob();
        spriteBatch.end();
        if(debug)
            drawDebug();
    }

    /** Draw the objects on the map **/
    private void drawBob(){
        Bob bob = world.getBob();
        spriteBatch.draw(bobTexture, bob.getPosition().x * ppuX, bob.getPosition().y * ppuY);
    }

    private void drawBlocks(){
        for(Block block : world.getBlocks()){
            spriteBatch.draw(blockTexture, block.getPosition().x * ppuX, block.getPosition().y * ppuY);
        }
    }

    private void drawDebug(){
        //render blocks
        debugRenderer.setProjectionMatrix(cam.combined);
        debugRenderer.begin(ShapeType.Line);

        for(Block block : world.getBlocks()){
            Rectangle rect = block.getBounds();
            float x1 = block.getPosition().x + rect.x;
            float y1 = block.getPosition().y + rect.y;
            debugRenderer.setColor(new Color(1, 0, 0, 1));
            debugRenderer.rect(x1, y1, rect.width, rect.height);
        }

        //render Bob
        Bob bob = world.getBob();
        Rectangle rect = bob.getBounds();
        float x1 = bob.getPosition().x + rect.x;
        float y1 = bob.getPosition().y + rect.y;
        debugRenderer.setColor(new Color(0, 1, 0, 1));
        debugRenderer.rect(x1, y1, rect.width, rect.height);
        debugRenderer.end();
    }
}
