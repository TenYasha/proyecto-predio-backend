package com.proyectojwt.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	
	   private String authority;

	   public Authority(){}
	    public Authority(String authority) {
	        this.authority = authority;
	    }

	    @Override
	    public String getAuthority() {
	        return this.authority;
	    }

}
