public class CowStrikeApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CowView view = new CowView();
                CowController controller = new CowController(view);
                view.setVisible(true);
            }
        });
    }
}
