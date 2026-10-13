public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String oldCode, String newCode) {
        if (!code.equals(oldCode)) {
            return false;
        }
        code = newCode;
        return true;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println(l.changeCode("1234", "5678") ? "success" : "rejected");
        System.out.println(l.changeCode("0000", "9999") ? "success" : "rejected");
        // proves the code is still "5678"
        System.out.println(l.changeCode("5678", "5678") ? "code is still 5678" : "code changed");
    }
}