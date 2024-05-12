package com.descomplica.FrameBlog.services.impl.v2;

import com.descomplica.FrameBlog.models.v2.AddressV2;
import com.descomplica.FrameBlog.models.v2.UserV2;
import com.descomplica.FrameBlog.repositories.v2.AddressRepositoryV2;
import com.descomplica.FrameBlog.repositories.v2.UserRepositoryV2;
import com.descomplica.FrameBlog.services.v2.AddressServiceV2;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AddressServiceV2Impl implements AddressServiceV2 {
    @Autowired
    private AddressRepositoryV2 addressRepositoryV2;

    @Autowired
    private UserRepositoryV2 userRepositoryV2;

    @Override
    public AddressV2 save(final AddressV2 address) {

        UserV2 userV2 = userRepositoryV2.findById(address.getUser().getUserId()).orElseThrow(() -> new EntityNotFoundException("User found"));
        address.setUser(userV2);

        return addressRepositoryV2.save(address);
    }

    @Override
    public List<AddressV2> getAll(){
        return addressRepositoryV2.findAll();
    }

    @Override
    public AddressV2 get(final Long id){
        return addressRepositoryV2.findById(id).orElseThrow(() -> new EntityNotFoundException("Address not found"));
    }

    @Override
    public AddressV2 update(final Long id, final AddressV2 address){
        AddressV2 addressUpdate = addressRepositoryV2.findById(id).orElseThrow(() -> new EntityNotFoundException("Address not found"));

        UserV2 userV2 = userRepositoryV2.findById(addressUpdate.getUser().getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found"));

        if(Objects.nonNull(addressUpdate)){
            addressUpdate.setStreet(address.getStreet());
            addressUpdate.setCity(address.getCity());
            addressUpdate.setState(address.getState());
            addressUpdate.setZipCode(address.getZipCode());
            addressUpdate.setCountry(address.getCountry());
            addressUpdate.setUser(userV2);
            return addressRepositoryV2.save(addressUpdate);
        }
        return null;
    }

    @Override
    public void delete(final Long id){
        addressRepositoryV2.findById(id).orElseThrow(() -> new EntityNotFoundException("Address not found"));
        addressRepositoryV2.deleteById(id);
    }
}
