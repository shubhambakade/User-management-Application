package com.BikkadIT.UserManagementApplication.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.BikkadIT.UserManagementApplication.bindings.LoginForm;
import com.BikkadIT.UserManagementApplication.bindings.UnlockAccForm;
import com.BikkadIT.UserManagementApplication.bindings.UserForm;
import com.BikkadIT.UserManagementApplication.entities.CityMasterEntity;
import com.BikkadIT.UserManagementApplication.entities.CountryMasterEntity;
import com.BikkadIT.UserManagementApplication.entities.StateMasterEntity;
import com.BikkadIT.UserManagementApplication.entities.UserMasterEntiry;
import com.BikkadIT.UserManagementApplication.repository.CityRepo;
import com.BikkadIT.UserManagementApplication.repository.CountryRepo;
import com.BikkadIT.UserManagementApplication.repository.StateRepo;
import com.BikkadIT.UserManagementApplication.repository.UserRepo;
import com.BikkadIT.UserManagementApplication.util.EmailUtils;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserServiceI {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CityRepo cityRepo;
    @Autowired
	private CountryRepo countryRepo;
	@Autowired
	private StateRepo stateRepo;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String logincheck(LoginForm loginForm) {
          
		  UserMasterEntiry userAcc =userRepo.findByMailAndPassword(loginForm.getEmail(),loginForm.getPassword());
		      if (userAcc !=null) {
				   String status = userAcc.getAccountStatus();
				   
				   if (status.equals("LOCK")) {
					   return "Your Account is lock";
				} else {
                       return "Login Success";
				}
			 }else {
				  return "Invalid Credintionals";
			}
		 }

	@Override
	public Map<Integer, String> getContries() {
       List<CountryMasterEntity> findAll= countryRepo.findAll();
       Map<Integer, String> countriesmap =new  HashMap<>();
       
        findAll.forEach(country->{
        	countriesmap.put(country.getCountryId(),country.getCountryName());
        });
		return countriesmap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
         List<StateMasterEntity> findByCountryId= stateRepo.findByCountryId(countryId);
         Map<Integer, String> stateamap=new HashMap<>();
         
         findByCountryId.forEach(state->{
        	 stateamap.put(state.getStateId(),state.getStateName());
         });
		return stateamap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
         List<CityMasterEntity> findByStateId= cityRepo.findByStateId(stateId);
         Map<Integer, String> citymap=new HashMap<>();
         
         findByStateId.forEach(city->{
        	 
        	 citymap.put(city.getCityId(),city.getCityName());
         });
		return citymap;
	}

	@Override
	public boolean emailUnique(String mail) {
         UserMasterEntiry findByMail=userRepo.findByMail(mail);
           if (findByMail == null) {
			    return false;
		}
		return true;
	}

	@Override
	public boolean saveUser(UserForm userForm) {
		
          userForm.setAccountStatus("LOCK");
          
		userForm.setPassword(generaterandomPassword());
          
          UserMasterEntiry userMasterEntiry = new UserMasterEntiry();
          
          BeanUtils.copyProperties(userForm, userMasterEntiry);
          
          UserMasterEntiry save=userRepo.save(userMasterEntiry);
              if (save != null) {
				 return true;
			}
		return false;
	}
	
	private String generaterandomPassword() {
		String randomAlphanumeric =RandomStringUtils.randomAlphanumeric(6);
		return randomAlphanumeric;
		
		
	}

	@Override
	public boolean unlockAccount(UnlockAccForm unlockAccForm) {
         String email = unlockAccForm.getEmail();
         String temPassword = unlockAccForm.getTemPassword();
         
         UserMasterEntiry userMasterEntiry = userRepo.findByMailAndPassword(email, temPassword);
           if (userMasterEntiry !=null) {
			userMasterEntiry.setAccountStatus(temPassword);
			userMasterEntiry.setPassword(unlockAccForm.getNewPassword());
			userRepo.save(userMasterEntiry);
			return true;
		}
		return false;
	}

	@Override
	public String forgotPassword(String email) {
         UserMasterEntiry user = userRepo.findByMail(email);
         
         //String body =getUForgotPwdMail(user);
         //String sub ="password sent to your registered mail";
           if (user !=null) {
        	   
//        	   try {
//				emailUtils.sendmail(user.getMail(), sub, body);
//			} catch (MessagingException e) {
//				  e.printStackTrace();
//			}
        	   return "SUCCESS";
		}
		return "FAIL";
	}
	
	private String getUserEmailBody(UserForm userForm) {
		StringBuffer sb = new StringBuffer();
		
		String fileName = "UNLOCK-ACC-EMAIL-BODY-TEMPLETE.txt";
		
		List<String> lines = new ArrayList<>();
		
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
			
			lines = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
           e.printStackTrace();
		}
		lines.forEach(line ->{
			if (line.contains("{FirstName}")) {
				line.replace("{FirstName}",userForm.getFirstName());
			}
			
			if (line.contains("{lastName}")) {
				line.replace("{lastName}", userForm.getLastName());
			}
			
			if (line.contains("{temPassword}")) {
			    line.replace("{temPassword}", userForm.getPassword());	
			}
			
			if (line.contains("{mail}")) {
				line.replace("{mail}", userForm.getMail());
			}
			sb.append(line);
		});
		return sb.toString();
	}
	
	private String getUForgotPwdMail(UserMasterEntiry userMasterEntiry) {
		 
		StringBuffer sb = new StringBuffer();
		
		String fileName = "RECOVER-PASS-EMAIL-BODY-TEMPLETE.txt";
		
		List<String> lines = new ArrayList<>();
		
		try {
			BufferedReader br =Files.newBufferedReader(Paths.get(fileName));
			
			lines = br.lines().collect(Collectors.toList());
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		lines.forEach(line ->{
			
			if (line.contains("{FirstName}")) {
				
				line.replace("{FirstName}", userMasterEntiry.getFirstName());
			}
			
			if (line.contains("{lastName}")) {
				
				line.replace("{lastName}", userMasterEntiry.getLastName());
			}
			
			if (line.contains("{password}")) {
				
				line.replace("{password}", userMasterEntiry.getPassword());
			}
			
			  sb.append(line);
		});
		
		return sb.toString() ;
		
	}
}
