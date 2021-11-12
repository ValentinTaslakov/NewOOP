package animals;

public class Kitten extends Cat{
    private static final String Gender = "Female";

    public Kitten(String name, int age) {
        super(name, age, Gender);
    }

    @Override
    public String produceSound(){
        return "Meow";
    }
}
