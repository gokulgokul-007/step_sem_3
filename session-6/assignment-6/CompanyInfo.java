public class CompanyInfo {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new CompanyInfo("Ravi", 45000);
        new CompanyInfo("Divya", 55000);
        new CompanyInfo("Karthik", 60000);

        CompanyInfo.printCompanyInfo();
    }
}