package P4;

public class FarmTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Farm myFarm = new Farm("stat.dat");
		myFarm.getAnimals().addFirst(new Cow());
		myFarm.getAnimals().addLast(new Cow());
		myFarm.getAnimals().add(2, new Cow());
		Animal temp = myFarm.getAnimals().removeFirst();
		System.out.println("removed " + temp.getName());
		myFarm.getAnimals().set(0, new Llama());
		//you may want to test other linked list methods here
		for(Animal a: myFarm.getAnimals())
		a.setEnergy(10+Math.random()*90);
		System.out.printf("\nAvailable food before feeding: %.2f\n", 
		myFarm.getAvailableFood());
		System.out.println("\nInitial list of animals:\n-------------------------");
		myFarm.printAnimals();
		System.out.println("Adding a clone of the second animal\n----------------");
		myFarm.addClone(myFarm.getAnimals().get(1)); //change
		myFarm.printAnimals();
		System.out.println("List of starving animals:\n------------");
		System.out.println(myFarm.getAnimals().getStarvingAnimals());
		System.out.println("List of hungry animals:\n------------");
		System.out.println(myFarm.getAnimals().getHungryAnimals());
		System.out.printf("Amount of food needed to feed all animals: %.2f\n",myFarm.getAnimals().getRequiredFood());
		System.out.println("\nFeeding animals:\n--------------");
		myFarm.feedAnimals();
		System.out.printf("\nAvailable food after feeding: %.2f\n", 
		myFarm.getAvailableFood());
		System.out.println("\nFarm summary:\n--------------");
		myFarm.printSummary();
		myFarm.exit("stat.dat");

	}
	/*
     * The reason for deleting the stat.dat file created by the P3
     *  version of the Farm class before running the P4 version of
     *   the program is due to the inconsistency in the 
     *   serialization format and data structure between the two versions.
     *   In the P3 version, the Farm class uses standard Java arrays to 
     *   store data and implements serialization based on that structure. 
     *   However, in the P4 version, the Farm class has been updated to use
     *    a custom linked list (AnimalList) instead of arrays. The P4 version
     *     expects to deserialize data into an AnimalList object, but the stat.dat
     *      file contains serialized data based on arrays. There is an error
     *      The error message "local class incompatible: stream classdesc serialVersionUID" 
     *      indicates a serialization compatibility issue. This error occurs because the 
     *      AnimalList class has undergone changes in its structure or implementation 
     *      since the stat.dat file was created.
     */
}
