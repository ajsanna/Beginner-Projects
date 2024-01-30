/*
 * 	Name: Alexander J Sanna 
 * 	Project 2
 * 	Due: October 7th, 2022
 * 	Course: cs-2400-02-f22
 * 
 * 			
 * Description:
 * 			Test file for the linked list data structure. 
 */

public class SetTest 
{
	public static void main(String[] args)
	{ 

		SetInterface<Integer> set = new LinkedSet<>();
		SetInterface<Integer> set2 = new LinkedSet<>();

		System.out.println("Set ADT by: A. Sanna");
		set.add(2);
		set.add(1);
		set.add(3);
		set2.add(1);
		set2.add(2);
		set2.add(3);

		System.out.println("Set A: " + set.toString());
		System.out.println("Set B: " + set2.toString());
		
		System.out.println();
		System.out.println("Set A Not Empty: " + !set.isEmpty());
		System.out.println("Set B Not Empty: " + !set2.isEmpty());
		System.out.println();
		System.out.println("Set A current size: " + set.getCurrentSize());
		System.out.println("Set B current size: " + set2.getCurrentSize());
		System.out.println();
		System.out.println("Add 5 to set A: " + set.add(5));
		System.out.println("Set A now contains: " + set.toString());
		System.out.println("Remove 5 from set 1: " + set.remove(5));
		System.out.println("Set A now contains: " + set.toString());
		System.out.println("Remove from set 1: " + set.remove());
		System.out.println("Set A now contains: " + set.toString());
		System.out.println("Add 3 to set 1: " + set.add(3));


		System.out.println();

		System.out.println("Set 2 contains 3: " + set2.contains(3));
		System.out.println("Set 2 contains 5: " + set2.contains(5));
		
		System.out.println();
		System.out.println("Set A subset Set B: " + set.subset(set2));
		System.out.println("Set A equals Set B: " + set.equals(set2));
		System.out.println("Set A union Set B: " + set.union(set2).toString());

		System.out.println();

		set.clear();
		set2.clear();
		System.out.println("After clearing both sets, Set A: " + set.toString());
		System.out.println("empty returns: "+ set.isEmpty());
		System.out.println();
		System.out.println();
		System.out.println();
		set.add(210);
		set.add(340);
		set.add(2);
		set.add(673);
		set2.add(3);
		System.out.println("Test 2: ");
		System.out.println("Set A: " + set.toString());
		System.out.println("Set B: " + set2.toString());

		System.out.println("Set A current size: " + set.getCurrentSize());
		System.out.println("Set B current size: " + set2.getCurrentSize());
		System.out.println();
		System.out.println("Add 5 to set A: " + set.add(5));
		System.out.println("Set A now contains: " + set.toString());
		System.out.println("Remove 5 from set 1: " + set.remove(5));
		System.out.println("Set A now contains: " + set.toString());
		System.out.println("Remove from set 1: " + set.remove());
		System.out.println("Set A now contains: " + set.toString());
		System.out.println("Add 3 to set 1: " + set.add(3));

		System.out.println();

		System.out.println("Set 2 contains 3: " + set2.contains(3));
		System.out.println("Set 2 contains 5: " + set2.contains(5));
		
		System.out.println();
		System.out.println("Set A subset Set B: " + set.subset(set2));
		System.out.println("Set A equals Set B: " + set.equals(set2));
		System.out.println("Set A union Set B: " + set.union(set2).toString());

		SetInterface set3 = set.union(set2);

		Object[] setOfBoth = set3.toArray();

		for(int i = 0 ; i < setOfBoth.length; i++)
		{
			System.out.println("Component " + i+1 + ": " + setOfBoth[i].toString());


		}


		System.out.println();
		System.out.println("Test 3");
		set.clear();
        set2.clear();
        set.add(10);
        set.add(20);
        set2.add(30);
        set2.add(40);
		System.out.println("Set A: " + set.toString());
		System.out.println("Set B: " + set2.toString());
		
		System.out.println();
		System.out.println("Set A Not Empty: " + !set.isEmpty());
		System.out.println("Set B Not Empty: " + !set2.isEmpty());
		System.out.println();
		System.out.println("Set A current size: " + set.getCurrentSize());
		System.out.println("Set B current size: " + set2.getCurrentSize());
		System.out.println();
		System.out.println("Add 5 to set A: " + set.add(5));
		System.out.println("Set A now contains: " + set.toString());
		System.out.println("Remove 5 from set 1: " + set.remove(5));
		System.out.println("Set A now contains: " + set.toString());
		System.out.println("Remove from set 1: " + set.remove());
		System.out.println("Set A now contains: " + set.toString());
		System.out.println("Add 3 to set 1: " + set.add(3));


		System.out.println();

		System.out.println("Set 2 contains 3: " + set2.contains(3));
		System.out.println("Set 2 contains 5: " + set2.contains(5));
		
		System.out.println();
		System.out.println("Set A subset Set B: " + set.subset(set2));
		System.out.println("Set A equals Set B: " + set.equals(set2));
		System.out.println("Set A union Set B: " + set.union(set2).toString());

		System.out.println();

		set.clear();
		
		System.out.println("After clearing both sets, Set A: " + set.toString());
		System.out.println("empty returns: "+ set.isEmpty());
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("Test 4");

		set.clear();
		System.out.println("Set A: " + set.toString());
		System.out.println("Set B: " + set2.toString());
		
		System.out.println();
		System.out.println("Set A Not Empty: " + !set.isEmpty());
		System.out.println("Set B Not Empty: " + !set2.isEmpty());
		System.out.println();
		System.out.println("Set A current size: " + set.getCurrentSize());
		System.out.println("Set B current size: " + set2.getCurrentSize());
		System.out.println();
		System.out.println("Add 5 to set A: " + set.add(5));
		System.out.println("Set A now contains: " + set.toString());
		System.out.println("Remove 5 from set 1: " + set.remove(5));
		System.out.println("Set A now contains: " + set.toString());
	
		
		


		System.out.println();

		System.out.println("Set 2 contains 3: " + set2.contains(3));
		System.out.println("Set 2 contains 5: " + set2.contains(5));
		
		System.out.println();
		System.out.println("Set A subset Set B: " + set.subset(set2));
		System.out.println("Set A equals Set B: " + set.equals(set2));
		System.out.println("Set A union Set B: " + set.union(set2).toString());

		System.out.println();

		set.clear();
		
		System.out.println("After clearing both sets, Set A: " + set.toString());
		System.out.println("empty returns: "+ set.isEmpty());
		System.out.println();
		System.out.println();
		System.out.println();

	}
	
	
	
	

	




}
