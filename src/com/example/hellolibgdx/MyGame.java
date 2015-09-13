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
	// ����һ��Stage����
	Stage stage;
	// ����һ��CheckBox����
	CheckBox checkBox;
	// ����CheckBox����ʽ
	CheckBoxStyle style;
	// �����ͼ��
	TextureAtlas atlas;
	// ����CheckBoxû�б�ѡ��ʱ��״̬����Ӧ��Drawable����
	TextureRegionDrawable checkBoxOffDrawable;
	// ����CheckBox��ѡ��ʱ��״̬����Ӧ��Drawable����
	TextureRegionDrawable checkBoxOnDrawable;
	// ����CheckBoxû�б�ѡ��ʱ��״̬����Ӧ��Region����
	TextureRegion checkBoxOffRegion;
	// ����CheckBox��ѡ��ʱ��״̬����Ӧ��Region����
	TextureRegion checkBoxOnRegion;
	// ����CheckBox����Ҫ�õ��������ļ�
	BitmapFont font;
	// �������AImage����
	Image bgImage;
	// �������A����Ӧ��Region����
	TextureRegion bgRegion;
	// ���ڱ�����ԴAtlas�ļ�
	TextureAtlas bgAtlas;
	// ����ͼƬ
	Image bbgImage;
	// ������������Դ��Region����
	TextureRegion bbgRegion;

	@Override
	public void create() {
		// ��ʼ��Stage����
		stage = new Stage(480, 800, false);
		// ��ʼ����ͼ��
		atlas = new TextureAtlas(Gdx.files.internal("data/bofang.atlas"));
		// ��ʼ��û��ѡ��״̬��Region����
		checkBoxOffRegion = atlas.findRegion("bofang1");
		// ��ʼ��ѡ��״̬��Region����
		checkBoxOnRegion = atlas.findRegion("bofang2");
		// ��ʼ��û��ѡ��״̬��Drwable����
		checkBoxOffDrawable = new TextureRegionDrawable(checkBoxOffRegion);
		// ��ʼ��ѡ��״̬��Drwable����
		checkBoxOnDrawable = new TextureRegionDrawable(checkBoxOnRegion);
		// ��ʼ��CheckBox����Ҫ�õ��������ļ�
		font = new BitmapFont(Gdx.files.internal("data/font.fnt"), false);
		// ��ʼ������CheckBox����Ҫ�õ���Style����
		style = new CheckBoxStyle(checkBoxOffDrawable, checkBoxOnDrawable,
				font, Color.YELLOW);
		// ��ʼ��CheckBox
		checkBox = new CheckBox("selected", style);
		// ����CheckBox��λ��
		checkBox.setPosition(100, 100);
		// ��CheckBoxע�������
		addListenerOnCheckBoxToChangeScreen();

		// ����A����Ӧ��Region����
		bgRegion = new TextureRegion(atlas.findRegion("bg"));
		// ����A����Ӧ��Image����
		bgImage = new Image(bgRegion);
		// ���ó���A�Ĵ�С
		bgImage.setSize(480, 800);
		// atlas����ĳ�ʼ��
		bgAtlas = new TextureAtlas(Gdx.files.internal("data/movebg.atlas"));
		// ���������ı�����Region����ĳ�ʼ��
		bbgRegion = bgAtlas.findRegion("movebg");
		// Image����ĳ�ʼ��
		bbgImage = new Image(bbgRegion);
		// ����ͼƬ�Ĵ�С
		bbgImage.setSize(480, 800);
		// ������B��ӵ���̨
		stage.addActor(bbgImage);
		// ������A��ӵ���̨
		stage.addActor(bgImage);
		// ��CheckBox��ӵ���̨
		stage.addActor(checkBox);
		// ʹ��Stage������������������¼�
		Gdx.input.setInputProcessor(stage);
	}

	/**
	 * ��CheckBox��Ӽ�����,���ڲٿؽ�����л�
	 */
	public void addListenerOnCheckBoxToChangeScreen() {
		//������ע�������
		checkBox.addListener(new InputListener() {
			/**
			 * ����ָ����ʱִ��
			 */
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				//�����ѡ��ѡ��
				if (checkBox.isChecked() == true) {
					//���������óɲ��ɼ�
					bgImage.setVisible(false);
				} else {//�����ѡ��û�б�ѡ��
					//���������óɿɼ�
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
		Gdx.gl.glClearColor(1, 1, 1, 1);// ���ñ���Ϊ��ɫ
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// ����

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
