/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWprocess.service;

import int202.SWprocess.repository.SellerRepository;
import int202.SWprocess.repository.UsersRepository;
import int202.SWprocess.repository.CustomersRepository;
import int202.SWprocess.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kittisak
 */
@Service
public class UserService {
    
    @Autowired
    private UsersRepository userRepo;
    
    @Autowired
    private SellerRepository sellerRepo;
    
    @Autowired
    private CustomersRepository customerRepo;
    
    @Autowired
    private AdminRepository adminRepo;
}