package hackerrank;

import java.util.*;
//import java.util.HashMap;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
	/**
	 * TODO: Create a map of Furniture items to order quantities
	 */
	private final Map<Furniture, Integer> furnitureMap;

	/**
	 * Initialize a new mapping of Furniture types to order quantities.
	 */
	FurnitureOrder() {
		// TODO: Complete the constructor
		furnitureMap = new HashMap<Furniture, Integer>();
	}

	public void addToOrder(final Furniture type, final int furnitureCount) {
		// TODO: Complete the method
		Integer count = 0;
		if (furnitureMap.containsKey(type)) {
			count = furnitureMap.get(type);
		}
		Integer updatedCount = count + furnitureCount;
		furnitureMap.put(type, updatedCount);
	}

	public HashMap<Furniture, Integer> getOrderedFurniture() {
		// TODO: Complete the method
		return new HashMap<Furniture, Integer>(furnitureMap);
	}

	public float getTotalOrderCost() {
		// TODO: Complete the method
		if (!furnitureMap.isEmpty()) {
				return furnitureMap.entrySet()
					.stream()
					.map(furniture -> furniture.getKey().cost() * furniture.getValue())
					.collect(Collectors.toList())
					.stream()
					.reduce(Float::sum)
					.get();
		}
		return 0.0f;
	}

	public int getTypeCount(Furniture type) {
		// TODO: Complete the method
		if (furnitureMap.containsKey(type)) {
			return furnitureMap.get(type);
		}
		return 0;
	}

	public float getTypeCost(Furniture type) {
		// TODO: Complete the method
		if (furnitureMap.containsKey(type)) {
			//System.out.println(furnitureMap.get(type));
			//System.out.println(furnitureMap.get(type.cost()));
			return furnitureMap.get(type) * type.cost();
		}
		return 0.0f;
	}

	public int getTotalOrderQuantity() {
		// TODO: Complete the method
		if (!furnitureMap.isEmpty()) {
			furnitureMap.values().stream().reduce(Integer::sum).get();
		}
		return 0;
	}
}