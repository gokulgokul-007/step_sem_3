public class InventoryBalancer {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        int maxVal = sectionA[0], maxIndex = 0;
        String maxSection = "Section A";
        for (int v : sectionA) totalA += v;
        for (int v : sectionB) totalB += v;
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxVal) { maxVal = sectionA[i]; maxIndex = i; maxSection = "Section A"; }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxVal) { maxVal = sectionB[i]; maxIndex = i; maxSection = "Section B"; }
        }
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB +
                " | Status: " + status + " | Highest Quantity: " + maxVal +
                " (" + maxSection + ", Item " + (maxIndex+1) + ")");
    }
    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }
}