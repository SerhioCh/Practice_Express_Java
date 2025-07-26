package practice_3;

public class University {
    static String universityName;
    final int studentID;
    String studentName;

    public University(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }
    static void   changeUniversityName(String newName) {
         University.universityName = newName;
    }

    public String getStudentName() {
        return studentName;
    }
   void   printStudentInfo() {
       System.out.println("Имя: "+ studentName  + " ID: "+ studentID + " Университет: "+ universityName );
   }

    public static void main(String[] args) {
        University.changeUniversityName("New Univer");
        University u1 = new University(1,"Lexa");
        u1.printStudentInfo();
        University u2 = new University(2,"Sanya");
        u2.printStudentInfo();
        University u3 = new University(3,"Serega");
        u3.printStudentInfo();

    }
}
