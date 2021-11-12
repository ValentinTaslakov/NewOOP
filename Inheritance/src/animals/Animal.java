package animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setGender(gender);
        this.setName(name);
        this.setAge(age);
    }

    public void setName(String name){
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public void setAge(int age){
        if (age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }
    public void setGender(String gender){
        if (gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String produceSound(){
        return null;
    }

    @Override
    public String toString() {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getSimpleName()).append(System.lineSeparator());
            stringBuilder.append(this.name).append(" ").append(this.age).append(" ").append(this.gender).append(System.lineSeparator());
            stringBuilder.append(this.produceSound());
            return stringBuilder.toString();

    }
}
