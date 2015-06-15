package cost;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Matrix m = new Matrix();
		Input in = new Input();

		System.out.println("Enter the number of tests: ");
		int numOfTests = in.inNum();
		System.out.println("Enter the number of cities: ");
		int numOfCities = in.inNum();

		m.fill(in, numOfCities);

		int tests = 0;
		//beginning of the algorithm
		while (tests++ < numOfTests) {
			Set<City> visited = new HashSet<City>();
			Map<City, Integer> minCost = new HashMap<City, Integer>();

			System.out.println("Enter starting point:");
			City source = m.getCity(in.inText());

			System.out.println("Enter destination:");
			City target = m.getCity(in.inText());
			
			//setting all costs to maximum for further comparison
			int min = Integer.MAX_VALUE;
			for (City c : m.getCities()) {
				minCost.put(c, min);
			}
			
			//setting first node
			City current = source;
			minCost.put(source, 0);
			
			//checking all unvisited cities
			while (visited.size() < numOfCities - 1) {
				//counting costs for all nieghboring cities of the current node
				for (int[] i : current.getNeighbors()) {
					City neighbor = m.getCity(i[0]);
					
					//compare and write minimal cost
					if (minCost.get(current) + i[1] < minCost.get(neighbor)
							&& !visited.contains(neighbor)) {
						minCost.put(neighbor, minCost.get(current) + i[1]);
					}
				}
				//add city to the visited list
				visited.add(current);
				//move to the next node
				current = m.closestCity(current, visited);
			}

			System.out.println("minimun transportation cost from "
					+ source.getName() + " to " + target.getName() + ": "
					+ minCost.get(target));

		}
	}
}