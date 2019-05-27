package com.servicenow.entities;


public class Item2D {

	
	private char[][] pixels;
	private String itemType;

	


	public Item2D(char[][] pixelGrid ) {
		
		this.pixels = pixelGrid != null ? pixelGrid : new char[][] {};
	}

	

	
	public int getHeight() {
		return pixels.length;
	}

	public int getLength() {
		if (pixels.length > 0 && pixels[0] != null) {
			return pixels[0].length;
		} else {
			return 0;
		}
	}
	public int getResolution() {
		return getLength() * getHeight();
	}


	public boolean hasPixel(int x, int y) {
		return pixels.length > 0 && y < pixels.length && pixels[0].length > 0 && x < pixels[0].length;
	}

	public char getPixel(int x, int y) {
		return pixels[y][x];
	}
	public double calculateSimilarity(Item2D item2d) {
		boolean validImage = this.getLength() == item2d.getLength() && this.getHeight() == item2d.getHeight()
				&& item2d.getResolution() > 0;
		if (!validImage) {
			return -1;
		}

		double matchedPixels = 0;
		for (int x = 0; x < item2d.getLength(); x++) {
			for (int y = 0; y < item2d.getHeight(); y++) {
				if (this.getPixel(x, y) == item2d.getPixel(x, y)) {
					matchedPixels++;
				}
			}
		}

		return matchedPixels / (double) item2d.getResolution();
	}


	public Item2D createSubset(int startX, int startY, int length, int height) {
		int endX = startX + length - 1;
		int endY = startY + height - 1;
		if (!hasPixel(startX, startY) || !hasPixel(endX, endY)) {
			return null;
		}

		char[][] subset = new char[height][length];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < length; x++) {
				subset[y][x] = getPixel(startX + x, startY + y);
			}
		}

		return new Item2D(subset);
	}



	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Override
	public String toString() {
		if (getResolution() == 0) {
			return "";
		}

		final String NEWLINE = System.lineSeparator();
		StringBuilder sb = new StringBuilder();

		sb.append(" ");
		sb.append(this.itemType);
		for (int x = 0; x < getLength(); x++) {
			sb.append(x);
		}
		sb.append(NEWLINE);

		for (int y = 0; y < getHeight(); y++) {
			sb.append(y);
			for (int x = 0; x < getLength(); x++) {
				sb.append(getPixel(x, y));
			}
			sb.append(NEWLINE);
		}

		return sb.toString();
	}

	
}
