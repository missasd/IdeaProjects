package DesignPattern.Builder.Factory.SimpleFactory;

/**
 * Factory
 */
public class PhoneFactory {
    public Phone makePhone(String phoneType){
        if (phoneType.equalsIgnoreCase("MiPhone")){
            return new MiPhone();
        }else if (phoneType.equalsIgnoreCase("iPhone")){
            return new IPhone();
        }
        return null;
    }
}
