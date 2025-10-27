/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Academic;

/**
 *
 * @author krishi
 */

import java.util.ArrayList;

/**
 * Directory to manage all departments
 * @author Group
 */
public class DepartmentDirectory {
    private ArrayList<Department> departments;
    
    public DepartmentDirectory() {
        this.departments = new ArrayList<>();
        initializeDepartments();
    }
    
    private void initializeDepartments() {
        // Pre-populate with common departments
        departments.add(new Department("CS", "Computer Science"));
        departments.add(new Department("MATH", "Mathematics"));
        departments.add(new Department("BUS", "Business Administration"));
        departments.add(new Department("ENG", "Engineering"));
        departments.add(new Department("BIO", "Biology"));
    }
    
    public Department addDepartment(String id, String name) {
        Department dept = new Department(id, name);
        departments.add(dept);
        return dept;
    }
    
    public ArrayList<Department> getDepartments() {
        return departments;
    }
    
    public Department findDepartment(String departmentId) {
        for (Department dept : departments) {
            if (dept.getDepartmentId().equals(departmentId)) {
                return dept;
            }
        }
        return null;
    }
}
