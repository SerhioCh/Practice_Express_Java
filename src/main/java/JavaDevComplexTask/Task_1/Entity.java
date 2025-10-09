package JavaDevComplexTask.Task_1;

import java.util.Objects;

public class Entity {
    private String name;
    private int age;
    private  boolean isActive;

    public Entity(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return age == entity.age && isActive == entity.isActive && Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, isActive);
    }
}
