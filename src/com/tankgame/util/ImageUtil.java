package com.tankgame.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tankgame.common.Common;
import com.tankgame.object.UnitDetail;

public class ImageUtil implements Common {

	public static BufferedImage loadImage() {
		// ユニットのイメージをロード
		BufferedImage image = null;
		File imageFile = new File(IMAGE_ASSET);

		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}

	public void drawUnit(UnitDetail unit, Graphics g, int offsetX, int offsetY) {
		int cx = (unit.getUnitID() % 8) * (CS * 2);
		int cy = (unit.getUnitID() / 8) * (CS * 4);
		// countとdirectionの値に応じて表示する画像を切り替える
		g.drawImage(loadImage(), unit.getPx() + offsetX, unit.getPy() + offsetY, unit.getPx() + offsetX + CS, unit
				.getPy() + offsetY + CS, cx + UnitDetail.count * CS, cy + unit.getDirection() * CS, cx + CS
						+ UnitDetail.count * CS, cy + unit.getDirection() * CS + CS, null);
	}
}
