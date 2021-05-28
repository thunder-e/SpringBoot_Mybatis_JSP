<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- jsp page 선언부에 spring message를 사용할 수 있도록 선언 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- Spring Form tag를 사용할 수 있도록 선언 -->  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <title>Hello, world!</title>
    <style type="text/css">
    	.c1 {
    		color: red;
    	}
    </style>
  </head>
  <body>
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
	    <a class="navbar-brand" href="#">Hidden brand</a>
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/member/join">Join</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
	      </li>
	    </ul>
	    <form class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	    </form>
	  </div>
	</nav>
	 
	<div class="jumbotron jumbotron-fluid mt-3">
	  <div class="container">
	    <h1 class="display-4">Fluid jumbotron</h1>
	    <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
	  </div>
	</div>
	
	
	<div class="container mt-2">
		
		<br>
		<h2 class="mt-4">Member Join Page</h2>
		
		<!-- form태그는 name대신 path로 값을 보냄 -->
		<form:form modelAttribute="memberVO" id="frm" action="./join" method="post">
			<!-- ID -->
			<div class="form-group">
				<label for="username">ID</label> <!-- path에 memberVO에 없는 것을 넣으면 오류남 -->
				<form:input class="form-control" id="username" path="username"
				aria-describedby="idHelp" />
				<h4 id=idResult></h4>
				<h4 id=idCheckResult></h4>
				<!-- ID 는 6글자 이상 -->
			</div>
			
			<!-- Password -->
<%-- 			<div class="form-group">
				<label for="password">Password</label> 
				<form:password class="form-control" id="password" path="password" />
				<h4 id="pwResult"></h4>
				<!-- PW는 8글자 이상 -->
			</div> --%>
			
			<!-- Password 확인 -->
			<div class="form-group">
				<label for="pw">Confirm Password</label> 
				<form:password class="form-control pw2Result" id="pw2" path="password" />
				<form:errors path="password" class="form-control is-invalid"></form:errors>
				<!-- 2번째 비밀번호를 입력했을 때, 같으면 아무일 X, 다르면 값을 지우기 -->
				<!-- PW 두개는 일치 -->	
			</div>	
			
			
			<!-- Name -->
			<div class="form-group">
				<label for="name">NAME</label> 
				<form:input class="form-control" id="name" path="name" />
				<form:errors path="name" cssClass="c1"></form:errors>
				<!-- 비어 있으면 X -->
			</div>
			
			
			<!-- Phone -->
			<div class="form-group">
				<label for="phone">PHONE</label> 
				<form:input class="form-control" id="phone" path="phone" />
				<form:errors path="phone"></form:errors>
				<!-- 비어 있으면 X -->
			</div>
			
			
			<!-- Email -->
			<div class="form-group">
				<label for="email">EMAIL</label> 
				<form:input class="form-control" id="email" path="email" />
				<form:errors path="email"></form:errors>
				<!-- 비어 있으면 X -->
			</div>
			
			<!-- Email -->
			<div class="form-group">
				<label for="age">Age</label> 
				<form:input class="form-control" id="age" path="age" />
				<form:errors path="age"></form:errors>
				<!-- 비어 있으면 X -->
			</div>
			
			
			<!-- 이 버튼은 submit이벤트가 내장되어있어 값을 비교하고 보내는것이 아닌 그냥 보내므로 null값이여도 보내서 exception발생시킴 -->
			<!-- <button type="submit" class="btn btn-primary" id="check">Submit</button> -->
						
			<!-- input type으로 만든 버튼은 form 내부/외부 둘 다 작동안함 -->
			<!-- <input type="button" value="JOIN" class="btn btn-primary">  -->
			
			<input type="submit" value="JOIN" id="btn" class="btn btn-primary">
			<!-- button -->
		</form:form>
		
	</div>
   
   
	<footer class="footer mt-auto py-3 bg-dark">
	  <div class="container">
	    <span class="text-muted">Place sticky footer content here.</span>
	  </div>
	</footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

  </body>
</html>