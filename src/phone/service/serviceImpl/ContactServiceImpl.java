package phone.service.serviceImpl;

import phone.dataBase.DataBase;
import phone.model.Contact;
import phone.model.Phone;
import phone.service.ContactService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ContactServiceImpl  implements ContactService {
    private DataBase dataBase = new DataBase();
    private PhoneServiceImpl phoneService = new PhoneServiceImpl();
    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
        for (Phone phone: dataBase.getPhones()) {
            phone = phoneService.getPhoneById(phoneId);
            phone.getContacts().add(contact);
        }
        /*for (Phone phone: dataBase.getPhones()) {
            if (phone.getId().equals(phoneId)){
                phone.getContacts().add(contact);
            }
        }*/
        return "Контакт успешно добавлен";
    }

    @Override
    public Contact findContactByName(int phoneId, String contactName) {
        Phone phone = phoneService.getPhoneById(phoneId);
        Optional<Contact> contact = phone.getContacts().stream()
                .filter(x -> x.getName().equalsIgnoreCase(contactName))
                .findFirst();
        return contact.orElse(null);
    }

    @Override
    public Contact findContactByPhoneNumber(int phoneId, String phoneNumber) {
        Phone phone = phoneService.getPhoneById(phoneId);
        Optional<Contact> contact = phone.getContacts().stream()
                .filter(x -> x.getPhoneNumber().equalsIgnoreCase(phoneNumber) && x.getPhoneNumber().contains(phoneNumber))
                .findFirst();
        return contact.orElse(null);
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) {
        Phone phone = phoneService.getPhoneById(phoneId);
        List<Contact> contacts = phone.getContacts().stream()
                .sorted(Comparator.comparing(Contact::getName))
                .toList();
        return contacts;
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {
        for (Phone phone: dataBase.getPhones()) {
            phone.getContacts().remove(findContactByName(phoneId, contactName));
        }
    }



}
