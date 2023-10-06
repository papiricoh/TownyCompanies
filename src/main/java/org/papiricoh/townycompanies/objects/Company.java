package org.papiricoh.townycompanies.objects;

import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Company {
    private UUID uuid;
    protected Town town;
    protected String name;
    protected Resident owner;
    protected List<Resident> employees;
    protected double money;

    public Company(UUID uuid, Town town, String name, Resident owner, List<Resident> employees, double money) {
        this.uuid = uuid;
        this.town = town;
        this.name = name;
        this.owner = owner;
        this.employees = employees != null ? employees : new ArrayList<>();
        this.money = money;
    }

    public Company(Town town, String name, Resident owner, double money) {
        this.uuid = UUID.randomUUID();
        this.town = town;
        this.name = name;
        this.owner = owner;
        this.employees = new ArrayList<>();
        this.money = money;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Town getTown() {
        return town;
    }

    public String getName() {
        return name;
    }

    public Resident getOwner() {
        return owner;
    }

    public List<Resident> getEmployees() {
        return employees;
    }

    public void changeOwner(Resident new_leader) {
        this.owner = new_leader;
    }

    public void addEmployee(Resident employee) {
        if(!this.employees.contains(employee)) {
            this.employees.add(employee);
        }
    }

    public void removeEmployee(Resident employee) {
        this.employees.remove(employee);
    }

    public double getMoney() {
        return money;
    }

    public void deposit(double money) {
        this.money += money;
    }

    public double withdraw(double money) {
        if( 0 > this.money - money) {
            double old_money = this.money;
            this.money = 0;
            return old_money;
        }
        this.money -= money;
        return money;
    }
}
