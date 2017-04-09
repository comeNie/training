package com.comenie.lambda;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.Predicate;

public class FilteringApples{

	public static void main(String ... args){

		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));	

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples =  filter(inventory,apple -> "green".equals(apple.getColor()));
		System.out.println(greenApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples = filter(inventory,apple -> "red".equals(apple.getColor()));
		System.out.println(redApples);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples = filter(inventory, apple -> 120 > apple.getWeight());
		System.out.println(heavyApples);

		 inventory.sort(Comparator.comparing(Apple::getWeight));

		System.out.println(inventory);

		inventory.sort((a1,a2)->a1.getColor().compareTo(a2.getColor()));
		System.out.println(inventory);

	}

	public  static  List<Apple> filter(List<Apple> apples, Predicate<Apple> predicate){
		List<Apple> result = Lists.newArrayList();
		for(Apple apple : apples){
			if (predicate.test(apple)){
				result.add(apple);
			}
		}
		return  result;
	}

	public static class  Apple{
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color){
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}
}