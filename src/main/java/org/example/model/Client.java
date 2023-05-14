package org.example.model;

/**
 * Clasa Client reprezinta o tabela din baza de date
 * Aceasta clasa are 2 constructori, settere, gettere si metoda toString() suprascrisa
 */
public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    public Client(int id, String firstName,String lastName, String address, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }
    public Client(String firstName,String lastName, String address, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "Client [id=" + id + ", first name=" + firstName + ", last name=" + lastName + ", address=" + address + ", email=" + email + "]";
    }

}