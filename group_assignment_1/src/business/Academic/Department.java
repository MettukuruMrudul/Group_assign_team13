/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Academic;

/**
 *
 * @author DELL
 */

public class Department {
    private String departmentId;
    private String departmentName;
    private String chairperson;
    
    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    
    public String getDepartmentId() {
        return departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public String getChairperson() {
        return chairperson;
    }
    
    public void setChairperson(String chairperson) {
        this.chairperson = chairperson;
    }
    
    @Override
    public String toString() {
        return departmentName;
    }
}