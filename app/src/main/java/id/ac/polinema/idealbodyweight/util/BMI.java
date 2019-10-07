package id.ac.polinema.idealbodyweight.util;

public class BMI {
    private float berat;
    private float tinggi;
    private float BMI;

    public  BMI(float berat, float tinggi) {
        this.berat = berat;
        this.tinggi = tinggi;
        this.calculate();
    }
    public  String BMIRange() {
        String res = "";
        if (this.BMI < 18.50) {
            res = "Underweight";
        } else if (this.BMI >= 18.50 && this.BMI <= 24.99) {
            res = "Healthy Weight";
        } else if (this.BMI > 25) {
            res = "Overweight";
        }
        return res;
    }
    public void calculate() { this.BMI = this.berat / (this.tinggi * this.tinggi); }
}
