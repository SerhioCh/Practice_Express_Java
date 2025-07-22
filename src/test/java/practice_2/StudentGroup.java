package practice_2;

public class StudentGroup {
    String groupName;
    int studentCount;

    public StudentGroup(String groupName, int studentCount) {
        this.groupName = groupName;
        this.studentCount = studentCount;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getStudentCount() {
        return this.studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }
    void printInfo(){
        System.out.println("Группа: "+ groupName + " Количество студентов: "+ studentCount);
    }

    public static void main(String[] args) {
        StudentGroup group1 = new StudentGroup("Nov",25);
        group1.printInfo();
        group1.setStudentCount(50);
        group1.printInfo();
    }
}
