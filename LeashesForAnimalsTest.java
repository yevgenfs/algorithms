package ua.lviv.iot.FirstLabLeashesForAnimals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeashesForAnimalsTest {
    
	LeashesForAnimals animalLeashesTestObj = new LeashesForAnimals();
	List<LeashesForAnimals> objectList = new ArrayList<LeashesForAnimals>();
	
	@BeforeEach
	void setUp() throws Exception {
		objectList.add(new LeashesForAnimals("GUCCi", 10, 20, "red"));
		objectList.add(new LeashesForAnimals("GUCCi", 30, 40, "blue"));
		objectList.add(new LeashesForAnimals("NULP", 1, 50, "green"));
		objectList.add(new LeashesForAnimals("NULP", 12, 10, "yellow"));
		objectList.add(new LeashesForAnimals("Soft Serve", 100, 2, "black"));
		  
	}

	@Test
	void testBubleMaximumWeightOfTheAnimalDecrease() {
		animalLeashesTestObj.bubleMaximumWeightOfTheAnimalDecrease((ArrayList<LeashesForAnimals>) objectList);
		assertEquals(50, objectList.get(0).getMaximumWeightOfTheAnimal());
		assertEquals(40, objectList.get(1).getMaximumWeightOfTheAnimal());
		assertEquals(20, objectList.get(2).getMaximumWeightOfTheAnimal());
		assertEquals(10, objectList.get(3).getMaximumWeightOfTheAnimal());
		assertEquals(2, objectList.get(4).getMaximumWeightOfTheAnimal());
	}

	@Test
	void testMargeMaximumLengthOfTheLeashIncrease() {
		animalLeashesTestObj.margeMaximumLengthOfTheLeashIncrease((ArrayList<LeashesForAnimals>) objectList);
		assertEquals(1, objectList.get(0).getMaximumLengthOfTheLeash());
		assertEquals(10, objectList.get(1).getMaximumLengthOfTheLeash());
		assertEquals(12, objectList.get(2).getMaximumLengthOfTheLeash());
		assertEquals(30, objectList.get(3).getMaximumLengthOfTheLeash());
		assertEquals(100, objectList.get(4).getMaximumLengthOfTheLeash());
	}

}
