package com.example.mobilele;

import com.example.mobilele.model.entity.Brand;
import com.example.mobilele.model.entity.Model;
import com.example.mobilele.model.entity.User;
import com.example.mobilele.model.entity.EngineEnum;
import com.example.mobilele.model.entity.ModelCategory;
import com.example.mobilele.model.entity.TransmissionEnum;
import com.example.mobilele.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DbInit implements CommandLineRunner {

    private final ModelService modelService;
    private final BrandService brandService;
    private final OfferService offerService;
    private final UserService userService;
    private final UserRoleService userRoleService;



    public DbInit(ModelService modelService, BrandService brandService,
                  OfferService offerService, UserService userService,
                  UserRoleService userRoleService) {
        this.modelService = modelService;
        this.brandService = brandService;
        this.offerService = offerService;
        this.userService = userService;
        this.userRoleService = userRoleService;
    }


    @Override
    public void run(String... args) throws Exception {
        //create brands
        this.brandService.createNewBrand("Fiat");
        this.brandService.createNewBrand("Peugeot");
        this.brandService.createNewBrand("Mz");
        Brand fiat = this.brandService.findFirstByName("Fiat");
        Brand peugeot = this.brandService.findFirstByName("Peugeot");
        Brand mz = this.brandService.findFirstByName("Mz");

        //create models
        this.modelService.createNewModel(fiat, "Punio", Instant.now(), Instant.now(), ModelCategory.CAR, 1980, null,
                "http://bay2car.com/img/2001-FIAT-PUNTO-1-2-BLUE-nice-little-car-1-day-auction-cheap-car-79-000MILES-281906773530/0.jpg");
        this.modelService.createNewModel(fiat, "Bravo", Instant.now(), Instant.now(), ModelCategory.CAR, 1995, 2021,
                "https://pictures.topspeed.com/IMG/crop_webp/200801/2008-fiat-bravo-1-6-multi-2_1600x0.webp");
        this.modelService.createNewModel(peugeot, "306", Instant.now(),
                Instant.now(), ModelCategory.CAR, 1961, 2019,
                "https://i.ytimg.com/vi/Z0OJ0B5j4Wc/maxresdefault.jpg");
        this.modelService.createNewModel(peugeot, "308", Instant.now(),
                Instant.now(), ModelCategory.CAR, 2007, null,
                "https://s.car.info/image_files/960/peugeot-308-5-door-back-side-2-263733.jpg");
        this.modelService.createNewModel(mz, "125", Instant.now(), Instant.now(), ModelCategory.MOTORCYCLE, 1995, 2021,
                "https://mobistatic1.focus.bg/mobile/photosorg/764/5/big/51594705913184764_kO.jpg");

        Model byIdOne = this.modelService.findFirstById(1L);

        //create offer
        this.offerService.createOfferManual(byIdOne, "http://bay2car.com/img/2001-FIAT-PUNTO-1-2-BLUE-nice-little-car-1-day-auction-cheap-car-79-000MILES-281906773530/0.jpg", EngineEnum.DIESEL,
                4000, 8000.00, TransmissionEnum.AUTOMATIC, 2008, "Some description here. Lorem epsum blab la bla");

        //create users_roles db
        this.userRoleService.initializeUserRoles("user");
        this.userRoleService.initializeUserRoles("admin");
      //  UserRole userRole = this.userRoleService.findFirstByRole(Role.USER);
       // UserRole adminRole = this.userRoleService.findFirstByRole(Role.ADMIN);


        //create user - admin with user and admin roles
        User createUserAdmin = this.userService
                .createAdmin("Pesho", "P", "admin", "topsecret");


        //create user - only user role
        User createUser = this.userService
                .createUserWithUserRole("Toshko", "Big", "user1", "user1");

    }
}
