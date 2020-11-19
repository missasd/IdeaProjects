package DesignPattern.Behavior.IteratorPattern;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Diedaitor die = nameRepository.getIterator(); die.hasNext();){
            System.out.println("Name : " + die.next());
        }
    }
}
