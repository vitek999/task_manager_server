package ru.visdom.taskmanager.model

import javax.persistence.*

@Entity
@Table(name = "subdivision")
data class Subdivision (
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "name")
        val name: String,

        @Column(name = "desciption")
        val description: String,

        @Column(name = "company_id")
        val companyId: Long
)