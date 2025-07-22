package practice_3;

public class Company {
    static String companyName;
    final int employeeID;
    String employeeName;

    public Company(int employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        printCompanyName();
    }

    static  void printCompanyName(){
        System.out.println(Company.companyName);
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;


    }

    public static void main(String[] args) {
        companyName = "New name";
        Company pers1 = new Company(1,"Lexa");
        Company pers2 = new Company(1,"Serega");
       // pers1.employeeID = 11; -так делять нельзя константа





    }
}
