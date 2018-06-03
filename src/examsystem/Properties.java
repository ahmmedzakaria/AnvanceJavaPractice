/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsystem;

import java.awt.Color;

/**
 *
 * @author Zakakaria
 */
public class Properties {
    private int totalQuestions=11;
    private int answarOptions=5;
    private Color bgcColor=Color.BLUE;
    private Color btnColor=Color.CYAN;
    private Color txtAreaColor=Color.LIGHT_GRAY;

    public Color getTxtAreaColor() {
        return txtAreaColor;
    }

    public void setTxtAreaColor(Color txtAreaColor) {
        this.txtAreaColor = txtAreaColor;
    }

    public Color getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(Color btnColor) {
        this.btnColor = btnColor;
    }

    public Color getBgcColor() {
        return bgcColor;
    }

    public void setBgcColor(Color bgcColor) {
        this.bgcColor = bgcColor;
    }

    public int getAnswarOptions() {
        return answarOptions;
    }

    public void setAnswarOptions(int answarOptions) {
        this.answarOptions = answarOptions;
    }
    

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
    
    
}
