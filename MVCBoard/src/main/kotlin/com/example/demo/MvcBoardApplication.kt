package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MvcBoardApplication

fun main(args: Array<String>) {
	runApplication<MvcBoardApplication>(*args)
}
