import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WorkloadModelUI {
    private JFrame frame;
    private JLabel vusersLabel, tphLabel, durationLabel, scriptExecutionTimeLabel, thinkTimeLabel, pacingLabel;
    private JTextField vusersField, tphField, durationField, baselineField, thinkTimeField, pacingField;
    private JButton calculateButton;

    public WorkloadModelUI() {
        frame = new JFrame("Workload Model Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        vusersLabel = new JLabel("No of Total Vusers");
        tphLabel = new JLabel("TPH value");
        durationLabel = new JLabel("Test duration in seconds");
        scriptExecutionTimeLabel = new JLabel("Script execution time in seconds");
        thinkTimeLabel = new JLabel("Total think time in seconds: ");
        pacingLabel = new JLabel("Pacing value");
        JLabel emptyLabel = new JLabel(" ");

        vusersField = new JTextField();
        vusersField.setPreferredSize(new Dimension(100, 25));
        vusersField.setMinimumSize(new Dimension(100, 25));
        vusersField.setMaximumSize(new Dimension(100, 25));

        tphField = new JTextField();
        tphField.setPreferredSize(new Dimension(100, 25));
        tphField.setMinimumSize(new Dimension(100, 25));
        tphField.setMaximumSize(new Dimension(100, 25));

        durationField = new JTextField();
        durationField.setPreferredSize(new Dimension(100, 25));
        durationField.setMinimumSize(new Dimension(100, 25));
        durationField.setMaximumSize(new Dimension(100, 25));
        baselineField = new JTextField();
        baselineField.setPreferredSize(new Dimension(100, 25));
        baselineField.setMinimumSize(new Dimension(100, 25));
        baselineField.setMaximumSize(new Dimension(100, 25));
        thinkTimeField = new JTextField();
        thinkTimeField.setPreferredSize(new Dimension(100, 25));
        thinkTimeField.setMinimumSize(new Dimension(100, 25));
        thinkTimeField.setMaximumSize(new Dimension(100, 25));
        pacingField = new JTextField();
        pacingField.setPreferredSize(new Dimension(100, 25));
        pacingField.setMinimumSize(new Dimension(100, 25));
        pacingField.setMaximumSize(new Dimension(100, 25));
        pacingField.setEditable(false);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int vusers = Integer.parseInt(vusersField.getText());
                int tph = Integer.parseInt(tphField.getText());
                int duration = Integer.parseInt(durationField.getText());
                int baseline = Integer.parseInt(baselineField.getText());
                int thinkTime = Integer.parseInt(thinkTimeField.getText());

                double I = (double) tph / duration;
                double R = (double) ((baseline + thinkTime) * I);
                double pacing = vusers - R;

                pacingField.setText(String.valueOf(pacing));
            }
        });

        c.gridx = 0;
        c.gridy = 0;
        frame.add(vusersLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        frame.add(vusersField, c);

        c.gridx = 0;
        c.gridy = 1;
        frame.add(tphLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        frame.add(tphField, c);

        c.gridx = 0;
        c.gridy = 2;
        frame.add(durationLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        frame.add(durationField, c);

        c.gridx = 0;
        c.gridy = 3;
        frame.add(scriptExecutionTimeLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        frame.add(baselineField, c);

        c.gridx = 0;
        c.gridy = 4;
        frame.add(thinkTimeLabel, c);

        c.gridx = 1;
        c.gridy = 4;
        frame.add(thinkTimeField, c);

        c.gridx = 0;
        c.gridy = 5;
        frame.add(pacingLabel, c);

        c.gridx = 1;
        c.gridy = 5;
        frame.add(pacingField, c);

        c.gridx = 5;
        c.gridy = 0;
        frame.add(emptyLabel, c);

        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        frame.add(calculateButton, c);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WorkloadModelUI();
            }
        });
    }
}
