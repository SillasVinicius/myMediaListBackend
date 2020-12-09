package com.sd.myMediaList.Repositiories;

import com.sd.myMediaList.Models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorityRepositoryJPA extends JpaRepository<Authority, String> {

}
