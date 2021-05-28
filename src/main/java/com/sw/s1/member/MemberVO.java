package com.sw.s1.member;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
//import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails {
	
	private String username;
	
	//최소 4글자 이상
	@Length(min = 6, max = 12)
	private String password;
	
	private String password1;
	
	@NotEmpty(message = "넌 이름이 없니??") //name은 null이 아니여야 한다는 의미
	private String name;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String phone;
	
	//0 이상 200이하
	@Max(value = 200)
	@Min(value = 0)
	private Integer age;
	
	//Security 
	private boolean enabled;
	
	//Role
	private List<RoleVO> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(RoleVO roleVO:this.roles) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
