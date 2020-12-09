package com.sd.myMediaList.Services;

import com.sd.myMediaList.Models.Authority;

import java.util.List;

public interface AuthorityServiceAPI {

    //public Authority get(String authorityname);

    public List<Authority> findAll();

    public Authority create(Authority authority);

    public void update(Authority authority);

    //public void remove(String authorityname);
}
