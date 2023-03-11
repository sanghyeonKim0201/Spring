package com.example.mvcboard.controller

import com.example.mvcboard.dto.UserDTO
import com.example.mvcboard.service.UserService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView


@RestController
class UserController(private val userService: UserService) {

    val logger = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/users/login")
    fun loginView() : ModelAndView{
        return ModelAndView("users/login")
    }
    @GetMapping("/users/join")
    fun joinView(): ModelAndView {
        return ModelAndView("users/join")
    }
    @GetMapping("/users/{userNo}")
    fun editView(@PathVariable("userNo")userNo: Long, model: Model) : ModelAndView{

        return ModelAndView("users/edit")
    }

    @PostMapping("/api/users/login")
    fun login(@RequestBody userDTO: UserDTO): ModelAndView{
        var u = userService.login(userDTO)

        if(u == null){
            return ModelAndView("users/login")
        }
        logger.info("${u.userNo} 로그인")
        return ModelAndView("redirect:posts/list")
    }
    @PostMapping("/api/users/join")
    fun join(@RequestBody @Valid userDTO: UserDTO, bindingResult: BindingResult): ModelAndView {
        if(bindingResult.hasErrors()){
            logger.error("errors : ${bindingResult.fieldError}")
            var field = bindingResult.allErrors.stream().findAny().map { (it as FieldError).field }.get()
            var defaultMessage = bindingResult.allErrors.stream().findAny().map { it.defaultMessage }.get()
            logger.error("${field}, ${defaultMessage}")
            return ModelAndView("users/join").addObject("message", "${field}")
        }

        return userService.join(userDTO)
    }


    @PutMapping("/api/users/{userNo}")
    fun userUpdate(@PathVariable("userNo")userNo : Long, @RequestBody @Valid userDTO: UserDTO) : ModelAndView{
        logger.info("put 입니다")
        userService.userUpdate(userNo, userDTO)
        return ModelAndView("users/edit").addObject("message", "정보 수정 완료")
    }

    @DeleteMapping("/api/users/{userNo}")
    fun userDelete(@PathVariable("userNo")userNo: Long) : ModelAndView{
        logger.info("delete 입니다")
        userService.userDelete(userNo)
        return ModelAndView("redirect:/")
    }
}