/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Finance;
import business.Profiles.StudentProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author DELL
 */
public class TuitionPaymentDirectory {
    private ArrayList<TuitionPayment> payments;
    
    public TuitionPaymentDirectory() {
        this.payments = new ArrayList<>();
    }
    
    public TuitionPayment createPaymentRecord(StudentProfile student, String semester, double amount, String department) {
        TuitionPayment payment = new TuitionPayment(student, semester, amount, department);
        payments.add(payment);
        return payment;
    }
    
    public ArrayList<TuitionPayment> getPayments() {
        return payments;
    }
    
    public TuitionPayment findPayment(String paymentId) {
        for (TuitionPayment payment : payments) {
            if (payment.getPaymentId().equals(paymentId)) {
                return payment;
            }
        }
        return null;
    }
    
    public ArrayList<TuitionPayment> getPaymentsByStudent(StudentProfile student) {
        ArrayList<TuitionPayment> studentPayments = new ArrayList<>();
        for (TuitionPayment payment : payments) {
            if (payment.getStudent().equals(student)) {
                studentPayments.add(payment);
            }
        }
        return studentPayments;
    }
    
    public ArrayList<TuitionPayment> getPaymentsBySemester(String semester) {
        ArrayList<TuitionPayment> semesterPayments = new ArrayList<>();
        for (TuitionPayment payment : payments) {
            if (payment.getSemester().equals(semester)) {
                semesterPayments.add(payment);
            }
        }
        return semesterPayments;
    }
    
    public ArrayList<TuitionPayment> getUnpaidPayments() {
        ArrayList<TuitionPayment> unpaidPayments = new ArrayList<>();
        for (TuitionPayment payment : payments) {
            if (!payment.getPaymentStatus().equals("PAID")) {
                unpaidPayments.add(payment);
            }
        }
        return unpaidPayments;
    }
    
    // Financial Report Methods
    public double getTotalCollectedForSemester(String semester) {
        double total = 0;
        for (TuitionPayment payment : getPaymentsBySemester(semester)) {
            total += payment.getPaidAmount();
        }
        return total;
    }
    
    public double getTotalUnpaidForSemester(String semester) {
        double total = 0;
        for (TuitionPayment payment : getPaymentsBySemester(semester)) {
            total += payment.getBalanceDue();
        }
        return total;
    }
    
    public Map<String, Double> getRevenueByDepartment(String semester) {
        Map<String, Double> revenueMap = new HashMap<>();
        for (TuitionPayment payment : getPaymentsBySemester(semester)) {
            String dept = payment.getDepartment();
            double revenue = payment.getPaidAmount();
            revenueMap.put(dept, revenueMap.getOrDefault(dept, 0.0) + revenue);
        }
        return revenueMap;
    }
}