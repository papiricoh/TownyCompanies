package org.papiricoh.townycompanies.objects;

import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;
import org.papiricoh.townycompanies.TownyCompanies;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Company {
    private UUID uuid;
    private Town town;
    private String name;
    private Resident owner;
    private List<Resident> employees;
    private double money;
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

    private void deposit(double money) {
        this.money += money;
    }

    private double withdraw(double money) {
        if( 0 > this.money - money) {
            double old_money = this.money;
            this.money = 0;
            return old_money;
        }
        this.money -= money;
        return money;
    }

    public void withdraw(OfflinePlayer player, double money) {
        TownyCompanies.econ.depositPlayer(player, withdraw(money));
    }
    public void deposit(OfflinePlayer player, double money) {
        if(TownyCompanies.econ.getBalance(player) - money >= 0) {
            TownyCompanies.econ.withdrawPlayer(player, money);
            deposit(money);
        }
    }
}
