package com.example.hellolibgdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MyGame implements ApplicationListener {
	// 定义一个Stage对象
	Stage stage;
	// 定义一个CheckBox对象
	CheckBox checkBox;
	// 定义CheckBox的样式
	CheckBoxStyle style;
	// 定义合图类
	TextureAtlas atlas;
	// 定义CheckBox没有被选中时的状态所对应的Drawable对象
	TextureRegionDrawable checkBoxOffDrawable;
	// 定义CheckBox被选中时的状态所对应的Drawable对象
	TextureRegionDrawable checkBoxOnDrawable;
	// 定义CheckBox没有被选中时的状态所对应的Region对象
	TextureRegion checkBoxOffRegion;
	// 定义CheckBox被选中时的状态所对应的Region对象
	TextureRegion checkBoxOnRegion;
	// 定义CheckBox中需要用到的字体文件
	BitmapFont font;
	// 定义界面AImage对象
	Image bgImage;
	// 定义界面A所对应的Region对象
	TextureRegion bgRegion;
	// 用于背景资源Atlas文件
	TextureAtlas bgAtlas;
	// 背景图片
	Image bbgImage;
	// 用作背景的资源的Region对象
	TextureRegion bbgRegion;

	@Override
	public void create() {
		// 初始化Stage对象
		stage = new Stage(480, 800, false);
		// 初始化和图雷
		atlas = new TextureAtlas(Gdx.files.internal("data/bofang.atlas"));
		// 初始化没有选中状态的Region对象
		checkBoxOffRegion = atlas.findRegion("bofang1");
		// 初始化选中状态的Region对象
		checkBoxOnRegion = atlas.findRegion("bofang2");
		// 初始化没有选中状态的Drwable对象
		checkBoxOffDrawable = new TextureRegionDrawable(checkBoxOffRegion);
		// 初始化选中状态的Drwable对象
		checkBoxOnDrawable = new TextureRegionDrawable(checkBoxOnRegion);
		// 初始化CheckBox所需要用到的字体文件
		font = new BitmapFont(Gdx.files.internal("data/font.fnt"), false);
		// 初始化构造CheckBox所需要用到的Style对象
		style = new CheckBoxStyle(checkBoxOffDrawable, checkBoxOnDrawable,
				font, Color.YELLOW);
		// 初始化CheckBox
		checkBox = new CheckBox("selected", style);
		// 设置CheckBox的位置
		checkBox.setPosition(100, 100);
		// 给CheckBox注册监听器
		addListenerOnCheckBoxToChangeScreen();

		// 场景A所对应的Region对象
		bgRegion = new TextureRegion(atlas.findRegion("bg"));
		// 场景A所对应的Image对象
		bgImage = new Image(bgRegion);
		// 设置场景A的大小
		bgImage.setSize(480, 800);
		// atlas对象的初始化
		bgAtlas = new TextureAtlas(Gdx.files.internal("data/movebg.atlas"));
		// 整个场景的背景的Region对象的初始化
		bbgRegion = bgAtlas.findRegion("movebg");
		// Image对象的初始化
		bbgImage = new Image(bbgRegion);
		// 设置图片的大小
		bbgImage.setSize(480, 800);
		// 将背景B添加到舞台
		stage.addActor(bbgImage);
		// 将背景A添加到舞台
		stage.addActor(bgImage);
		// 将CheckBox添加到舞台
		stage.addActor(checkBox);
		// 使用Stage对象来处理输入输出事件
		Gdx.input.setInputProcessor(stage);
	}

	/**
	 * 给CheckBox添加监听器,用于操控界面的切换
	 */
	public void addListenerOnCheckBoxToChangeScreen() {
		//给滑块注册监听器
		checkBox.addListener(new InputListener() {
			/**
			 * 当手指按下时执行
			 */
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				//如果复选框被选中
				if (checkBox.isChecked() == true) {
					//将背景设置成不可见
					bgImage.setVisible(false);
				} else {//如果复选框没有被选中
					//将背景设置成可见
					bgImage.setVisible(true);
				}

				return true;
			}
		});
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);// 设置背景为白色
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// 清屏

		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
