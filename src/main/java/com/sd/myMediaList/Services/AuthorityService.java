package com.sd.myMediaList.Services;

import com.sd.myMediaList.Models.Authority;
import com.sd.myMediaList.Repositiories.AuthorityRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorityService implements AuthorityServiceAPI {

    @Autowired
    private AuthorityRepositoryJPA repositoryJPA;

//    @Transactional(readOnly = true)
//    public Authority get(String authorityname){
//
//        try {
//            //Authority authority = repositoryJPA.findOne(authorityname).get();
//            return authority;
//        } catch (Exception ex) {
//            throw new AuthorityNotFoundException(String.format("Authority não existe com esse id: %s ", id));
//        }
//    }

    @Override
    @Transactional(readOnly = true)
    public List<Authority> findAll() {

        return repositoryJPA.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Authority create(Authority authority) {

        return authority;
        //return repositoryJPA.save(authority);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Authority authority) {
        //repositoryJPA.save(authority);
    }

//    @Override
//    @Transactional(readOnly = false)
//    public void remove(Long id) {
//        repositoryJPA.deleteById(id);
//    }

}
