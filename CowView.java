import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CowView extends JFrame {
    private JTextField cowIdField = new JTextField(10);
    private JButton checkButton = new JButton("Check Cow");
    private JButton milkButton = new JButton("Milk Cow");
    private JButton resetButton = new JButton("Reset BSOD");
    private JButton lemonButton = new JButton("Add Lemon");
    private JButton showReportButton = new JButton("Show Report");
    private JButton backToInputButton = new JButton("Back to Input");
    
    private JLabel cowInfoLabel = new JLabel();
    private JLabel milkResultLabel = new JLabel();
    private JTextArea reportArea = new JTextArea(5, 20);

    public CowView() {
        setTitle("Cow Strike");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        add(new JLabel("Enter Cow ID:"));
        add(cowIdField);
        add(checkButton);
        add(cowInfoLabel);
        add(milkButton);
        add(lemonButton); // ปุ่มเพิ่มมะนาวสำหรับวัวสีขาว
        add(milkResultLabel);
        add(resetButton);
        add(showReportButton);
        add(new JScrollPane(reportArea)); // แสดงรายงาน
        add(backToInputButton);

        milkButton.setEnabled(false); // ปิดการใช้งานปุ่มรีดนมจนกว่าจะตรวจสอบวัวเสร็จ
        lemonButton.setEnabled(false); // ปิดปุ่มมะนาวจนกว่าจะตรวจสอบวัวสีขาว
        backToInputButton.setEnabled(false); // ปิดปุ่มกลับไปจนกว่าจะมีการแสดงรายงาน
    }

    public String getCowId() {
        return cowIdField.getText();
    }

    public void setCowInfo(String info) {
        cowInfoLabel.setText(info);
    }

    public void setMilkResult(String result) {
        milkResultLabel.setText(result);
    }

    public void enableMilkButton(boolean enable) {
        milkButton.setEnabled(enable);
    }

    public void enableLemonButton(boolean enable) {
        lemonButton.setEnabled(enable);
    }

    public void showReport(String report) {
        reportArea.setText(report);
        reportArea.setVisible(true);
        backToInputButton.setEnabled(true); // เปิดปุ่มกลับไปที่หน้ารับรหัสวัวหลังจากแสดงรายงาน
    }

    public void clearReport() {
        reportArea.setText("");
        reportArea.setVisible(false);
        backToInputButton.setEnabled(false);
    }

    // Add listeners
    public void addCheckButtonListener(ActionListener listener) {
        checkButton.addActionListener(listener);
    }

    public void addMilkButtonListener(ActionListener listener) {
        milkButton.addActionListener(listener);
    }

    public void addLemonButtonListener(ActionListener listener) {
        lemonButton.addActionListener(listener);
    }

    public void addResetButtonListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }

    public void addShowReportButtonListener(ActionListener listener) {
        showReportButton.addActionListener(listener);
    }

    public void addBackToInputButtonListener(ActionListener listener) {
        backToInputButton.addActionListener(listener);
    }
}
