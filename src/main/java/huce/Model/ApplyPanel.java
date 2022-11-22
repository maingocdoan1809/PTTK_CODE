/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Model;

import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ApplyPanel {
    // apply panel to parentJPanel
    public static void apply(JPanel parentJPanel, JPanel panel) {
        parentJPanel.removeAll();
        parentJPanel.revalidate();
        parentJPanel.repaint();
        parentJPanel.add(panel);
    }
}
