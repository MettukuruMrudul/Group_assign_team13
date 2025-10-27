/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Finance;
import business.Profiles.StudentProfile;
/**
 *
 * @author DELL
 */
public class TuitionPayment {
    private static int paymentIdCounter = 7000;
    
    private String paymentId;
    private StudentProfile student;
    private String semester;
    private double tuitionAmount;
    private double paidAmount;
    private String paymentStatus; // PAID, PARTIAL, UNPAID
    private String paymentDate;
    private String department;
    
    public TuitionPayment(StudentProfile student, String semester, double tuitionAmount, String department) {
        this.paymentId = "PAY" + (paymentIdCounter++);
        this.student = student;
        this.semester = semester;
        this.tuitionAmount = tuitionAmount;
        this.paidAmount = 0.0;
        this.paymentStatus = "UNPAID";
        this.department = department;
    }
    
    public String getPaymentId() {
        return paymentId;
    }
    
    public StudentProfile getStudent() {
        return student;
    }
    
    public void setStudent(StudentProfile student) {
        this.student = student;
    }
    
    public String getSemester() {
        return semester;
    }
    
    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public double getTuitionAmount() {
        return tuitionAmount;
    }
    
    public void setTuitionAmount(double tuitionAmount) {
        this.tuitionAmount = tuitionAmount;
    }
    
    public double getPaidAmount() {
        return paidAmount;
    }
    
    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
        updatePaymentStatus();
    }
    
    public void addPayment(double amount) {
        this.paidAmount += amount;
        if (this.paidAmount > this.tuitionAmount) {
            this.paidAmount = this.tuitionAmount;
        }
        updatePaymentStatus();
        if (paymentStatus.equals("PAID")) {
            this.paymentDate = java.time.LocalDate.now().toString();
        }
    }
    
    private void updatePaymentStatus() {
        if (paidAmount >= tuitionAmount) {
            paymentStatus = "PAID";
        } else if (paidAmount > 0) {
            paymentStatus = "PARTIAL";
        } else {
            paymentStatus = "UNPAID";
        }
    }
    
    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    public String getPaymentDate() {
        return paymentDate;
    }
    
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    public double getBalanceDue() {
        return tuitionAmount - paidAmount;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
}