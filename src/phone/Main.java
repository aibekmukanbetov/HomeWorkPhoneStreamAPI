package phone;

import phone.model.Contact;
import phone.model.Phone;
import phone.service.serviceImpl.ContactServiceImpl;
import phone.service.serviceImpl.PhoneServiceImpl;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneServiceImpl phoneService = new PhoneServiceImpl();
        ContactServiceImpl contactService = new ContactServiceImpl();
        String formattedTime = ZonedDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        int num;
        do {
            System.out.println("================="+formattedTime+"=================");
            System.out.println("1. Add phone");
            System.out.println("2. Get phone by id");
            System.out.println("3. Update phone name");
            System.out.println("4. Get all phones");
            System.out.println("5. Get all phone by brand");
            System.out.println("6. Delete phone by id");
            System.out.println("7. Add contact to phone");
            System.out.println("8. Get contact by name");
            System.out.println("9. Get contact by phone number");
            System.out.println("10. Sort contact by name");
            System.out.println("11. Delete contact by name from phone");
            System.out.println("12. EXIT");
            System.out.println("===================================================");

            System.out.println("Выберите режим");
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            switch (num){
                case 1:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Введите название телефона: ");
                    String namePhone = scanner1.nextLine();
                    System.out.println("Введите бренд телефона: ");
                    String brand = scanner1.nextLine();
                    Phone phone = new Phone(namePhone, brand);
                    System.out.println(phoneService.addPhone(phone));
                    break;
                case 2:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Введите id телефона которую котите найти: ");
                    int id = scanner2.nextInt();
                    System.out.println(phoneService.getPhoneById(id));
                    break;
                case 3:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Введите id телефона которую хотите изменить: ");
                    int pId = scanner3.nextInt();
                    System.out.println("Введите новое название телефона");
                    Scanner scanner4 = new Scanner(System.in);
                    String newName = scanner4.nextLine();
                    System.out.println(phoneService.updatePhoneNameById(pId, newName));
                    break;
                case 4:
                    System.out.println(phoneService.getAllPhones());
                    break;
                case 5:
                    Scanner scanner13 = new Scanner(System.in);
                    System.out.println("Введите бренд телефона которую хотите найти: ");
                    String brandPhone = scanner13.nextLine();
                    System.out.println(phoneService.getAllPhonesByBrand(brandPhone));
                    break;
                case 6:
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.println("Введите id телефона которую хотите удалить: ");
                    int idP = scanner5.nextInt();
                    phoneService.deletePhoneById(idP);
                    break;
                case 7:
                    Scanner scanner6 = new Scanner(System.in);
                    System.out.println("Введите id телефона куда хотите добавить контакт");
                    int idPhone = scanner6.nextInt();
                    Scanner scanner7 = new Scanner(System.in);
                    System.out.println("Введите имя контакта: ");
                    String nameCon = scanner7.nextLine();
                    System.out.println("Введите номер телефона");
                    String contact = scanner7.nextLine();
                    System.out.println(contactService.addContactToPhone(idPhone, new Contact(nameCon, contact)));
                    break;
                case 8:
                    Scanner scanner8 = new Scanner(System.in);
                    System.out.println("Введите id телефона: ");
                    int PhoneId = scanner8.nextInt();
                    System.out.println("Введите имя контакта: ");
                    Scanner scanner12 =new Scanner(System.in);
                    String nameContact = scanner12.nextLine();
                    System.out.println(contactService.findContactByName(PhoneId, nameContact));
                    break;
                case 9:
                    Scanner scanner9 = new Scanner(System.in);
                    System.out.println("Введите id телефона: ");
                    int idPh = scanner9.nextInt();
                    System.out.println("Введите номер телефона которую хотите найти: ");
                    Scanner scanner14 = new Scanner(System.in);
                    String phoneNumber = scanner14.nextLine();
                    System.out.println(contactService.findContactByPhoneNumber(idPh, phoneNumber));
                    break;
                case 10:
                    Scanner scanner10 = new Scanner(System.in);
                    System.out.println("Введите id телефона: ");
                    int PhId = scanner10.nextInt();
                    System.out.println(contactService.sortContactsByName(PhId));
                    break;
                case 11:
                    Scanner scanner11 = new Scanner(System.in);
                    System.out.println("Введите id телефона");
                    int phoneId = scanner11.nextInt();
                    System.out.println("Введите имя контакта: ");
                    Scanner scanner15 = new Scanner(System.in);
                    String name = scanner15.nextLine();
                    contactService.deleteContactByNameFromPhone(phoneId, name);
                    break;
                case 12:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("Не правильно выбран режим, пожалуйста попробуйте еще раз ");
            }
        } while (num!=12);
    }
}
