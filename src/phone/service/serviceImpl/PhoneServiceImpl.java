package phone.service.serviceImpl;

import phone.dataBase.DataBase;
import phone.model.Phone;
import phone.service.PhoneService;

import java.util.List;
import java.util.Optional;

public class PhoneServiceImpl implements PhoneService {
    private DataBase dataBase = new DataBase();

    @Override
    public String addPhone(Phone phone) {
            dataBase.getPhones().add(phone);
        return "Телефон успешно добавлен";
    }

    @Override
    public Phone getPhoneById(int phoneId) {
        Optional<Phone> phone = dataBase.getPhones().stream()
                .filter(phones -> phones.getId() == phoneId)
                .findFirst();
        return phone.orElse(null);
    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        Phone phone = getPhoneById(phoneId);
        phone.setName(newName);
        return phone;
    }

    @Override
    public List<Phone> getAllPhones() {
        return dataBase.getPhones();
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        List<Phone> phones = dataBase.getPhones().stream()
                .filter(x -> x.getBrand().equalsIgnoreCase(brand))
                .toList();
        return phones;
    }

    @Override
    public void deletePhoneById(int phoneId) {
        dataBase.getPhones().remove(getPhoneById(phoneId));
    }
}
