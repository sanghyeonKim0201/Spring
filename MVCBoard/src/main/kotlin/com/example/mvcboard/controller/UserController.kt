package com.example.mvcboard.controller

import com.example.mvcboard.dto.UserDTO
import com.example.mvcboard.service.UserService
import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Tag(name = "UserController", description = "로그인, 회원가입 등")
@RestController
class UserController(private val userService: UserService) {

    val logger = LoggerFactory.getLogger(UserController::class.java)


    @Hidden
    @GetMapping("/login")
    fun loginView() : ModelAndView{
        return ModelAndView("login/login")
    }

    @Operation(summary = "로그인 API", description = "로그인을 시도하는 API")
    @Parameter(name = "id", description = "ID 텍스트박스 이름 ex) <input type=\"text\" name=\"id\">")
    @Parameter(name = "PW", description = "PW 텍스트박스 이름 ex) <input type=\"text\" name=\"pw\">")
    @PostMapping("/login")
    fun login(@ModelAttribute userDTO: UserDTO): ModelAndView{
        var u = userService.login(userDTO)

        if(u == null){
            return ModelAndView("login/login")
        }
        logger.info("${u.no} 로그인")
        return ModelAndView("board/list")
    }

    @Hidden
    @GetMapping("/signup")
    fun signUpView(): ModelAndView {
        return ModelAndView("signup/signup")
    }

    @Operation(summary = "회원가입 API", description = "회원가입을 시도하는 API")
    @Parameter(name = "id", description = "ID 텍스트박스 이름 ex) <input type=\"text\" name=\"id\">")
    @Parameter(name = "PW", description = "PW 텍스트박스 이름 ex) <input type=\"text\" name=\"pw\">")
    @Parameter(name = "name", description = "name 텍스트박스 이름 ex) <input type=\"text\" name=\"name\">")
    @Parameter(name = "phone", description = "phone 텍스트박스 이름 ex) <input type=\"text\" name=\"phone\">")
    @Parameter(name = "birth", description = "birth 텍스트박스 이름 ex) <input type=\"text\" name=\"birth\">")
    @PostMapping("/signup")
    fun signup(@ModelAttribute userDTO: UserDTO): ModelAndView {
        if(userService.signUp(userDTO) == null){
            return ModelAndView("signup/signup")
        }
        return ModelAndView("login/login")
    }
}