

// Product
class Person {

    private String name;
    private int age;
    private String gender;
    private int height;
    private int weight;
    private String education;
    private boolean isMarried;

    // Private constructor forces object creation through the Builder
    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.height = builder.height;
        this.weight = builder.weight;
        this.education = builder.education;
        this.isMarried = builder.isMarried;
    }

    @Override
    public String toString() {
        return "Person details:\n" +
                "name = " + name + "\n" +
                "age = " + age + "\n" +
                "gender = " + gender + "\n" +
                "height = " + height + "\n" +
                "weight = " + weight + "\n" +
                "education = " + education + "\n" +
                "isMarried = " + isMarried + "\n";
    }

    // Static nested Builder class
    public static class Builder {

        // Default values for optional attributes
        private String name = null;
        private int age = 0;
        private String gender = null;
        private int height = 0;
        private int weight = 0;
        private String education = null;
        private boolean isMarried = false;

        // Constructor for required attributes
        public Builder(String name) {
            this.name = name;
        }

        // Every method returns the current Builder object enabling method chaining
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder setEducation(String education) {
            this.education = education;
            return this;
        }

        public Builder setIsMarried(boolean isMarried) {
            this.isMarried = isMarried;
            return this;
        }

        // Builds and returns the final Person object
        public Person create() {
            return new Person(this);
        }
    }
}

class PersonBuilder {

    public static void main(String[] args) {

        // Create a Person with only the required and desired optional attributes
        Person alice = new Person.Builder("Alice")
                .setAge(24)
                .setEducation("Graduate")
                .setGender("Female")
                .setIsMarried(true)
                .create();

        System.out.println(alice);

        // Create another Person with a different combination of optional attributes
        Person bob = new Person.Builder("Bob")
                .setAge(21)
                .setHeight(154)
                .setWeight(75)
                .setGender("Male")
                .create();

        System.out.println(bob);
    }
}
