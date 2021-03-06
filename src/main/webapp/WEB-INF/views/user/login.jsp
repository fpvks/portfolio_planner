<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style type="text/css">
	section {
		padding-left: 30%;
	}
	
	.login-form {
		width: 385px;
		margin: 30px auto;
	}
    .login-form form {        
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .login-btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .input-group-addon .fa {
        font-size: 18px;
    }
    .login-btn {
        font-size: 15px;
        font-weight: bold;
    }
	.social-btn .btn {
		border: none;
        margin: 10px 3px 0;
        opacity: 1;
	}
    .social-btn .btn:hover {
        opacity: 0.9;
    }
	.social-btn .btn-primary {
        background: #507cc0;
    }
	.social-btn .btn-info {
		background: #64ccf1;
	}
	.social-btn .btn-danger {
		background: #df4930;
	}
    .or-seperator {
        margin-top: 20px;
        text-align: center;
        border-top: 1px solid #ccc;
    }
    .or-seperator i {
        padding: 0 10px;
        background: #f7f7f7;
        position: relative;
        top: -11px;
        z-index: 1;
    }   
</style>

<section>
	<div id="login-box" class="col-md-6" >
		<form action="loginPost" method="post" id="LoginForm">
			<h2 class="text-center">환영합니다</h2>
			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span>
					<input type="text" class="form-control" name="id" placeholder="Username" required="required">
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span>
					<input type="password" class="form-control" name="pw" placeholder="Password" required="required">
				</div>
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary login-btn btn-block">Sign in</button>
			</div>
			
			<div class="clearfix">
				<label class="pull-left checkbox-inline"><input type="checkbox">아이디 기억하기</label>
				<a href="${pageContext.request.contextPath}/user/search" class="pull-right">아이디 / 비밀번호 찾기</a>
				<a href="${pageContext.request.contextPath}/user/register" class="pull-right">회원가입 &nbsp;</a>
			</div>
			
			<div class="or-seperator"><i>or</i></div>
			<p class="text-center">Login with your social media account</p>
			<div class="text-center social-btn">
				<a href="#" class="btn btn-primary"><i class="fa fa-facebook"></i>&nbsp; Facebook</a>
				<a href="#" class="btn btn-info"><i class="fa fa-twitter"></i>&nbsp; Twitter</a>
				<a href="#" class="btn btn-danger"><i class="fa fa-google"></i>&nbsp; Google</a>
			</div>
		</form>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>