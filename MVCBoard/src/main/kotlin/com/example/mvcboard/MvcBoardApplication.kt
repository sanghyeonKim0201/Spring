package com.example.mvcboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class MvcBoardApplication

fun main(args: Array<String>) {
	runApplication<MvcBoardApplication>(*args)
}
