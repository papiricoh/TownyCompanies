package org.papiricoh.townycompanies.objects;

import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Company {
    private UUID uuid;
    private Town town;
    private String name;
    private Resident owner;
    private List<Resident> employees;

    public Company(UUID uuid, Town town, String name, Resident owner, List<Resident> employees) {
        this.uuid = uuid;
        this.town = town;
        this.name = name;
        this.owner = owner;
        this.employees = employees != null ? employees : new ArrayList<>();
    }

    public Company(Town town, String name, Resident owner) {
        this.uuid = UUID.randomUUID();
        this.town = town;
        this.name = name;
        this.owner = owner;
        this.employees = new ArrayList<>();
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
}
