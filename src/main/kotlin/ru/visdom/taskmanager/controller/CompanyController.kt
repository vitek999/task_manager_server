package ru.visdom.taskmanager.controller

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.visdom.taskmanager.exception.CompanyNotFoundException
import ru.visdom.taskmanager.model.Company
import ru.visdom.taskmanager.service.CompanyService

@RestController
@RequestMapping("/company")
class CompanyController(private val companyService: CompanyService) {
    @GetMapping("/")
    fun getAll(): ResponseEntity<Iterable<Company>> {
        return try {
            ResponseEntity(companyService.getAll(), HttpStatus.OK)
        } catch (e: CompanyNotFoundException) {
            ResponseEntity(HttpStatus.NO_CONTENT)
        }
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Company> {
        return try {
            ResponseEntity(companyService.getById(id), HttpStatus.OK)
        } catch (e: CompanyNotFoundException) {
            ResponseEntity(HttpStatus.NO_CONTENT)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        return try {
            ResponseEntity(companyService.deleteById(id), HttpStatus.OK)
        } catch (e: DataIntegrityViolationException) {
            ResponseEntity(HttpStatus.CONFLICT)
        }
    }

    @PostMapping("/")
    fun insert(@RequestBody company: Company): ResponseEntity<Unit> =
            ResponseEntity(companyService.insert(company), HttpStatus.CREATED)

    @PutMapping("/")
    fun update(@RequestBody company: Company): ResponseEntity<Unit> {
        return try {
            ResponseEntity(companyService.update(company), HttpStatus.OK)
        } catch (e: CompanyNotFoundException) {
            ResponseEntity(HttpStatus.OK)
        }
    }
}