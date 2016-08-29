package uz.bat.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uz.bat.model.entity.Address;
import uz.bat.model.entity.Street;
import uz.bat.model.repository.AddressRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-applicationContext.xml")
public class AddressRepositoryTest {
    @Test
    public void helloTest() {
        Address address=new Address();
        address.setAddress("rer");
        addressRepository.save(address);
    }

    @Test
    public void allAddress(){

        logger.info(addressRepository.findAll().size()+":");
    }
    @Autowired
    AddressRepository addressRepository;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
}

