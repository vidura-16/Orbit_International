package com.example.international;




public class EmployeeSal {

    int ID;
    private String name;
    private int  basicSalary;
    private int  OT;
    private int  allowance;
    private int  bonus;
    private int  deduction;
    private String reason;
    private int  total;


    public EmployeeSal(int empID, String name, int basicSalary, int OT, int allowance, int bonus, int deduction, String reason, int total) {
        this.ID = empID;
        this.name = name;
        this.basicSalary = basicSalary;
        this.OT = OT;
        this.allowance = allowance;
        this.bonus = bonus;
        this.deduction = deduction;
        this.reason = reason;
        this.total = total;
    }

    public int getID(){return ID;}
    public void setId(int newID){ID=newID;}


    public String getName(){return name;}
    public void setName(String newName){name=newName;}


    public int getBasicSalary() {
        return basicSalary;}
    public void setBasicSalary(int newBasicsalary){basicSalary=newBasicsalary;}


    public int getOT() {return OT;}
    public void setOT(int newOT){OT=newOT;}


    public int getAllowance() {return allowance;}
    public void setAllowance(int newAllowance){allowance=newAllowance;}


    public int getBonus(){return bonus;}
    public void setBonus(int newBonus){bonus=newBonus;}


    public int getDeduction(){return deduction;}
    public void setDeduction(int newDeduction){deduction=newDeduction;}


    public String getReason(){return reason;}
    public void setReason(String newID){reason=newID;}


    public int getTotal(){return total;}
    public void setTotal(int newTotal){total=newTotal;}

}




