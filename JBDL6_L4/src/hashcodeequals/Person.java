package hashcodeequals;

public class Person {

    int id;
    String name;

    Person(int id, String name){
        this.id = id;
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        Person that = (Person) obj;
        if (this.id==that.id && this.name.equalsIgnoreCase(that.name)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id+this.name.hashCode();
    }
}
