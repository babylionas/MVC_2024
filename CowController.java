import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CowController {
    private CowView view;
    private Map<String, Cow> cows;

    private int totalFreshMilk;
    private int totalYogurt;
    private int totalChocolateMilk;

    public CowController(CowView view) {
        this.view = view;
        this.cows = new HashMap<>();
        this.totalFreshMilk = 0;
        this.totalYogurt = 0;
        this.totalChocolateMilk = 0;
        createCowData();

        // ตรวจสอบรหัสวัว
        view.addCheckButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cowId = view.getCowId();
                Cow cow = cows.get(cowId);
                if (cow != null) {
                    if (cow.isBSOD()) {
                        view.setCowInfo("Cow " + cowId + " is in BSOD state.");
                        view.enableMilkButton(false);
                    } else {
                        view.setCowInfo("Cow ID: " + cow.getId() + ", Breed: " + cow.getBreed() + ", Age: " + cow.getAgeYears() + " years " + cow.getAgeMonths() + " months");
                        view.enableMilkButton(true);

                        // หากวัวเป็นสีขาว เปิดปุ่มเพิ่มมะนาว
                        if ("White".equals(cow.getBreed())) {
                            view.enableLemonButton(true);
                        } else {
                            view.enableLemonButton(false);
                        }
                    }
                } else {
                    view.setCowInfo("Cow not found.");
                    view.enableMilkButton(false);
                    view.enableLemonButton(false);
                }
            }
        });

        // รีดนม
        view.addMilkButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cowId = view.getCowId();
                Cow cow = cows.get(cowId);
                if (cow != null) {
                    String result = cow.milk();
                    view.setMilkResult(result);

                    // อัพเดทจำนวนขวดนมแต่ละชนิด
                    if (result.equals("Fresh milk produced!")) {
                        totalFreshMilk++;
                    } else if (result.equals("Yogurt produced!")) {
                        totalYogurt++;
                    } else if (result.equals("Chocolate milk produced!")) {
                        totalChocolateMilk++;
                    }
                }
            }
        });

        // เพิ่มมะนาวเพื่อผลิตนมเปรี้ยว
        view.addLemonButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cowId = view.getCowId();
                Cow cow = cows.get(cowId);
                if (cow != null && "White".equals(cow.getBreed())) {
                    cow.setHasLemon(true);
                    view.setMilkResult("Lemon added to cow for yogurt production!");
                }
            }
        });

        // Reset วัวที่เกิด BSOD
        view.addResetButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Cow cow : cows.values()) {
                    if (cow.isBSOD()) {
                        cow.setBSOD(false);
                    }
                }
                view.setMilkResult("All BSOD cows have been reset.");
            }
        });

        // แสดงรายงาน
        view.addShowReportButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String report = "Milk Report:\n";
                report += "Total Fresh Milk: " + totalFreshMilk + " bottles\n";
                report += "Total Yogurt: " + totalYogurt + " bottles\n";
                report += "Total Chocolate Milk: " + totalChocolateMilk + " bottles\n";
                view.showReport(report);
            }
        });

        // กลับไปหน้าจอรับรหัสวัว
        view.addBackToInputButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearReport();
            }
        });
    }

    // สร้างข้อมูลวัว
    private void createCowData() {
        cows.put("00000000", new Cow("00000000", "White", 5, 6));
        cows.put("00000001", new Cow("00000001", "Brown", 8, 2));
        cows.put("00000010", new Cow("00000010", "White", 3, 9));
        cows.put("00000011", new Cow("00000011", "Brown", 2, 11));
        cows.put("00000101", new Cow("00000101", "Brown", 1, 11));
        cows.put("00001001", new Cow("00001001", "White", 3, 5));
        cows.put("00001101", new Cow("00001101", "White", 5, 9));
        cows.put("00001010", new Cow("00001010", "Brown", 3, 6));
        cows.put("00001110", new Cow("00001110", "White", 4, 7));
        cows.put("00000111", new Cow("00000111", "Brown", 3, 10));
        cows.put("00001011", new Cow("00001011", "White", 10, 4));
        cows.put("00010111", new Cow("00010111", "White", 9, 3));
    }
}
