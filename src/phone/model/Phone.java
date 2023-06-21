package phone.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Phone (id, name, brand, contacts(List)) полелери болуш керек.
public class Phone {
    private static Long counter=1l;
    private Long id;
    private String name;
    private String brand;
    private List<Contact> contacts = new ArrayList<>();

    public Phone(String name, String brand) {
        this.id=counter++;
        this.name = name;
        this.brand = brand;
    }

    public Phone(String name, String brand, List<Contact> contacts) {
        this.name = name;
        this.brand = brand;
        this.contacts = contacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }


    @Override
    public String toString() {
        return "\nPhone " +
                "\nid=" + id +
                "\nname='" + name +
                "\nbrand='" + brand +
                "\ncontacts=" + contacts;
    }
}
