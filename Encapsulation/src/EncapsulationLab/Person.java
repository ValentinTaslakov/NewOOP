package EncapsulationLab;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age,double salary) {
       this.setFirstName(firstName);
       this.setLastName(lastName);
       this.setAge(age);
       this.setSalary(salary);
    }


    public Person(String firstName, String lastName, int age){
        this(firstName,lastName,age,0.0);
    }

    private void setAge(int age) {
        if (age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private void setLastName(String lastName) {
       ensureNameLength(lastName,"Last");
        this.lastName = lastName;
    }

    private void setFirstName(String firstName) {
       ensureNameLength(firstName,"First");
        this.firstName = firstName;
    }

    private void setSalary(double salary) {
        if (salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    private void ensureNameLength(String nameParam, String messagePrefix){
        if (nameParam.length() < 3){
            throw new IllegalArgumentException(messagePrefix +
                    " name cannot be less than 3 symbols");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double increment){
        if (age < 30){
            setSalary(salary * (1+increment/200));
        }else {
            setSalary(salary * (1+increment/100));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old."
                ,firstName , lastName , age);
    }
}
