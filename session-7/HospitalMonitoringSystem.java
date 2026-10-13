class EmergencyAlert extends Thread {
    EmergencyAlert() { super("EmergencyAlert"); }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " (priority " + getPriority() + "): critical patient alert " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

class VitalMonitor extends Thread {
    VitalMonitor() { super("VitalMonitor"); }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " (priority " + getPriority() + "): checking vital signs, round " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

class ReportGenerator extends Thread {
    ReportGenerator() { super("ReportGenerator"); }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " (priority " + getPriority() + "): preparing routine report " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

public class HospitalMonitoringSystem {
    public static void main(String[] args) {
        EmergencyAlert alert = new EmergencyAlert();
        VitalMonitor vitals = new VitalMonitor();
        ReportGenerator report = new ReportGenerator();

        alert.setPriority(Thread.MAX_PRIORITY);    // 10
        vitals.setPriority(Thread.NORM_PRIORITY);  // 5
        report.setPriority(Thread.MIN_PRIORITY);   // 1

        alert.start();
        vitals.start();
        report.start();
    }
}
