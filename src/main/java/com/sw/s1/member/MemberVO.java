package com.sw.s1.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {
	
	private String username;
		
	private String password1;
	
	//최소 4글자 이상
	@Length(max=12, min=6)
	private String password;
	
	@NotEmpty(message = "이름 쓰라고 했찌")	//name은 null이 아니어야 한다는 의미
	private String name;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String phone;
	
	//0이상 200이하
	@Range(min=0, max=200) //@Max(value=200) @Min(value=0)
	private Integer age;

	
}
