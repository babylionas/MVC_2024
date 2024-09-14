public class Cow {
    private String id;
    private String breed; // White or Brown
    private int ageYears;
    private int ageMonths;
    private boolean isBSOD;
    private boolean hasLemon; // กรณีวัวสีขาวกินมะนาว
    private int milkProducedCount; // จำนวนขวดนมที่วัวตัวนี้ผลิตไปแล้ว

    public Cow(String id, String breed, int ageYears, int ageMonths) {
        this.id = id;
        this.breed = breed;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.isBSOD = false;
        this.hasLemon = false;
        this.milkProducedCount = 0;
    }

    public String getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public boolean isBSOD() {
        return isBSOD;
    }

    public void setBSOD(boolean isBSOD) {
        this.isBSOD = isBSOD;
    }

    public void setHasLemon(boolean hasLemon) {
        this.hasLemon = hasLemon;
    }

    public int getMilkProducedCount() {
        return milkProducedCount;
    }

    public void resetMilkProduced() {
        this.milkProducedCount = 0;
    }


    // ฟังก์ชันรีดนม
    public String milk() {
        if (isBSOD) {
            return "Cow is in BSOD state. Cannot produce milk.";
        }

        if ("White".equals(breed)) {
            // หากวัวสีขาวกินมะนาว
            if (hasLemon) {
                milkProducedCount++;
                return "Yogurt produced!";
            } else {
                double chanceSoyMilk = 0.5 * ageMonths; // โอกาสผลิตนมถั่วเหลือง
                if (Math.random() * 100 < chanceSoyMilk) {
                    this.isBSOD = true; // เกิดเหตุการณ์ BSOD
                    return "Soy milk produced! Milk is spoiled, and cow is in BSOD state.";
                } else {
                    milkProducedCount++;
                    return "Fresh milk produced!";
                }
            }
        } else if ("Brown".equals(breed)) {
            double chanceAlmondMilk = 1.0 * ageYears; // โอกาสผลิตนมอัลมอนด์
            if (Math.random() * 100 < chanceAlmondMilk) {
                this.isBSOD = true; // เกิดเหตุการณ์ BSOD
                return "Almond milk produced! Milk is spoiled, and cow is in BSOD state.";
            } else {
                milkProducedCount++;
                return "Chocolate milk produced!";
            }
        }
        return "No milk produced.";
    }
}
