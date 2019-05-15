package com.company;

import com.company.common.FilterDescription;
import com.company.common.FilterOperator;
import com.company.models.CharityEntity;
import com.company.models.DonationEntity;
import com.company.models.DonorEntity;
import com.company.models.OrderEntity;
import com.company.services.*;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff Risberg
 * @since 11/3/17
 */
public class Main {
    public static void main(String[] args) {
        // Set up Guice
        Injector injector = Guice.createInjector(new MainModule());

        // Build through injectors
        HelloService helloService = injector.getInstance(HelloService.class);
        DonorService donorService = injector.getInstance(DonorService.class);
        //CharityService charityService = injector.getInstance(CharityService.class);
        //DonationService donationService = injector.getInstance(DonationService.class);
        //OrderService orderService = injector.getInstance(OrderService.class);

        helloService.handle();

        // Create two Donors
        DonorEntity a = donorService.create(new DonorEntity("Alice", 22)); // Alice will get an id 1
        DonorEntity b = donorService.create(new DonorEntity("Bob", 20)); // Bob will get an id 2
        DonorEntity c = donorService.create(new DonorEntity("Charlie", 45)); // Charlie will get an id 3

        // Update the age of Bob using the id
        b.setAge(25);
        donorService.update(b);

        // Delete Alice from database
        donorService.delete(a.getId());

        // Print all the Donors
        List<DonorEntity> donors = donorService.getAll(999, 0);
        for (DonorEntity donor : donors) {
            System.out.println(donor);
        }

        // Fetch donor by name
        DonorEntity donor = donorService.getByName("Bob");
        System.out.println(donor);

        // Fetch donors by criteria
        List<FilterDescription> dFilterDescs = new ArrayList<FilterDescription>();
        dFilterDescs.add(new FilterDescription("age", FilterOperator.gte, 35));
        List<DonorEntity> dListCriteria = donorService.getByCriteria(dFilterDescs, 0, 0);
        System.out.println(dListCriteria.get(0));

        // Delete Bob from the database
        donorService.delete(b.getId());

        // Delete Charlie from the database
        donorService.delete(c.getId());

 /*
        // Create two charities
        CharityEntity redCross = charityService.create(new CharityEntity("Red Cross", "53-0196605", ""));
        CharityEntity amCancer = charityService.create(new CharityEntity("American Cancer Society", "13-1788491", ""));

        // Fetch charities
        List<CharityEntity> charities = charityService.getAll(999, 0);
        for (CharityEntity charity : charities) {
            System.out.println(charity);
        }

        // Fetch charity by name
        CharityEntity charity = charityService.getByName("Red Cross");
        System.out.println(charity);

        // Fetch charities by criteria
        List<FilterDescription> cFilterDescs = new ArrayList<FilterDescription>();
        cFilterDescs.add(new FilterDescription("name", FilterOperator.like, "Red%"));
        List<CharityEntity> cListCriteria = charityService.getByCriteria(cFilterDescs, 0, 0);
        System.out.println(cListCriteria.get(0));

        // Delete two charities
        charityService.delete(redCross.getId());
        charityService.delete(amCancer.getId());

        // Create a charity
        CharityEntity charity1 = charityService.create(new CharityEntity("Red Cross", "53-0196605", ""));

        // Create a donor
        DonorEntity donor1 = donorService.create(new DonorEntity("Alice", 22));

        // Create a donation
        DonationEntity donation1 = new DonationEntity(45.67);
        donation1.setCharity(charity1);
        donation1.setCharityId(charity1.getId());
        donation1.setDonor(donor1);
        donation1.setDonorId(donor1.getId());

        donationService.create(donation1);

        // Fetch donations
        List<DonationEntity> donations1 = donationService.getAll(999, 0);
        for (DonationEntity donation : donations1) {
            System.out.println(donation);
        }

        // Delete a donation
        donationService.delete(donation1.getId());

        // Fetch donations
        List<DonationEntity> donations2 = donationService.getAll(999, 0);
        for (DonationEntity donation : donations2) {
            System.out.println(donation);
        }

        // Create an order
        OrderEntity order1 = new OrderEntity();
        order1.setDonor(donor1);
        order1.setDonorId(donor1.getId());

        List<DonationEntity> donations = new ArrayList<DonationEntity>();
        donations.add(donation1);
        order1.setContents(donations);

        //orderService.create(order1);

        //orderService.delete(order1.getId());

        donorService.delete(donor1.getId());
        charityService.delete(charity1.getId());

        orderService.close();
        charityService.close();
        donationService.close();
        */
        donorService.close();
    }
}