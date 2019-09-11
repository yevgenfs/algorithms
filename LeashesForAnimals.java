package ua.lviv.iot.FirstLabLeashesForAnimals;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;

public class LeashesForAnimals {
 private String producer;
 private int maximumLengthOfTheLeash;
 private int maximumWeightOfTheAnimal;
 private String color;
 private static int margeComprasion = 0;
 private static int margeExchange = 0;
 
 public ArrayList<LeashesForAnimals> bubleMaximumWeightOfTheAnimalDecrease(ArrayList<LeashesForAnimals> objectList) {
  System.out.println("Algoritm:buble sort maximumWeightOfTheAnimal by Decrease");
 
  StopWatch watch = new StopWatch();
  watch.start();
  int comprasion = 0;
  int exchange = 0;
  for (int stepAlgoritm = 0; stepAlgoritm < objectList.size(); stepAlgoritm++) {
   for (int stepComparison = 0; stepComparison < objectList.size() - 1; stepComparison++, comprasion++) {

    if (objectList.get(stepComparison).getMaximumWeightOfTheAnimal() < objectList.get(stepComparison + 1)
      .getMaximumWeightOfTheAnimal()) {
     exchange++;
     LeashesForAnimals changer = new LeashesForAnimals();
     changer = objectList.get(stepComparison);
     objectList.set(stepComparison, objectList.get(stepComparison + 1));
     objectList.set(stepComparison + 1, changer);


    }
   }

  }
  
  watch.stop();
  System.out.println("Time of work: " + watch.getNanoTime()+"nano second");
  System.out.println("comprasion" + comprasion);
  System.out.println("exchange" + exchange);
  objectList.forEach((n) -> System.out.println(n));

  return objectList;

 }

 public ArrayList<LeashesForAnimals> margeMaximumLengthOfTheLeashIncrease(ArrayList<LeashesForAnimals> objectList) {
  System.out.println("Algoritm: marge sort maximumWeightOfTheAnimal by Increase");
  
  StopWatch watch = new StopWatch();
  watch.start();     
  if (objectList.size()>1) {
   objectList.get(0).margeSplit(objectList);
  }

  watch.stop();
 
  System.out.println("Time of work: " + watch.getNanoTime() +"nano second");
  System.out.println("comprasion" + margeComprasion);
  System.out.println("exchange" + margeExchange);
  objectList.forEach((n) -> System.out.println(n));
  return objectList;
 }
 
 public List<LeashesForAnimals> margeSplit(List<LeashesForAnimals> objectList) { 
     
  
  List<LeashesForAnimals> left =  new ArrayList<LeashesForAnimals>();
  List<LeashesForAnimals> right =   new ArrayList<LeashesForAnimals>();
   for (int i = 0 ; i<objectList.size()/2;i++){
    left.add(objectList.get(i)) ;
  }
   
   for (int i = objectList.size()/2 ; i<objectList.size();i++){
    right.add(objectList.get(i)) ;
   }
   
  if(left.size()>1) {
   
     left.get(0).margeSplit(left);
     
   }
     if (right.size()>1) {
      
     right.get(0).margeSplit(right);
     
   }
      left.get(0).margeConector(objectList,left,right);
      
  
  
  return objectList;
 }
 
 public List<LeashesForAnimals> margeConector(List<LeashesForAnimals> objectList,List<LeashesForAnimals> left ,List<LeashesForAnimals> right) { 
  
  
  int leftStep=0;
  int rightStep=0;
  for (int stepOfComprasion = 0; stepOfComprasion < objectList.size()-1; stepOfComprasion++) {
   
   if(left.get(leftStep).getMaximumLengthOfTheLeash()<right.get(rightStep).getMaximumLengthOfTheLeash()) {
    margeComprasion++;
    if(leftStep<left.size()) {
     objectList.set(stepOfComprasion,left.get(leftStep));
     leftStep++;
     }
    if (leftStep==left.size()) {
     
      for (int i = stepOfComprasion+1; i < objectList.size(); i++) {
       objectList.set(i,right.get(rightStep));
       rightStep++;
       
      }
      
      break;
     
     }
   }
   else  {
    margeExchange++;
    if(rightStep<right.size()) {
     
     
     objectList.set(stepOfComprasion,right.get(rightStep));
    rightStep++;
    
    }
    if (rightStep==right.size()) {
     for (int i = stepOfComprasion+1; i < objectList.size(); i++) {
      
      objectList.set(i,left.get(leftStep));
      leftStep++;
      
     }
     
     break;
    
    }
   }
  }
 
  return objectList;
 }
 
 
 

 @Override
 public String toString() {
  return "LeashesForAnimals [producer=" + producer + ", maximumLengthOfTheLeash=" + maximumLengthOfTheLeash
    + ", maximumWeightOfTheAnimal=" + maximumWeightOfTheAnimal + ", color=" + color +"]";
 }

 public LeashesForAnimals() {

 }

 public LeashesForAnimals(String producer, int maximumLengthOfTheLeash, int maximumWeightOfTheAnimal, String color) {

  this.producer = producer;
  this.maximumLengthOfTheLeash = maximumLengthOfTheLeash;
  this.maximumWeightOfTheAnimal = maximumWeightOfTheAnimal;
  this.color = color;
 }

 public String getProducer() {
  return producer;
 }

 public void setProducer(String producer) {
  this.producer = producer;
 }

 public int getMaximumLengthOfTheLeash() {
  return maximumLengthOfTheLeash;
 }

 public void setMaximumLengthOfTheLeash(int maximumLengthOfTheLeash) {
  this.maximumLengthOfTheLeash = maximumLengthOfTheLeash;
 }

 public int getMaximumWeightOfTheAnimal() {
  return maximumWeightOfTheAnimal;
 }

 public void setMaximumWeightOfTheAnimal(int maximumWeightOfTheAnimal) {
  this.maximumWeightOfTheAnimal = maximumWeightOfTheAnimal;
 }

 public String getColor() {
  return color;
 }

 public void setColor(String color) {
  this.color = color;
 }

 public static void main(String[] args) {
	 
	  StopWatch watch = new StopWatch();
	  watch.start();
  List<LeashesForAnimals> objectList = new ArrayList<LeashesForAnimals>();
  objectList.add(new LeashesForAnimals("GUCCi", 10, 20, "red"));
  objectList.add(new LeashesForAnimals("GUCCi", 30, 40, "blue"));
  objectList.add(new LeashesForAnimals("NULP", 1, 50, "green"));
  objectList.add(new LeashesForAnimals("NULP", 12, 10, "yellow"));
  objectList.add(new LeashesForAnimals("Soft Serve", 100, 2, "black"));
  System.out.println("Before sorting");
  objectList.forEach((n) -> System.out.println(n));
  LeashesForAnimals animalLeashesTestObj = new LeashesForAnimals();
  animalLeashesTestObj.bubleMaximumWeightOfTheAnimalDecrease((ArrayList<LeashesForAnimals>) objectList);
  animalLeashesTestObj.margeMaximumLengthOfTheLeashIncrease((ArrayList<LeashesForAnimals>) objectList);
  
  watch.stop();
  System.out.println("Time of work: " + watch.getTime()+"ms");
 }

}