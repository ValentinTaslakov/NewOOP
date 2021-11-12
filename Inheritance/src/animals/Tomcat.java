package animals;

public class Tomcat extends Cat{
    private static final String Gender = "Male";

    public Tomcat(String name, int age) {
        super(name, age, Gender);
    }

    @Override
    public String produceSound(){
        return "MEOW";
    }
}
