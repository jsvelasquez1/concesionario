package com.espe.concesionario.services;

import com.espe.concesionario.models.Users;
import com.espe.concesionario.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> usersList() {
        return usersRepository.findAll();
    }
}
