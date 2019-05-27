package com.servicenow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.servicenow.entities.Item2D;
import com.servicenow.entities.TargetItem;
import com.servicenow.utiles.Finder;

public class SnowXApplication {

	public static void main(String[] args) throws IOException {

		Item2D hpShip = getSampleItem("src/samples/HPShip.snw");
		hpShip.setItemType("Ship");
		
		Item2D hbTorpedo = getSampleItem("src/samples/HPTorpedo.snw");
		hbTorpedo.setItemType("Torpedo");
		
		Item2D testData = getSampleItem("src/samples/TestData.snw");
	 
		Finder finder = new Finder();
		
		finder.setAccuracy(0.6);

		List<TargetItem> results = new ArrayList<>();
		
		results.addAll(finder.analyze(testData, hpShip));
		results.addAll(finder.analyze(testData, hbTorpedo));

		if (!results.isEmpty()) {
			System.out.println("Found " + results.size() + " targets:");
			results.stream().forEach(System.out::println);
		} else {
			System.out.println(" 0 Item Found");
		}
	}

	private static Item2D getSampleItem(String filePath) throws IOException {
		
		Path path = Paths.get(filePath);
		List<String> lines = Files.lines(path).collect(Collectors.toList());

		char[][] pixels = new char[lines.size()][];
		for (int i = 0; i < lines.size(); i++) {
			pixels[i] = lines.get(i).toCharArray();
		}

		return new Item2D(pixels);
	}

}
