package com.example.mvcboard.controller

import com.example.mvcboard.dto.UserDTO
import com.example.mvcboard.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView


@RestController
class UserController(private val userService: UserService) {

    val logger = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/user/login")
    fun loginView() : ModelAndView{
        return ModelAndView("user/login")
    }
    @GetMapping("/user/join")
    fun joinView(): ModelAndView {
        return ModelAndView("user/signup")
    }
    @GetMapping("/user/{userNo}")
    fun editView() : ModelAndView{
        return ModelAndView("user/edit")
    }

    @PostMapping("/api/user/login")
    fun login(@ModelAttribute userDTO: UserDTO): ModelAndView{
        var u = userService.login(userDTO)

        if(u == null){
            return ModelAndView("user/login")
        }
        logger.info("${u.userNo} 로그인")
        return ModelAndView("board/list")
    }
    @PostMapping("/api/user/join")
    fun signup(@ModelAttribute userDTO: UserDTO): ModelAndView {
        if(userService.signUp(userDTO) == null){
            return ModelAndView("user/join")
        }
        return ModelAndView("user/login")
    }

    @PutMapping("/api/user/{userNo}")
    fun userUpdate(@PathVariable("userNo")userNo : Long, @ModelAttribute userDTO: UserDTO) : ModelAndView{
        userService.userUpdate(userNo, userDTO)
        return ModelAndView()
    }

    @DeleteMapping("/api/user/{userNo}")
    fun userDelete(@PathVariable("userNo")userNo: Long){
        userService.userDelete(userNo)
    }
}