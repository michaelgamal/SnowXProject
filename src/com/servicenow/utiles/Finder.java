package com.servicenow.utiles;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.servicenow.entities.Item2D;
import com.servicenow.entities.TargetItem;

public class Finder {



	private double accuracy=.6;

	public void setAccuracy(double value) {
		if (value >= 0 && value <= 1) {
			accuracy = value;
		}
	}

	public double getAccuracy() {
		return accuracy;
	}

	public List<TargetItem> analyze(Item2D source, Item2D target) {
		List<TargetItem> results = new ArrayList<>();

		int coordinatX = source.getLength() - target.getLength();
		int coordinatY = source.getHeight() - target.getHeight();

		for (int x = 0; x <= coordinatX; x++) {
			for (int y = 0; y <= coordinatY; y++) {
				Item2D subsetItem2D = source.createSubset(x, y, target.getLength(), target.getHeight());

				double item2DSimilarity = subsetItem2D.calculateSimilarity(target);
				if (item2DSimilarity >= accuracy) {
					TargetItem result = new TargetItem(item2DSimilarity);

					int endTargetX = x + target.getLength() - 1;
					int endTargetY = y + target.getHeight() - 1;

					Point topLeft = new Point(x, y);
					Point topRight = new Point(endTargetX, y);
					result.setTopPoints(topLeft, topRight);

					Point bottomLeft = new Point(x, endTargetY);
					Point bottomRight = new Point(endTargetX, endTargetY);
					result.setBottomPoints(bottomLeft, bottomRight);
					result.setItemtype(target.getItemType());
					results.add(result);
				}
			}
		}

		return results;
	}
}
