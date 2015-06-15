package cost;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Matrix {
	private List<City> cities = new ArrayList<City>();
	
	public List<City> getCities() {
		return cities;
	}
	
	/*
	 * method returns a city by name
	 * 
	 * @param name - name of a city to be found
	 */
	public City getCity(String name) {
		for (City c : cities) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		throw new RuntimeException("City not found!");
	}
	
	/*
	 * method returns a city by id
	 * 
	 * @param id - id of a city to be found
	 */
	public City getCity(int id) {
		for (City c : cities) {
			if (c.getId() == id) {
				return c;
			}
		}
		throw new RuntimeException("City not found!");
	}
	
	/*
	 * method returns the next closest unvisited city to the current city
	 * 
	 * @param c - current city
	 * @param visited - set of visited cities
	 */
	public City closestCity(City c, Set<City> visited) {
		int index = Integer.MAX_VALUE;
		for (int[] i : c.getNeighbors()) {
			if (index > i[1] && !visited.contains(getCity(i[0]))) {
				index = i[0];
			}
		}
		if (index < Integer.MAX_VALUE) {
			City r = getCity(index);
			return r;
		}
		return c;
	}
	
	/*
	 * algorithm to fill the matrix with cities and transportation costs
	 * 
	 * @param in - input class
	 * @param numOfCities - limit of cities to enter
	 */
	public void fill(Input in, int numOfCities) {
		for (int i = 0; i < numOfCities; i++) {
			City c = new City();
			c.setId(i + 1);
			System.out.println("Enter city name: ");
			c.setName(in.inText());
			System.out.println("Enter number of neighbours: ");
			int neighbors = in.inNum();
			int[][] n = new int[neighbors][2];
			for (int j = 0; j < neighbors; j++) {
				System.out.println("Enter neighbour id: ");
				n[j][0] = in.inNum();
				System.out.println("Enter travel cost: ");
				n[j][1] = in.inNum();
			}
			c.setNeighbors(n);
			cities.add(c);
		}
	}

}
