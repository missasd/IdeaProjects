package DesignPattern.Behavior.IteratorPattern;

public class NameRepository implements Container {

    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};



    @Override
    public Diedaitor getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Diedaitor{

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
