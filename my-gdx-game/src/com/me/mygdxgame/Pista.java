package com.me.mygdxgame;

import java.io.File;

import aurelienribon.bodyeditor.BodyEditorLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Pista {
	private TampinhaWorld world;
	private Texture texture;
	private String imageURL = "data" + File.separator + "pista2.png";
	private Sprite sprite;
	private Body speedwayBody;
	private SpriteBatch spriteBatch;

	public Pista(TampinhaWorld world) {
		this.world = world;
		criarPista();
		criarImagemDaPista();
	}

	private void criarPista() {
		// 0. Create a loader for the file saved from the editor.
	    BodyEditorLoader loader = new BodyEditorLoader(Gdx.files.internal("data" + File.separator + "teste-body-editor.json"));
	 
	    // 1. Create a BodyDef, as usual.
	    BodyDef bd = new BodyDef();
	    bd.position.set(300, 250);
	    bd.type = BodyType.StaticBody;
	 
	    // 2. Create a FixtureDef, as usual.
	    FixtureDef fd = new FixtureDef();
	    fd.density = 1;
	    fd.friction = 0.5f;
	    fd.restitution = 0.3f;
	 
	    speedwayBody = world.createBody(bd);
	 
	    float SPEEDWAY_WIDTH = 250f;
		// 4. Create the body fixture automatically by using the loader.
	    loader.attachFixture(speedwayBody, "Name", fd, SPEEDWAY_WIDTH );
		
	}
	
	private void criarImagemDaPista() {
		texture = new Texture(imageURL);

		// setting a filter is optional, default = Nearest
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		// binding texture to sprite and setting some attributes
		sprite = new Sprite(texture);
		sprite.setSize(512f, 512f);
		sprite.setPosition(speedwayBody.getPosition().x,
				speedwayBody.getPosition().y);

		spriteBatch = new SpriteBatch();

	}
	
	public void render() {
		spriteBatch.begin();
		sprite.setPosition(speedwayBody.getPosition().x,
				speedwayBody.getPosition().y);

		// this is only one possible drawing out of many
		sprite.draw(spriteBatch);

		// this is another one
		spriteBatch.draw(texture, speedwayBody.getPosition().x,
				speedwayBody.getPosition().y, 512, 512, texture.getWidth(),
				texture.getHeight());

		// and a third...
		sprite.draw(spriteBatch, 100);

		spriteBatch.end();

		// re-enable GL state... (if you need it)
//		Gdx.gl.glEnable(GL10.GL_CULL_FACE);

	}
}
