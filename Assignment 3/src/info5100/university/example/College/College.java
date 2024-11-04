/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.College;

import info5100.university.example.Department.Department;
import info5100.university.example.Department.DepartmentAccount;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class College {
    String name;
    ArrayList<Department> departments;
    ArrayList<DepartmentAccount> departmentAccounts;
    
    public College(String name){
        this.name = name;
        departments = new ArrayList<>();
        departmentAccounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<DepartmentAccount> getDepartmentAccounts() {
        return departmentAccounts;
    }

    public void addDepartment(Department d){
        departments.add(d);
    }

    public void addDepartmentAccount(DepartmentAccount da){
        departmentAccounts.add(da);
    }
}
